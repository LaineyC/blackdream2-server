package pers.laineyc.blackdream.configuration.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.laineyc.blackdream.configuration.constant.RunLogLevelEnum;
import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.parameter.RunLogSendParameter;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.exception.ErrorCode;
import pers.laineyc.blackdream.framework.exception.ErrorCodes;
import pers.laineyc.blackdream.framework.model.Auth;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LaineyC
 */
@Aspect
@Order(1)
public class RunLogInterceptor {

	@Autowired
	private RunLogService runLogService;

	@Around("execution(public * pers.laineyc.blackdream.*.action.*.controller.*.*(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		Method targetMethod = methodSignature.getMethod();

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest httpServletRequest = attributes.getRequest();
		HttpSession httpSession = httpServletRequest.getSession();
		Auth auth = (Auth) httpSession.getAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

		String uri = httpServletRequest.getRequestURI();
		String[] values = uri.split("/");
		String action = values[values.length - 3] + "/" + values[values.length - 2] + "/" + values[values.length - 1];

		Request request = (Request) point.getArgs()[0];
		request.setAuth(auth);

		Map<String, Object> commonParameter = new HashMap<>();
		Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
		while (parameterNames.hasMoreElements()){
			String name = parameterNames.nextElement();
			commonParameter.put(name, httpServletRequest.getParameter(name));
		}

		RunLogSendParameter runLogSendParameter = new RunLogSendParameter();
		runLogSendParameter.setInvokeTime(new Date());

		Object result = null;
		long startTime = System.nanoTime();
		try {
			result = point.proceed();
			runLogSendParameter.setLevel(RunLogLevelEnum.INFO.getCode());
			runLogSendParameter.setAction(action);
			runLogSendParameter.setMessage("normal");
			runLogSendParameter.setAuthParameter(auth);
			runLogSendParameter.setRunTime((System.nanoTime() - startTime) / 1000000);
			runLogSendParameter.setCommonParameter(commonParameter);
			runLogSendParameter.setRequestParameter(request);
			runLogService.send(runLogSendParameter);
		}
		catch (BusinessException exception) {
			ErrorCode errorCode = exception.getErrorCode();

			if(exception.getCause() == null) {
				runLogSendParameter.setLevel(RunLogLevelEnum.WARN.getCode());
				runLogSendParameter.setAction(action);
				runLogSendParameter.setMessage(errorCode.getMessage());
				runLogSendParameter.setAuthParameter(auth);
				runLogSendParameter.setRunTime((System.nanoTime() - startTime) / 1000000);
				runLogSendParameter.setCommonParameter(commonParameter);
				runLogSendParameter.setRequestParameter(request);
				runLogService.send(runLogSendParameter);
			}
			else{
				runLogSendParameter.setLevel(RunLogLevelEnum.ERROR.getCode());
				runLogSendParameter.setAction(action);
				runLogSendParameter.setMessage(errorCode.getMessage());
				runLogSendParameter.setAuthParameter(auth);
				runLogSendParameter.setRunTime((System.nanoTime() - startTime) / 1000000);
				runLogSendParameter.setCommonParameter(commonParameter);
				runLogSendParameter.setRequestParameter(request);
				runLogSendParameter.setException(exception);
				runLogService.send(runLogSendParameter);
			}

			if (targetMethod.getAnnotation(ResponseBody.class) != null) {
				Class returnType = targetMethod.getReturnType();
				if (Response.class.isAssignableFrom(returnType)) {
					Response<?> response = (Response<?>) returnType.newInstance();
					response.setError(exception.getErrorCode());
					return response;
				}
			}
		}
		catch (Exception exception) {
			ErrorCode errorCode = ErrorCodes.EC_001001;

			runLogSendParameter.setLevel(RunLogLevelEnum.ERROR.getCode());
			runLogSendParameter.setAction(action);
			runLogSendParameter.setMessage(errorCode.getMessage());
			runLogSendParameter.setAuthParameter(auth);
			runLogSendParameter.setRunTime((System.nanoTime() - startTime) / 1000000);
			runLogSendParameter.setCommonParameter(commonParameter);
			runLogSendParameter.setRequestParameter(request);
			runLogSendParameter.setException(exception);
			runLogService.send(runLogSendParameter);

			if (targetMethod.getAnnotation(ResponseBody.class) != null) {
				Class returnType = targetMethod.getReturnType();
				if (Response.class.isAssignableFrom(returnType)) {
					Response<?> response = (Response<?>) returnType.newInstance();
					response.setError(ErrorCodes.EC_001001);
					return response;
				}
			}
			else{
				throw exception;
			}
		}
		return result;

	}
}
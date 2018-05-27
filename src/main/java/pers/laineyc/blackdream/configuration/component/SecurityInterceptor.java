package pers.laineyc.blackdream.configuration.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.laineyc.blackdream.configuration.constant.AccessLevelEnum;
import pers.laineyc.blackdream.configuration.config.Security;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.exception.ErrorCodes;
import pers.laineyc.blackdream.framework.model.Auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author LaineyC
 */
@Aspect
@Order(4)
public class SecurityInterceptor {

    @Around("execution(public * pers.laineyc.blackdream.*.action.*.controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method targetMethod = methodSignature.getMethod();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        HttpSession httpSession = httpServletRequest.getSession();
        Auth auth = (Auth) httpSession.getAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        Security security = targetMethod.getAnnotation(Security.class);

        if(security == null){
            return point.proceed();
        }

        AccessLevelEnum accessLevel = security.accessLevel();

        if(accessLevel == AccessLevelEnum.PROTECTED){
            if(auth == null || auth.getUserId() == null){
                throw new BusinessException(ErrorCodes.EC_001002);
            }
        }

        return point.proceed();
    }
}
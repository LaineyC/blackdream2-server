package pers.laineyc.blackdream.usercenter.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.usercenter.constant.TokenSignInConfigConstant;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.service.parameter.UserTokenSignInParameter;
import pers.laineyc.blackdream.usercenter.tool.UserServiceTool;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author LaineyC
 */
@Aspect
@Order(2)
public class TokenSignInInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceTool userServiceTool;

    @Around("execution(public * pers.laineyc.blackdream.*.action.*.controller.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method targetMethod = methodSignature.getMethod();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        HttpSession httpSession = httpServletRequest.getSession(false);
        Auth auth = (Auth)httpSession.getAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        AuthSecurity authSecurity = targetMethod.getAnnotation(AuthSecurity.class);
        boolean isPublic = false;
        if(authSecurity == null || !authSecurity.notNull()){
            isPublic = true;
        }

        Cookie[] cookies = httpServletRequest.getCookies();
        if(auth == null && cookies != null && !isPublic) {
            String username = null;
            String accessToken = null;

            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (TokenSignInConfigConstant.COOKIE_USERNAME_KEY.equals(cookieName)) {
                    username = cookie.getValue();
                }
                if (TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY.equals(cookieName)) {
                    accessToken = cookie.getValue();
                }
            }

            if(username != null && accessToken != null){
                UserTokenSignInParameter userTokenSignInParameter = new UserTokenSignInParameter();
                userTokenSignInParameter.setUsername(username);
                userTokenSignInParameter.setAccessToken(accessToken);
                User user = userService.tokenSignIn(userTokenSignInParameter);

                String userId = user.getId();

                userServiceTool.handleTokenSignInCookie(user.getUserAuth(), attributes.getResponse());

                auth = new Auth();
                auth.setUserType(user.getType());
                auth.setUserId(userId);

                httpSession.setAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY, auth);

                Request request = (Request)point.getArgs()[0];
                request.setAuth(auth);
            }
        }

        return point.proceed();
    }
}
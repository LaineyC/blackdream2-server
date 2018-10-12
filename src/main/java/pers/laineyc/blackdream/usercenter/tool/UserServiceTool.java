package pers.laineyc.blackdream.usercenter.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.util.RegexUtil;
import pers.laineyc.blackdream.usercenter.constant.TokenSignInConfigConstant;
import pers.laineyc.blackdream.usercenter.model.AccessToken;
import pers.laineyc.blackdream.usercenter.model.AccessTokenBody;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 用户ServiceTool
 * @author LaineyC
 */
@Component
public class UserServiceTool{

    @Autowired
    private AccessTokenTool accessTokenTool;

    public static final String REGEX_PASSWORD = "^[\\x21-\\x7eA-Za-z0-9`！￥…（）—【】、；：‘“，《。》、？]{8,20}$";

    public static final String REGEX_NICKNAME = "^[a-zA-Z\\u4E00-\\u9FA5]{1,60}$";

    public static final String REGEX_USERNAME = "^[a-zA-Z\\u4E00-\\u9FA5]{1,20}$";

    public UserServiceTool() {

	}

    public boolean isPassword(String password) {
        if(password == null){
            return false;
        }
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    public boolean isEmail(String email) {
        return RegexUtil.isEmail(email);
    }

    public boolean isUsername(String username){
        if(username == null){
            return false;
        }
        return Pattern.matches(REGEX_USERNAME, username);
    }

    public void clearSignInCookie(HttpServletResponse httpServletResponse){
        handleTokenSignInCookie(0, new Auth(), httpServletResponse);
    }

    public void handleTokenSignInCookie(Auth auth, HttpServletResponse httpServletResponse){
        handleTokenSignInCookie(TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_EXPIRE_DAYS, auth, httpServletResponse);
    }

    public void handleTokenSignInCookie(int days, Auth auth, HttpServletResponse httpServletResponse){
        long maxAge = 24L * 60 * 60 * 1000 * days;
        int cookieMaxAge = 24 * 60 * 60 * days;

        String token = "";
        if(maxAge != 0 && auth != null){
            String userId = auth.getUserId();
            AccessToken accessToken = new AccessToken();
            accessToken.setExpiryTime(new Date(System.currentTimeMillis() + maxAge));
            AccessTokenBody accessTokenBody = new AccessTokenBody();
            accessTokenBody.setUserId(userId);
            accessToken.setBody(accessTokenBody);
            token = accessTokenTool.format(accessToken);
        }

        Cookie accessTokenCookie = new Cookie(TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY, token);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(cookieMaxAge);
        httpServletResponse.addCookie(accessTokenCookie);
    }

    /**
     * 用户修改Validate
     */
    public void updateValidate(UserUpdateParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }

        String nickname = parameter.getNickname();

        String iconFileId = parameter.getIconFileId();

        String username = parameter.getUsername();

        String email = parameter.getEmail();
    }
    
    /**
     * 用户单个查询Validate
     */
    public void getValidate(UserGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 用户多个查询Validate
     */
    public void queryValidate(UserQueryParameter parameter) {

    }

    /**
     * 用户分页查询Validate
     */
    public void searchValidate(UserSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }

    /**
     * 用户登录Validate
     */
    public void signInValidate(UserSignInParameter parameter) {
        String username = parameter.getUsername();
        if(!StringUtils.hasText(username)){
            throw new BusinessException("缺少用户名参数");
        }

        if(username.length() > 100){
            throw new BusinessException("用户名或邮箱长度不能超过100");
        }

        String password = parameter.getPassword();
        if(!StringUtils.hasText(password)){
            throw new BusinessException("缺少密码");
        }
        if(!RegexUtil.isPassword(password)){
            throw new BusinessException("密码格式不正确");
        }
    }

    /**
     * 用户令牌登录Validate
     */
    public void tokenSignInValidate(UserTokenSignInParameter parameter) {

    }
    
    /**
     * 用户退出Validate
     */
    public void signOutValidate(UserSignOutParameter parameter) {

    }
    
    /**
     * 用户注册Validate
     */
    public void signUpValidate(UserSignUpParameter parameter) {
        String username = parameter.getUsername();
        if(!StringUtils.hasText(username)){
            throw new BusinessException("缺少用户名参数");
        }

        if(!RegexUtil.isUsername(username)){
            throw new BusinessException("用户名格式不正确（4到16位字母开头、数字）");
        }

        String email = parameter.getEmail();
        if(!StringUtils.hasText(email)){
            throw new BusinessException("缺少邮箱参数");
        }

        if(email.length() > 100){
            throw new BusinessException("邮箱超度不鞥呢超过100");
        }

        if(!RegexUtil.isEmail(email)){
            throw new BusinessException("邮箱格式不正确");
        }

        String validCode = parameter.getValidCode();
        if(!StringUtils.hasText(validCode)){
            throw new BusinessException("缺少验证码");
        }

        if(validCode.length() > 6){
            throw new BusinessException("验证码格式不正确（4到24位字母、数字）");
        }

        String password = parameter.getPassword();
        if(!StringUtils.hasText(password)){
            throw new BusinessException("缺少密码");
        }
        if(!RegexUtil.isPassword(password)){
            throw new BusinessException("密码格式不正确");
        }
    }

    /**
     * 用户注册验证码发送Validate
     */
    public void signUpEmailValidCodeSendValidate(UserSignUpEmailValidCodeSendParameter parameter) {
        String email = parameter.getEmail();
        if(!StringUtils.hasText(email)){
            throw new BusinessException("缺少邮箱参数");
        }

        if(!RegexUtil.isEmail(email)){
            throw new BusinessException("邮箱格式不正确");
        }
    }
    
    /**
     * 用户密码修改Validate
     */
    public void passwordUpdateValidate(UserPasswordChangeParameter parameter) {

    }

    public void usernameExistValidate(UserUsernameExistParameter parameter) {

    }

    /**
     * 用户头像更改Validate
     */
    public void iconUpdateValidate(UserIconChangeParameter parameter) {

    }

    /**
     * 用户单个查询Validate
     */
    public void infoGetValidate(UserInfoGetParameter parameter) {

    }

}
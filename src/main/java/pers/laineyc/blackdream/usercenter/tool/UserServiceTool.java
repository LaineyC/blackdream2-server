package pers.laineyc.blackdream.usercenter.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.RegexUtil;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import java.util.regex.Pattern;

/**
 * 用户ServiceTool
 * @author LaineyC
 */
@Component
public class UserServiceTool{

    @Autowired
    private UserDao userDao;

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

    /**
     * 用户修改Validate
     */
    public void updateValidate(UserUpdateParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
        
        Integer status = parameter.getStatus();

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
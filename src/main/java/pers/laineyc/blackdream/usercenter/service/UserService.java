package pers.laineyc.blackdream.usercenter.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.usercenter.service.domain.UserAuth;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import java.util.List; 

/**
 * 用户Service
 * @author LaineyC
 */
public interface UserService extends Service{

    /**
     * 用户修改
     */
    User update(UserUpdateParameter parameter);
    
    /**
     * 用户单个查询
     */
    User get(UserGetParameter parameter);

    /**
     * 用户多个查询
     */
    List<User> query(UserQueryParameter parameter);

    /**
     * 用户分页查询
     */
    PageResult<User> search(UserSearchParameter parameter);

    /**
     * 用户登录
     */
    User signIn(UserSignInParameter parameter);

    /**
     * 用户登录
     */
    User tokenSignIn(UserTokenSignInParameter parameter);

    /**
     * 用户退出
     */
    User signOut(UserSignOutParameter parameter);
    
    /**
     * 用户注册
     */
    User signUp(UserSignUpParameter parameter);
    
    /**
     * 用户密码更改
     */
    User passwordChange(UserPasswordChangeParameter parameter);

    /**
     * 用户名测存在
     */
    Boolean usernameExist(UserUsernameExistParameter parameter);

    /**
     * 用户头像更改
     */
    User iconChange(UserIconChangeParameter parameter);

    /**
     * 用户单个查询
     */
    User infoGet(UserInfoGetParameter parameter);
}
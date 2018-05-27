package pers.laineyc.blackdream.usercenter.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.service.parameter.UserUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.usercenter.service.parameter.UserGetParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserQueryParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserSearchParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserSignInParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserSignOutParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserSignUpParameter;
import pers.laineyc.blackdream.usercenter.service.parameter.UserPasswordChangeParameter;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import java.util.List;

/**
 * 用户ServiceTest
 * @author LaineyC
 */
public class UserServiceTest extends BaseServiceTest {

    @Autowired
    private UserService userService;
    
    public UserServiceTest(){

    }

    /**
     * 用户修改Test
     */
    @Test
    public void update() {
        UserUpdateParameter parameter = new UserUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setStatus(0);
        parameter.setNickname("");
        parameter.setIconFileId(0L);
        parameter.setUsername("");
        parameter.setEmail("");
        User user = userService.update(parameter);
        Assert.assertNotNull(user);
    }
    
    /**
     * 用户单个查询Test
     */
    @Test
    public void get(){
        UserGetParameter parameter = new UserGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        User user = userService.get(parameter);
        Assert.assertNotNull(user);
    }

    /**
     * 用户多个查询Test
     */
    @Test
    public void query() {
        UserQueryParameter parameter = new UserQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setStatus(0);
        parameter.setNickname("");
        parameter.setIconFileId(0L);
        parameter.setUsername("");
        parameter.setEmail("");
        List<User> list = userService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 用户分页查询Test
     */
    @Test
    public void search() {
        UserSearchParameter parameter = new UserSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setStatus(0);
        parameter.setNickname("");
        parameter.setIconFileId(0L);
        parameter.setUsername("");
        parameter.setEmail("");
        PageResult<User> pageResult = userService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 用户登录Test
     */
    @Test
    public void signIn() {
        UserSignInParameter parameter = new UserSignInParameter();
        parameter.setAuth(getAuth());
        User user = userService.signIn(parameter);
        Assert.assertNotNull(user);
    }

    /**
     * 用户退出Test
     */
    @Test
    public void signOut() {
        UserSignOutParameter parameter = new UserSignOutParameter();
        parameter.setAuth(getAuth());
        User user = userService.signOut(parameter);
        Assert.assertNotNull(user);
    }

    /**
     * 用户注册Test
     */
    @Test
    public void signUp() {
        UserSignUpParameter parameter = new UserSignUpParameter();
        parameter.setAuth(getAuth());
        User user = userService.signUp(parameter);
        Assert.assertNotNull(user);
    }

    /**
     * 用户密码修改Test
     */
    @Test
    public void passwordChange() {
        UserPasswordChangeParameter parameter = new UserPasswordChangeParameter();
        parameter.setAuth(getAuth());
        User user = userService.passwordChange(parameter);
        Assert.assertNotNull(user);
    }

}
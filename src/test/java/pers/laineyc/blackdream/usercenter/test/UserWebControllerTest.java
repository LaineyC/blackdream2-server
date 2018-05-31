package pers.laineyc.blackdream.usercenter.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.usercenter.action.web.request.UserUpdateWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserUpdateWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserGetWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserGetWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserQueryWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserQueryWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserSearchWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserSearchWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserSignInWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserSignInWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserSignOutWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserSignOutWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserSignUpWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserSignUpWebResponse;
import pers.laineyc.blackdream.usercenter.action.web.request.UserPasswordChangeWebRequest;
import pers.laineyc.blackdream.usercenter.action.web.response.UserPasswordChangeWebResponse;

/**
 * 用户ControllerTest
 * @author LaineyC
 */
public class UserWebControllerTest extends BaseWebControllerTest {

    public UserWebControllerTest(){

    }

    /**
     * 用户修改Test
     */
    @Test
    public void update() throws Exception {
        UserUpdateWebRequest request = new UserUpdateWebRequest();
        request.setId("");
        request.setStatus(0);
        request.setNickname("");
        request.setIconFileId("");
        request.setUsername("");
        request.setEmail("");
        UserUpdateWebResponse response = execute(request, UserUpdateWebResponse.class, "/user/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 用户单个查询Test
     */
    @Test
    public void get() throws Exception {
        UserGetWebRequest request = new UserGetWebRequest();
        request.setId("");
        UserGetWebResponse response = execute(request, UserGetWebResponse.class, "/user/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户多个查询Test
     */
    @Test
    public void query() throws Exception {
        UserQueryWebRequest request = new UserQueryWebRequest();
        request.setStatus(0);
        request.setNickname("");
        request.setIconFileId("");
        request.setUsername("");
        request.setEmail("");
        UserQueryWebResponse response = execute(request, UserQueryWebResponse.class, "/user/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户分页查询Test
     */
    @Test
    public void search() throws Exception {
        UserSearchWebRequest request = new UserSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setStatus(0);
        request.setNickname("");
        request.setIconFileId("");
        request.setUsername("");
        request.setEmail("");
        UserSearchWebResponse response = execute(request, UserSearchWebResponse.class, "/user/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户登录Test
     */
    @Test
    public void signIn() throws Exception {
        UserSignInWebRequest request = new UserSignInWebRequest();
        UserSignInWebResponse response = execute(request, UserSignInWebResponse.class, "/user/signIn");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户退出Test
     */
    @Test
    public void signOut() throws Exception {
        UserSignOutWebRequest request = new UserSignOutWebRequest();
        UserSignOutWebResponse response = execute(request, UserSignOutWebResponse.class, "/user/signOut");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户注册Test
     */
    @Test
    public void signUp() throws Exception {
        UserSignUpWebRequest request = new UserSignUpWebRequest();
        UserSignUpWebResponse response = execute(request, UserSignUpWebResponse.class, "/user/signUp");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 用户密码修改Test
     */
    @Test
    public void passwordUpdate() throws Exception {
        UserPasswordChangeWebRequest request = new UserPasswordChangeWebRequest();
        UserPasswordChangeWebResponse response = execute(request, UserPasswordChangeWebResponse.class, "/user/passwordChange");
        Assert.assertNotNull(response.getBody());
    }

}
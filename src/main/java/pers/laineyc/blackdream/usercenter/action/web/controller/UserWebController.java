package pers.laineyc.blackdream.usercenter.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.foundation.service.domain.ValidCode;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.usercenter.action.web.request.*;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.tool.UserServiceTool;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户Controller
 * @author LaineyC
 */
@Api(tags = "User", description = "用户接口")
@Controller
public class UserWebController extends BaseWebController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceTool userServiceTool;
    
    public UserWebController() {

    }
/*
    @ApiOperation(value = "用户修改")
    @PostMapping(value = "/user/update")
    public @ResponseBody Response<User> update(@RequestBody UserUpdateWebRequest request) {

        UserUpdateParameter parameter = new UserUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.update(parameter);

        return new Response<>(user);

    }
*/
    @ApiOperation(value = "用户单个查询")
    @PostMapping(value = "/user/get")
    public @ResponseBody Response<User> get(@RequestBody UserGetWebRequest request) {
        UserGetParameter parameter = new UserGetParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.get(parameter);

        return new Response<>(user);
    }
/*
    @ApiOperation(value="用户多个查询")
    @PostMapping(value = "/user/query")
    public @ResponseBody Response<List<User>> query(@RequestBody UserQueryWebRequest request) {
        UserQueryParameter parameter = new UserQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<User> userList = userService.query(parameter);

        return new Response<>(userList);
    }

    @ApiOperation(value = "用户分页查询")
    @PostMapping(value = "/user/search")
    public @ResponseBody Response<PageResult<User>> search(@RequestBody UserSearchWebRequest request) {
        UserSearchParameter parameter = new UserSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<User> userPageResult = userService.search(parameter);

        return new Response<>(userPageResult);
    }
*/
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/user/signIn")
    public @ResponseBody Response<User> signIn(@RequestBody UserSignInWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignInParameter parameter = new UserSignInParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signIn(parameter);

        Auth auth = new Auth();
        auth.setUserId(user.getId());
        auth.setUserType(user.getType());

        userServiceTool.handleTokenSignInCookie(auth, httpServletResponse);

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.setAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY, auth);

        return new Response<>(user);
    }
    
    @ApiOperation(value = "用户退出")
    @PostMapping(value = "/user/signOut")
    public @ResponseBody Response<User> signOut(@RequestBody UserSignOutWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignOutParameter parameter = new UserSignOutParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signOut(parameter);

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.removeAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        userServiceTool.clearSignInCookie(httpServletResponse);

        return new Response<>(user);
    }

    @ApiOperation(value = "用户注册邮箱验证码发送")
    @PostMapping(value = "/user/signUpEmailValidCodeSend")
    public @ResponseBody Response<ValidCode> signUpEmailValidCodeSend(@RequestBody UserSignUpEmailValidCodeSendWebRequest request, HttpServletRequest httpServletRequest) {
        UserSignUpEmailValidCodeSendParameter parameter = new UserSignUpEmailValidCodeSendParameter();
        BeanUtils.copyProperties(request, parameter);

        ValidCode validCode = userService.signUpEmailValidCodeSend(parameter);

        return new Response<>(validCode);
    }
    
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/user/signUp")
    public @ResponseBody Response<User> signUp(@RequestBody UserSignUpWebRequest request, HttpServletRequest httpServletRequest) {
        UserSignUpParameter parameter = new UserSignUpParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signUp(parameter);

        return new Response<>(user);
    }

    @AuthSecurity
    @ApiOperation(value = "用户密码更改")
    @PostMapping(value = "/user/passwordChange")
    public @ResponseBody Response<User> passwordChange(@RequestBody UserPasswordChangeWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserPasswordChangeParameter parameter = new UserPasswordChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.passwordChange(parameter);

        HttpSession httpSession = httpServletRequest.getSession(false);
        Auth auth = (Auth)httpSession.getAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        userServiceTool.handleTokenSignInCookie(auth, httpServletResponse);

        return new Response<>(user);
    }

    @ApiOperation(value = "用户名测存在")
    @PostMapping(value = "/user/usernameExist")
    public @ResponseBody Response<Boolean> usernameExist(@RequestBody UserUsernameExistWebRequest request) {
        UserUsernameExistParameter parameter = new UserUsernameExistParameter();
        BeanUtils.copyProperties(request, parameter);

        Boolean usernameExist = userService.usernameExist(parameter);

        return new Response<>(usernameExist);
    }

    @ApiOperation(value = "用户头像更改")
    @PostMapping(value = "/user/iconChange")
    public @ResponseBody Response<User> iconChange(@RequestBody UserIconChangeWebRequest request) {
        UserIconChangeParameter parameter = new UserIconChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.iconChange(parameter);

        return new Response<>(user);
    }

    @AuthSecurity
    @ApiOperation(value = "用户单个查询")
    @PostMapping(value = "/user/infoGet")
    public @ResponseBody Response<User> infoGet(@RequestBody UserInfoGetWebRequest request) {
        UserInfoGetParameter parameter = new UserInfoGetParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.infoGet(parameter);

        return new Response<>(user);
    }
    
}

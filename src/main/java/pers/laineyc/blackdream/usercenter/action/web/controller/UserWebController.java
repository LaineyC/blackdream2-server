package pers.laineyc.blackdream.usercenter.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.usercenter.action.web.request.*;
import pers.laineyc.blackdream.usercenter.action.web.vo.*;
import pers.laineyc.blackdream.usercenter.constant.UserSignUpEmailValidCode;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.usercenter.service.domain.UserAuth;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.tool.EmailValidCode;
import pers.laineyc.blackdream.usercenter.tool.EmailValidCodeTool;
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
    private EmailValidCodeTool emailValidCodeTool;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceTool userServiceTool;
    
    public UserWebController() {

    }
/*
    @ApiOperation(value = "用户修改")
    @PostMapping(value = "/user/update")
    public @ResponseBody Response<UserUpdateWebVo> update(@RequestBody UserUpdateWebRequest request) {

        UserUpdateParameter parameter = new UserUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.update(parameter);

        UserUpdateWebVo userUpdateWebVo = new UserUpdateWebVo();
        BeanUtils.copyProperties(user, userUpdateWebVo);

        return new Response<>(userUpdateWebVo);

    }
*/
    @ApiOperation(value = "用户单个查询")
    @PostMapping(value = "/user/get")
    public @ResponseBody Response<UserGetWebVo> get(@RequestBody UserGetWebRequest request) {
        UserGetParameter parameter = new UserGetParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.get(parameter);

        UserGetWebVo userGetWebVo = new UserGetWebVo();
        BeanUtils.copyProperties(user, userGetWebVo);

        return new Response<>(userGetWebVo);
    }
/*
    @ApiOperation(value="用户多个查询")
    @PostMapping(value = "/user/query")
    public @ResponseBody Response<List<UserQueryWebVo>> query(@RequestBody UserQueryWebRequest request) {
        UserQueryParameter parameter = new UserQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<User> userList = userService.query(parameter);

        List<UserQueryWebVo> userQueryWebVoList = new ArrayList<>();
        userList.forEach(user -> {
            UserQueryWebVo userQueryWebVo = new UserQueryWebVo();
            BeanUtils.copyProperties(user, userQueryWebVo);
            userQueryWebVoList.add(userQueryWebVo);
        });

        return new Response<>(userQueryWebVoList);
    }

    @ApiOperation(value = "用户分页查询")
    @PostMapping(value = "/user/search")
    public @ResponseBody Response<PageResult<UserSearchWebVo>> search(@RequestBody UserSearchWebRequest request) {
        UserSearchParameter parameter = new UserSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<User> userPageResult = userService.search(parameter);

        PageResult<UserSearchWebVo> userSearchWebVoPageResult = new PageResult<>();
        userSearchWebVoPageResult.setTotal(userPageResult.getTotal());
        List<UserSearchWebVo> userSearchWebVoList = userSearchWebVoPageResult.getRecords();
        userPageResult.getRecords().forEach(user -> {
            UserSearchWebVo userSearchWebVo = new UserSearchWebVo();
            BeanUtils.copyProperties(user, userSearchWebVo);
            userSearchWebVoList.add(userSearchWebVo);
        });

        return new Response<>(userSearchWebVoPageResult);
    }
*/
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/user/signIn")
    public @ResponseBody Response<UserSignInWebVo> signIn(@RequestBody UserSignInWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignInParameter parameter = new UserSignInParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signIn(parameter);

        String userId = user.getId();

        userServiceTool.handleTokenSignInCookie(user.getUserAuth(), httpServletResponse);

        Auth auth = new Auth();
        auth.setUserId(userId);
        auth.setUserType(user.getType());

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.setAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY, auth);

        UserSignInWebVo userSignInWebVo = new UserSignInWebVo();

        return new Response<>(userSignInWebVo);
    }
    
    @ApiOperation(value = "用户退出")
    @PostMapping(value = "/user/signOut")
    public @ResponseBody Response<UserSignOutWebVo> signOut(@RequestBody UserSignOutWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignOutParameter parameter = new UserSignOutParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signOut(parameter);

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.removeAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        userServiceTool.clearSignInCookie(httpServletResponse);

        UserSignOutWebVo userSignOutWebVo = new UserSignOutWebVo();

        return new Response<>(userSignOutWebVo);
    }

    @ApiOperation(value = "用户注册邮箱验证码发送")
    @PostMapping(value = "/user/signUpEmailValidCodeSend")
    public @ResponseBody Response<UserSignUpEmailValidCodeSendWebVo> signUpEmailValidCodeSend(@RequestBody UserSignUpEmailValidCodeSendWebRequest request, HttpServletRequest httpServletRequest) {
        UserSignUpParameter parameter = new UserSignUpParameter();
        BeanUtils.copyProperties(request, parameter);

        String email = request.getEmail();
        EmailValidCode validCode = emailValidCodeTool.send(email, "欢迎注册BlackDream", "您的注册验证码：" + EmailValidCodeTool.VALID_CODE_PLACE, UserSignUpEmailValidCode.class.getName(), httpServletRequest);

        UserSignUpEmailValidCodeSendWebVo userSignUpEmailValidCodeSendWebVo = new UserSignUpEmailValidCodeSendWebVo();
        BeanUtils.copyProperties(validCode, userSignUpEmailValidCodeSendWebVo);

        return new Response<>(userSignUpEmailValidCodeSendWebVo);
    }
    
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/user/signUp")
    public @ResponseBody Response<UserSignUpWebVo> signUp(@RequestBody UserSignUpWebRequest request, HttpServletRequest httpServletRequest) {
        String email = request.getEmail();
        String validCode = request.getValidCode();
        emailValidCodeTool.check(email, validCode, UserSignUpEmailValidCode.class.getName(), httpServletRequest);

        UserSignUpParameter parameter = new UserSignUpParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signUp(parameter);

        UserSignUpWebVo userSignUpWebVo = new UserSignUpWebVo();
        BeanUtils.copyProperties(user, userSignUpWebVo);

        return new Response<>(userSignUpWebVo);
    }

    @AuthSecurity
    @ApiOperation(value = "用户密码更改")
    @PostMapping(value = "/user/passwordChange")
    public @ResponseBody Response<UserPasswordChangeWebVo> passwordChange(@RequestBody UserPasswordChangeWebRequest request, HttpServletResponse httpServletResponse) {
        UserPasswordChangeParameter parameter = new UserPasswordChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.passwordChange(parameter);

        userServiceTool.handleTokenSignInCookie(user.getUserAuth(), httpServletResponse);

        UserPasswordChangeWebVo userPasswordUpdateWebVo = new UserPasswordChangeWebVo();

        return new Response<>(userPasswordUpdateWebVo);
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
    public @ResponseBody Response<UserIconChangeWebVo> iconChange(@RequestBody UserIconChangeWebRequest request) {
        UserIconChangeParameter parameter = new UserIconChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.iconChange(parameter);

        UserIconChangeWebVo userIconChangeWebVo = new UserIconChangeWebVo();
        BeanUtils.copyProperties(user, userIconChangeWebVo);

        return new Response<>(userIconChangeWebVo);
    }

    @AuthSecurity
    @ApiOperation(value = "用户单个查询")
    @PostMapping(value = "/user/infoGet")
    public @ResponseBody Response<UserInfoGetWebVo> infoGet(@RequestBody UserInfoGetWebRequest request) {
        UserInfoGetParameter parameter = new UserInfoGetParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.infoGet(parameter);

        UserInfoGetWebVo userInfoGetWebVo = new UserInfoGetWebVo();
        BeanUtils.copyProperties(user, userInfoGetWebVo);

        return new Response<>(userInfoGetWebVo);
    }
    
}

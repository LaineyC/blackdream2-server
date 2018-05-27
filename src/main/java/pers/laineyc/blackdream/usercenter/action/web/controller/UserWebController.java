package pers.laineyc.blackdream.usercenter.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.Security;
import pers.laineyc.blackdream.framework.constant.AuthConfigConstant;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.usercenter.action.web.request.*;
import pers.laineyc.blackdream.usercenter.action.web.response.*;
import pers.laineyc.blackdream.usercenter.action.web.vo.*;
import pers.laineyc.blackdream.usercenter.constant.TokenSignInConfigConstant;
import pers.laineyc.blackdream.usercenter.constant.UserSignUpEmailValidCode;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.service.parameter.*;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.service.UserService;
import pers.laineyc.blackdream.usercenter.tool.EmailValidCode;
import pers.laineyc.blackdream.usercenter.tool.EmailValidCodeTool;
import javax.servlet.http.Cookie;
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
    
    public UserWebController() {

    }
/*
    @ApiOperation(value = "用户修改")
    @PostMapping(value = "/user/update")
    public @ResponseBody UserUpdateWebResponse update(@RequestBody UserUpdateWebRequest request) {

        UserUpdateParameter parameter = new UserUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.update(parameter);

        UserUpdateWebVo userUpdateWebVo = new UserUpdateWebVo();
        BeanUtils.copyProperties(user, userUpdateWebVo);

        return new UserUpdateWebResponse(userUpdateWebVo);

    }

    @ApiOperation(value = "用户单个查询")
    @PostMapping(value = "/user/get")
    public @ResponseBody UserGetWebResponse get(@RequestBody UserGetWebRequest request) {
        UserGetParameter parameter = new UserGetParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.get(parameter);

        UserGetWebVo userGetWebVo = new UserGetWebVo();
        BeanUtils.copyProperties(user, userGetWebVo);

        return new UserGetWebResponse(userGetWebVo);
    }

    @ApiOperation(value="用户多个查询")
    @PostMapping(value = "/user/query")
    public @ResponseBody UserQueryWebResponse query(@RequestBody UserQueryWebRequest request) {
        UserQueryParameter parameter = new UserQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<User> userList = userService.query(parameter);

        List<UserQueryWebVo> userQueryWebVoList = new ArrayList<>();
        userList.forEach(user -> {
            UserQueryWebVo userQueryWebVo = new UserQueryWebVo();
            BeanUtils.copyProperties(user, userQueryWebVo);
            userQueryWebVoList.add(userQueryWebVo);
        });

        return new UserQueryWebResponse(userQueryWebVoList);
    }

    @ApiOperation(value = "用户分页查询")
    @PostMapping(value = "/user/search")
    public @ResponseBody UserSearchWebResponse search(@RequestBody UserSearchWebRequest request) {
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

        return new UserSearchWebResponse(userSearchWebVoPageResult);
    }
*/
    @ApiOperation(value = "用户登录")
    @PostMapping(value = "/user/signIn")
    public @ResponseBody UserSignInWebResponse signIn(@RequestBody UserSignInWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignInParameter parameter = new UserSignInParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signIn(parameter);

        Long userId = user.getId();

        int maxAge = 60 * 60 * 24 * 30;

        Cookie usernameCookie = new Cookie(TokenSignInConfigConstant.COOKIE_USERNAME_KEY,  userId.toString());
        usernameCookie.setPath("/");
        usernameCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(usernameCookie);

        Cookie accessTokenCookie = new Cookie(TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY, user.getAccessToken());
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(accessTokenCookie);

        Auth auth = new Auth();
        auth.setUserId(userId);

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.setAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY, auth);

        UserSignInWebVo userSignInWebVo = new UserSignInWebVo();

        return new UserSignInWebResponse(userSignInWebVo);
    }
    
    @ApiOperation(value = "用户退出")
    @PostMapping(value = "/user/signOut")
    public @ResponseBody UserSignOutWebResponse signOut(@RequestBody UserSignOutWebRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        UserSignOutParameter parameter = new UserSignOutParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signOut(parameter);

        HttpSession httpSession = httpServletRequest.getSession(false);
        httpSession.removeAttribute(AuthConfigConstant.SESSION_USER_AUTH_KEY);

        int maxAge = 0;

        Cookie usernameCookie = new Cookie(TokenSignInConfigConstant.COOKIE_USERNAME_KEY,  TokenSignInConfigConstant.COOKIE_USERNAME_KEY);
        usernameCookie.setPath("/");
        usernameCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(usernameCookie);

        Cookie accessTokenCookie = new Cookie(TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY, TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY);
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(accessTokenCookie);

        UserSignOutWebVo userSignOutWebVo = new UserSignOutWebVo();

        return new UserSignOutWebResponse(userSignOutWebVo);
    }

    @ApiOperation(value = "用户注册邮箱验证码发送")
    @PostMapping(value = "/user/signUpEmailValidCodeSend")
    public @ResponseBody UserSignUpEmailValidCodeSendWebResponse signUpEmailValidCodeSend(@RequestBody UserSignUpEmailValidCodeSendWebRequest request, HttpServletRequest httpServletRequest) {
        UserSignUpParameter parameter = new UserSignUpParameter();
        BeanUtils.copyProperties(request, parameter);

        String email = request.getEmail();
        EmailValidCode validCode = emailValidCodeTool.send(email, "欢迎注册BlackDream", "您的注册验证码：" + EmailValidCodeTool.VALID_CODE_PLACE, UserSignUpEmailValidCode.class.getName(), httpServletRequest);

        UserSignUpEmailValidCodeSendWebVo userSignUpEmailValidCodeSendWebVo = new UserSignUpEmailValidCodeSendWebVo();
        BeanUtils.copyProperties(validCode, userSignUpEmailValidCodeSendWebVo);

        return new UserSignUpEmailValidCodeSendWebResponse(userSignUpEmailValidCodeSendWebVo);
    }
    
    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/user/signUp")
    public @ResponseBody UserSignUpWebResponse signUp(@RequestBody UserSignUpWebRequest request, HttpServletRequest httpServletRequest) {
        String email = request.getEmail();
        String validCode = request.getValidCode();
        emailValidCodeTool.check(email, validCode, UserSignUpEmailValidCode.class.getName(), httpServletRequest);

        UserSignUpParameter parameter = new UserSignUpParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.signUp(parameter);

        UserSignUpWebVo userSignUpWebVo = new UserSignUpWebVo();
        BeanUtils.copyProperties(user, userSignUpWebVo);

        return new UserSignUpWebResponse(userSignUpWebVo);
    }

    @Security
    @ApiOperation(value = "用户密码更改")
    @PostMapping(value = "/user/passwordChange")
    public @ResponseBody
    UserPasswordChangeWebResponse passwordChange(@RequestBody UserPasswordChangeWebRequest request, HttpServletResponse httpServletResponse) {
        UserPasswordChangeParameter parameter = new UserPasswordChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.passwordChange(parameter);

        Long userId = user.getId();

        int maxAge = 60 * 60 * 24 * 30;

        Cookie usernameCookie = new Cookie(TokenSignInConfigConstant.COOKIE_USERNAME_KEY,  userId.toString());
        usernameCookie.setPath("/");
        usernameCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(usernameCookie);

        Cookie accessTokenCookie = new Cookie(TokenSignInConfigConstant.COOKIE_ACCESS_TOKEN_KEY, user.getAccessToken());
        accessTokenCookie.setPath("/");
        accessTokenCookie.setMaxAge(maxAge);
        httpServletResponse.addCookie(accessTokenCookie);

        UserPasswordChangeWebVo userPasswordUpdateWebVo = new UserPasswordChangeWebVo();

        return new UserPasswordChangeWebResponse(userPasswordUpdateWebVo);
    }

    @ApiOperation(value = "用户名测存在")
    @PostMapping(value = "/user/usernameExist")
    public @ResponseBody UserUsernameExistWebResponse usernameExist(@RequestBody UserUsernameExistWebRequest request) {
        UserUsernameExistParameter parameter = new UserUsernameExistParameter();
        BeanUtils.copyProperties(request, parameter);

        Boolean usernameExist = userService.usernameExist(parameter);

        return new UserUsernameExistWebResponse(usernameExist);
    }

    @ApiOperation(value = "用户头像更改")
    @PostMapping(value = "/user/iconChange")
    public @ResponseBody UserIconChangeWebResponse iconChange(@RequestBody UserIconChangeWebRequest request) {
        UserIconChangeParameter parameter = new UserIconChangeParameter();
        BeanUtils.copyProperties(request, parameter);

        User user = userService.iconChange(parameter);

        UserIconChangeWebVo userIconChangeWebVo = new UserIconChangeWebVo();
        BeanUtils.copyProperties(user, userIconChangeWebVo);

        return new UserIconChangeWebResponse(userIconChangeWebVo);
    }
    
}

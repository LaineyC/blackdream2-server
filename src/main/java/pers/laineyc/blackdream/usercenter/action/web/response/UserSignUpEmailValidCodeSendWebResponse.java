package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserSignUpEmailValidCodeSendWebVo;

/**
 * 用户注册邮箱验证码发送Response
 * @author LaineyC
 */
public class UserSignUpEmailValidCodeSendWebResponse extends Response<UserSignUpEmailValidCodeSendWebVo> {

    public UserSignUpEmailValidCodeSendWebResponse(){

    }

    public UserSignUpEmailValidCodeSendWebResponse(UserSignUpEmailValidCodeSendWebVo body){
        setBody(body);
    }

}
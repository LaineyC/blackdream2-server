package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserSignUpWebVo;

/**
 * 用户注册Response
 * @author LaineyC
 */
public class UserSignUpWebResponse extends Response<UserSignUpWebVo> {

    public UserSignUpWebResponse(){

    }

    public UserSignUpWebResponse(UserSignUpWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserSignInWebVo;

/**
 * 用户登录Response
 * @author LaineyC
 */
public class UserSignInWebResponse extends Response<UserSignInWebVo> {

    public UserSignInWebResponse(){

    }

    public UserSignInWebResponse(UserSignInWebVo body){
        setBody(body);
    }

}
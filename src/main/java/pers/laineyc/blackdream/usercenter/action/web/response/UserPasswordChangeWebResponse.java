package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserPasswordChangeWebVo;

/**
 * 用户密码修改Response
 * @author LaineyC
 */
public class UserPasswordChangeWebResponse extends Response<UserPasswordChangeWebVo> {

    public UserPasswordChangeWebResponse(){

    }

    public UserPasswordChangeWebResponse(UserPasswordChangeWebVo body){
        setBody(body);
    }

}
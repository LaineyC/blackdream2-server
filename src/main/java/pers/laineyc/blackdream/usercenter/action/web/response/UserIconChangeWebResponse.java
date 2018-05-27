package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserIconChangeWebVo;

/**
 * @author LaineyC
 */
public class UserIconChangeWebResponse extends Response<UserIconChangeWebVo> {

    public UserIconChangeWebResponse(){

    }

    public UserIconChangeWebResponse(UserIconChangeWebVo body){
        setBody(body);
    }

}
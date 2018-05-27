package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserUpdateWebVo;

/**
 * 用户修改Response
 * @author LaineyC
 */
public class UserUpdateWebResponse extends Response<UserUpdateWebVo> {

    public UserUpdateWebResponse(){

    }

    public UserUpdateWebResponse(UserUpdateWebVo body){
        setBody(body);
    }

}
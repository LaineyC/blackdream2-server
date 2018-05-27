package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserSignOutWebVo;

/**
 * 用户退出Response
 * @author LaineyC
 */
public class UserSignOutWebResponse extends Response<UserSignOutWebVo> {

    public UserSignOutWebResponse(){

    }

    public UserSignOutWebResponse(UserSignOutWebVo body){
        setBody(body);
    }

}
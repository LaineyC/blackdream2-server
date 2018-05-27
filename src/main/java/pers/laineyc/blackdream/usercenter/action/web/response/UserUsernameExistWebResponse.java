package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;

/**
 * 用户名测存在Response
 * @author LaineyC
 */
public class UserUsernameExistWebResponse extends Response<Boolean> {

    public UserUsernameExistWebResponse(){

    }

    public UserUsernameExistWebResponse(Boolean body){
        setBody(body);
    }

}
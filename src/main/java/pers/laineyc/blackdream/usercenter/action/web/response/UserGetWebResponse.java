package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserGetWebVo;

/**
 * 用户单个查询Response
 * @author LaineyC
 */
public class UserGetWebResponse extends Response<UserGetWebVo> {

    public UserGetWebResponse(){

    }

    public UserGetWebResponse(UserGetWebVo body){
        setBody(body);
    }

}
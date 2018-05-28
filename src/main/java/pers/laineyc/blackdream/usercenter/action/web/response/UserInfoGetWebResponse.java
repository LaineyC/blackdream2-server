package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserInfoGetWebVo;

/**
 * 用户单个查询Response
 * @author LaineyC
 */
public class UserInfoGetWebResponse extends Response<UserInfoGetWebVo> {

    public UserInfoGetWebResponse(){

    }

    public UserInfoGetWebResponse(UserInfoGetWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.usercenter.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserQueryWebVo;

/**
 * 用户多个查询Response
 * @author LaineyC
 */
public class UserQueryWebResponse extends Response<List<UserQueryWebVo>> {

    public UserQueryWebResponse(){

    }

    public UserQueryWebResponse(List<UserQueryWebVo> body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.usercenter.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.usercenter.action.web.vo.UserSearchWebVo;

/**
 * 用户分页查询Response
 * @author LaineyC
 */
public class UserSearchWebResponse extends Response<PageResult<UserSearchWebVo>> {

    public UserSearchWebResponse(){

    }

    public UserSearchWebResponse(PageResult<UserSearchWebVo> body){
        setBody(body);
    }

}
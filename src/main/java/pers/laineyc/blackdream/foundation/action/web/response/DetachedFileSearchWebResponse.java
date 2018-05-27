package pers.laineyc.blackdream.foundation.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.action.web.vo.DetachedFileSearchWebVo;

/**
 * 游离文件分页查询Response
 * @author LaineyC
 */
public class DetachedFileSearchWebResponse extends Response<PageResult<DetachedFileSearchWebVo>> {

    public DetachedFileSearchWebResponse(){

    }

    public DetachedFileSearchWebResponse(PageResult<DetachedFileSearchWebVo> body){
        setBody(body);
    }

}
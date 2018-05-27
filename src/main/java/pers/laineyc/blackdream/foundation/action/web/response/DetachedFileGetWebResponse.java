package pers.laineyc.blackdream.foundation.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.foundation.action.web.vo.DetachedFileGetWebVo;

/**
 * 游离文件单个查询Response
 * @author LaineyC
 */
public class DetachedFileGetWebResponse extends Response<DetachedFileGetWebVo> {

    public DetachedFileGetWebResponse(){

    }

    public DetachedFileGetWebResponse(DetachedFileGetWebVo body){
        setBody(body);
    }

}
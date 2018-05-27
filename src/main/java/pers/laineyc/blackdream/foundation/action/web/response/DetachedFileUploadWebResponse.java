package pers.laineyc.blackdream.foundation.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.foundation.action.web.vo.DetachedFileUploadWebVo;

/**
 * 游离文件上传Response
 * @author LaineyC
 */
public class DetachedFileUploadWebResponse extends Response<DetachedFileUploadWebVo> {

    public DetachedFileUploadWebResponse(){

    }

    public DetachedFileUploadWebResponse(DetachedFileUploadWebVo body){
        setBody(body);
    }

}
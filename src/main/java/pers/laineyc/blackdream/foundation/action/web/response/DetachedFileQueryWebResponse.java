package pers.laineyc.blackdream.foundation.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.foundation.action.web.vo.DetachedFileQueryWebVo;

/**
 * 游离文件多个查询Response
 * @author LaineyC
 */
public class DetachedFileQueryWebResponse extends Response<List<DetachedFileQueryWebVo>> {

    public DetachedFileQueryWebResponse(){

    }

    public DetachedFileQueryWebResponse(List<DetachedFileQueryWebVo> body){
        setBody(body);
    }

}
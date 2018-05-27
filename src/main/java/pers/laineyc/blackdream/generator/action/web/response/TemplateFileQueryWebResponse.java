package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileQueryWebVo;

/**
 * 生成器模板文件多个查询Response
 * @author LaineyC
 */
public class TemplateFileQueryWebResponse extends Response<List<TemplateFileQueryWebVo>> {

    public TemplateFileQueryWebResponse(){

    }

    public TemplateFileQueryWebResponse(List<TemplateFileQueryWebVo> body){
        setBody(body);
    }

}
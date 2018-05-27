package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileGetWebVo;

/**
 * 生成器模板文件单个查询Response
 * @author LaineyC
 */
public class TemplateFileGetWebResponse extends Response<TemplateFileGetWebVo> {

    public TemplateFileGetWebResponse(){

    }

    public TemplateFileGetWebResponse(TemplateFileGetWebVo body){
        setBody(body);
    }

}
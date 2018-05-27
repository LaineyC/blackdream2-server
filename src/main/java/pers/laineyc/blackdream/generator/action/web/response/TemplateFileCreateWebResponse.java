package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileCreateWebVo;

/**
 * 生成器模板文件创建Response
 * @author LaineyC
 */
public class TemplateFileCreateWebResponse extends Response<TemplateFileCreateWebVo> {

    public TemplateFileCreateWebResponse(){

    }

    public TemplateFileCreateWebResponse(TemplateFileCreateWebVo body){
        setBody(body);
    }

}
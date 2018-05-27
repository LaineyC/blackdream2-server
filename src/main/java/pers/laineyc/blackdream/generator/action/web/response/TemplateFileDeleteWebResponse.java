package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileDeleteWebVo;

/**
 * 生成器模板文件删除Response
 * @author LaineyC
 */
public class TemplateFileDeleteWebResponse extends Response<TemplateFileDeleteWebVo> {

    public TemplateFileDeleteWebResponse(){

    }

    public TemplateFileDeleteWebResponse(TemplateFileDeleteWebVo body){
        setBody(body);
    }

}
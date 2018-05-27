package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileUpdateWebVo;

/**
 * 生成器模板文件修改Response
 * @author LaineyC
 */
public class TemplateFileUpdateWebResponse extends Response<TemplateFileUpdateWebVo> {

    public TemplateFileUpdateWebResponse(){

    }

    public TemplateFileUpdateWebResponse(TemplateFileUpdateWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileSearchWebVo;

/**
 * 生成器模板文件分页查询Response
 * @author LaineyC
 */
public class TemplateFileSearchWebResponse extends Response<PageResult<TemplateFileSearchWebVo>> {

    public TemplateFileSearchWebResponse(){

    }

    public TemplateFileSearchWebResponse(PageResult<TemplateFileSearchWebVo> body){
        setBody(body);
    }

}
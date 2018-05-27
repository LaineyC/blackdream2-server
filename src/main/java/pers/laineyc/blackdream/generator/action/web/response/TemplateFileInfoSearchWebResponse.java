package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileInfoSearchWebVo;

/**
 * 生成器模板文件分页查询Response
 * @author LaineyC
 */
public class TemplateFileInfoSearchWebResponse extends Response<PageResult<TemplateFileInfoSearchWebVo>> {

    public TemplateFileInfoSearchWebResponse(){

    }

    public TemplateFileInfoSearchWebResponse(PageResult<TemplateFileInfoSearchWebVo> body){
        setBody(body);
    }

}
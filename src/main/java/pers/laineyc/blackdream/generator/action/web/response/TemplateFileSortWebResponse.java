package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.TemplateFileSortWebVo;

/**
 * 生成器模板文件排序Response
 * @author LaineyC
 */
public class TemplateFileSortWebResponse extends Response<TemplateFileSortWebVo> {

    public TemplateFileSortWebResponse(){

    }

    public TemplateFileSortWebResponse(TemplateFileSortWebVo body){
        setBody(body);
    }

}
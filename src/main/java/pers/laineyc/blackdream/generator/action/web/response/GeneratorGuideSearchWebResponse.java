package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideSearchWebVo;

/**
 * 生成器指南分页查询Response
 * @author LaineyC
 */
public class GeneratorGuideSearchWebResponse extends Response<PageResult<GeneratorGuideSearchWebVo>> {

    public GeneratorGuideSearchWebResponse(){

    }

    public GeneratorGuideSearchWebResponse(PageResult<GeneratorGuideSearchWebVo> body){
        setBody(body);
    }

}
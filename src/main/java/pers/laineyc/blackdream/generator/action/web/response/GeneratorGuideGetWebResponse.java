package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideGetWebVo;

/**
 * 生成器指南单个查询Response
 * @author LaineyC
 */
public class GeneratorGuideGetWebResponse extends Response<GeneratorGuideGetWebVo> {

    public GeneratorGuideGetWebResponse(){

    }

    public GeneratorGuideGetWebResponse(GeneratorGuideGetWebVo body){
        setBody(body);
    }

}
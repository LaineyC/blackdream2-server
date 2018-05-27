package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideUpdateWebVo;

/**
 * 生成器指南修改Response
 * @author LaineyC
 */
public class GeneratorGuideUpdateWebResponse extends Response<GeneratorGuideUpdateWebVo> {

    public GeneratorGuideUpdateWebResponse(){

    }

    public GeneratorGuideUpdateWebResponse(GeneratorGuideUpdateWebVo body){
        setBody(body);
    }

}
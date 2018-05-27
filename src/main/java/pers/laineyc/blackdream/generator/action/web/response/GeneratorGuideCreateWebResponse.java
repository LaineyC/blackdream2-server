package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideCreateWebVo;

/**
 * 生成器指南创建Response
 * @author LaineyC
 */
public class GeneratorGuideCreateWebResponse extends Response<GeneratorGuideCreateWebVo> {

    public GeneratorGuideCreateWebResponse(){

    }

    public GeneratorGuideCreateWebResponse(GeneratorGuideCreateWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideDeleteWebVo;

/**
 * 生成器指南删除Response
 * @author LaineyC
 */
public class GeneratorGuideDeleteWebResponse extends Response<GeneratorGuideDeleteWebVo> {

    public GeneratorGuideDeleteWebResponse(){

    }

    public GeneratorGuideDeleteWebResponse(GeneratorGuideDeleteWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideSaveWebVo;

/**
 * 生成器指南保存Response
 * @author LaineyC
 */
public class GeneratorGuideSaveWebResponse extends Response<GeneratorGuideSaveWebVo> {

    public GeneratorGuideSaveWebResponse(){

    }

    public GeneratorGuideSaveWebResponse(GeneratorGuideSaveWebVo body){
        setBody(body);
    }

}
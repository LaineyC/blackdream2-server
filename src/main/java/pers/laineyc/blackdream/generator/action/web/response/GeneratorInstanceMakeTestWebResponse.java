package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceMakeTestWebVo;

/**
 * 生成器实例生成Response
 * @author LaineyC
 */
public class GeneratorInstanceMakeTestWebResponse extends Response<GeneratorInstanceMakeTestWebVo> {

    public GeneratorInstanceMakeTestWebResponse(){

    }

    public GeneratorInstanceMakeTestWebResponse(GeneratorInstanceMakeTestWebVo body){
        setBody(body);
    }

}
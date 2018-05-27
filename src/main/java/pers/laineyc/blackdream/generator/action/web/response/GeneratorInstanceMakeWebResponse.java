package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceMakeWebVo;

/**
 * 生成器实例生成Response
 * @author LaineyC
 */
public class GeneratorInstanceMakeWebResponse extends Response<GeneratorInstanceMakeWebVo> {

    public GeneratorInstanceMakeWebResponse(){

    }

    public GeneratorInstanceMakeWebResponse(GeneratorInstanceMakeWebVo body){
        setBody(body);
    }

}
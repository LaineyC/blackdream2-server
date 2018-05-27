package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceUpdateWebVo;

/**
 * 生成器实例修改Response
 * @author LaineyC
 */
public class GeneratorInstanceUpdateWebResponse extends Response<GeneratorInstanceUpdateWebVo> {

    public GeneratorInstanceUpdateWebResponse(){

    }

    public GeneratorInstanceUpdateWebResponse(GeneratorInstanceUpdateWebVo body){
        setBody(body);
    }

}
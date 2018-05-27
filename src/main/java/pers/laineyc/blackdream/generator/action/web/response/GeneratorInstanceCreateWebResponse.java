package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceCreateWebVo;

/**
 * 生成器实例创建Response
 * @author LaineyC
 */
public class GeneratorInstanceCreateWebResponse extends Response<GeneratorInstanceCreateWebVo> {

    public GeneratorInstanceCreateWebResponse(){

    }

    public GeneratorInstanceCreateWebResponse(GeneratorInstanceCreateWebVo body){
        setBody(body);
    }

}
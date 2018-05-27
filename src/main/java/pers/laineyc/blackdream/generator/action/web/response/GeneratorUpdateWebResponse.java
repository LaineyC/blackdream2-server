package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorUpdateWebVo;

/**
 * 生成器修改Response
 * @author LaineyC
 */
public class GeneratorUpdateWebResponse extends Response<GeneratorUpdateWebVo> {

    public GeneratorUpdateWebResponse(){

    }

    public GeneratorUpdateWebResponse(GeneratorUpdateWebVo body){
        setBody(body);
    }

}
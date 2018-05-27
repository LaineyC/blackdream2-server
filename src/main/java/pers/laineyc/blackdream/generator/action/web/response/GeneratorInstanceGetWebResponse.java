package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceGetWebVo;

/**
 * 生成器实例单个查询Response
 * @author LaineyC
 */
public class GeneratorInstanceGetWebResponse extends Response<GeneratorInstanceGetWebVo> {

    public GeneratorInstanceGetWebResponse(){

    }

    public GeneratorInstanceGetWebResponse(GeneratorInstanceGetWebVo body){
        setBody(body);
    }

}
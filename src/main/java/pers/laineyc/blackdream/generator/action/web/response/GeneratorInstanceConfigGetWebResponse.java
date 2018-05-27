package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigGetWebVo;

/**
 * 生成器实例设置单个查询Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigGetWebResponse extends Response<GeneratorInstanceConfigGetWebVo> {

    public GeneratorInstanceConfigGetWebResponse(){

    }

    public GeneratorInstanceConfigGetWebResponse(GeneratorInstanceConfigGetWebVo body){
        setBody(body);
    }

}
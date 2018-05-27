package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigUpdateWebVo;

/**
 * 生成器实例设置修改Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigUpdateWebResponse extends Response<GeneratorInstanceConfigUpdateWebVo> {

    public GeneratorInstanceConfigUpdateWebResponse(){

    }

    public GeneratorInstanceConfigUpdateWebResponse(GeneratorInstanceConfigUpdateWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceDeleteWebVo;

/**
 * 生成器实例删除Response
 * @author LaineyC
 */
public class GeneratorInstanceDeleteWebResponse extends Response<GeneratorInstanceDeleteWebVo> {

    public GeneratorInstanceDeleteWebResponse(){

    }

    public GeneratorInstanceDeleteWebResponse(GeneratorInstanceDeleteWebVo body){
        setBody(body);
    }

}
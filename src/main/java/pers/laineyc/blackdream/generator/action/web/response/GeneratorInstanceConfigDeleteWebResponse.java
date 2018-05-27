package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigDeleteWebVo;

/**
 * 生成器实例设置删除Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigDeleteWebResponse extends Response<GeneratorInstanceConfigDeleteWebVo> {

    public GeneratorInstanceConfigDeleteWebResponse(){

    }

    public GeneratorInstanceConfigDeleteWebResponse(GeneratorInstanceConfigDeleteWebVo body){
        setBody(body);
    }

}
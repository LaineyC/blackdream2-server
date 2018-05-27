package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDeleteWebVo;

/**
 * 生成器删除Response
 * @author LaineyC
 */
public class GeneratorDeleteWebResponse extends Response<GeneratorDeleteWebVo> {

    public GeneratorDeleteWebResponse(){

    }

    public GeneratorDeleteWebResponse(GeneratorDeleteWebVo body){
        setBody(body);
    }

}
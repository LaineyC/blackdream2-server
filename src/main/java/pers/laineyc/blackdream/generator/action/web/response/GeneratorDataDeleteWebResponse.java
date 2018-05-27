package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataDeleteWebVo;

/**
 * 生成器数据删除Response
 * @author LaineyC
 */
public class GeneratorDataDeleteWebResponse extends Response<GeneratorDataDeleteWebVo> {

    public GeneratorDataDeleteWebResponse(){

    }

    public GeneratorDataDeleteWebResponse(GeneratorDataDeleteWebVo body){
        setBody(body);
    }

}
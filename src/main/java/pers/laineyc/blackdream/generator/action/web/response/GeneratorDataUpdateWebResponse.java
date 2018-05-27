package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataUpdateWebVo;

/**
 * 生成器数据修改Response
 * @author LaineyC
 */
public class GeneratorDataUpdateWebResponse extends Response<GeneratorDataUpdateWebVo> {

    public GeneratorDataUpdateWebResponse(){

    }

    public GeneratorDataUpdateWebResponse(GeneratorDataUpdateWebVo body){
        setBody(body);
    }

}
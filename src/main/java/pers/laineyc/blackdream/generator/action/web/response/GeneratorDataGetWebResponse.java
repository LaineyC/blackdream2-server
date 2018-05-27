package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataGetWebVo;

/**
 * 生成器数据单个查询Response
 * @author LaineyC
 */
public class GeneratorDataGetWebResponse extends Response<GeneratorDataGetWebVo> {

    public GeneratorDataGetWebResponse(){

    }

    public GeneratorDataGetWebResponse(GeneratorDataGetWebVo body){
        setBody(body);
    }

}
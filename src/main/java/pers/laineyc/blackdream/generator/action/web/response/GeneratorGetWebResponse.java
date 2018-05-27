package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGetWebVo;

/**
 * 生成器单个查询Response
 * @author LaineyC
 */
public class GeneratorGetWebResponse extends Response<GeneratorGetWebVo> {

    public GeneratorGetWebResponse(){

    }

    public GeneratorGetWebResponse(GeneratorGetWebVo body){
        setBody(body);
    }

}
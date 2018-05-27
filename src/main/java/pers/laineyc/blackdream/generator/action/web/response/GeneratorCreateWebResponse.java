package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorCreateWebVo;

/**
 * 生成器创建Response
 * @author LaineyC
 */
public class GeneratorCreateWebResponse extends Response<GeneratorCreateWebVo> {

    public GeneratorCreateWebResponse(){

    }

    public GeneratorCreateWebResponse(GeneratorCreateWebVo body){
        setBody(body);
    }

}
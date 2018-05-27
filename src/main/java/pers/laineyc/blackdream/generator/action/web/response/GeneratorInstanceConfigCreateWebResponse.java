package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigCreateWebVo;

/**
 * 生成器实例设置创建Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigCreateWebResponse extends Response<GeneratorInstanceConfigCreateWebVo> {

    public GeneratorInstanceConfigCreateWebResponse(){

    }

    public GeneratorInstanceConfigCreateWebResponse(GeneratorInstanceConfigCreateWebVo body){
        setBody(body);
    }

}
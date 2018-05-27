package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigSaveWebVo;

/**
 * 生成器实例设置保存Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigSaveWebResponse extends Response<GeneratorInstanceConfigSaveWebVo> {

    public GeneratorInstanceConfigSaveWebResponse(){

    }

    public GeneratorInstanceConfigSaveWebResponse(GeneratorInstanceConfigSaveWebVo body){
        setBody(body);
    }

}
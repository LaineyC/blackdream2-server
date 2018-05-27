package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceVersionSyncWebVo;

/**
 * 生成器实例版本同步Response
 * @author LaineyC
 */
public class GeneratorInstanceVersionSyncWebResponse extends Response<GeneratorInstanceVersionSyncWebVo> {

    public GeneratorInstanceVersionSyncWebResponse(){

    }

    public GeneratorInstanceVersionSyncWebResponse(GeneratorInstanceVersionSyncWebVo body){
        setBody(body);
    }

}
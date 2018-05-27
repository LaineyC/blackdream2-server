package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorExportWebVo;

/**
 * 生成器导出Response
 * @author LaineyC
 */
public class GeneratorExportWebResponse extends Response<GeneratorExportWebVo> {

    public GeneratorExportWebResponse(){

    }

    public GeneratorExportWebResponse(GeneratorExportWebVo body){
        setBody(body);
    }

}
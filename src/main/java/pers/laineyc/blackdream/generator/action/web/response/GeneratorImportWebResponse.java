package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorImportWebVo;

/**
 * 生成器导入Response
 * @author LaineyC
 */
public class GeneratorImportWebResponse extends Response<GeneratorImportWebVo> {

    public GeneratorImportWebResponse(){

    }

    public GeneratorImportWebResponse(GeneratorImportWebVo body){
        setBody(body);
    }

}
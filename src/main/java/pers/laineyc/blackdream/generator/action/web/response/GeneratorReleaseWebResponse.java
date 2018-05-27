package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorReleaseWebVo;

/**
 * 生成器发布Response
 * @author LaineyC
 */
public class GeneratorReleaseWebResponse extends Response<GeneratorReleaseWebVo> {

    public GeneratorReleaseWebResponse(){

    }

    public GeneratorReleaseWebResponse(GeneratorReleaseWebVo body){
        setBody(body);
    }

}
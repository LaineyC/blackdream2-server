package pers.laineyc.blackdream.autodoc.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.autodoc.action.web.vo.GeneratorDocMakeWebVo;

/**
 * 生成器文档生成Response
 * @author LaineyC
 */
public class GeneratorDocMakeWebResponse extends Response<GeneratorDocMakeWebVo> {

    public GeneratorDocMakeWebResponse(){

    }

    public GeneratorDocMakeWebResponse(GeneratorDocMakeWebVo body){
        setBody(body);
    }

}
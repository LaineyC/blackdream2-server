package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataCreateWebVo;

/**
 * 生成器数据创建Response
 * @author LaineyC
 */
public class GeneratorDataCreateWebResponse extends Response<GeneratorDataCreateWebVo> {

    public GeneratorDataCreateWebResponse(){

    }

    public GeneratorDataCreateWebResponse(GeneratorDataCreateWebVo body){
        setBody(body);
    }

}
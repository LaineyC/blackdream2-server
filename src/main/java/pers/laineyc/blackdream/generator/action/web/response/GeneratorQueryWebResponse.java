package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorQueryWebVo;

/**
 * 生成器多个查询Response
 * @author LaineyC
 */
public class GeneratorQueryWebResponse extends Response<List<GeneratorQueryWebVo>> {

    public GeneratorQueryWebResponse(){

    }

    public GeneratorQueryWebResponse(List<GeneratorQueryWebVo> body){
        setBody(body);
    }

}
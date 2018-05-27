package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigQueryWebVo;

/**
 * 生成器实例设置多个查询Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigQueryWebResponse extends Response<List<GeneratorInstanceConfigQueryWebVo>> {

    public GeneratorInstanceConfigQueryWebResponse(){

    }

    public GeneratorInstanceConfigQueryWebResponse(List<GeneratorInstanceConfigQueryWebVo> body){
        setBody(body);
    }

}
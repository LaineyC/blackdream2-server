package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceQueryWebVo;

/**
 * 生成器实例多个查询Response
 * @author LaineyC
 */
public class GeneratorInstanceQueryWebResponse extends Response<List<GeneratorInstanceQueryWebVo>> {

    public GeneratorInstanceQueryWebResponse(){

    }

    public GeneratorInstanceQueryWebResponse(List<GeneratorInstanceQueryWebVo> body){
        setBody(body);
    }

}
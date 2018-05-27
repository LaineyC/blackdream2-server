package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataQueryWebVo;

/**
 * 生成器数据多个查询Response
 * @author LaineyC
 */
public class GeneratorDataQueryWebResponse extends Response<List<GeneratorDataQueryWebVo>> {

    public GeneratorDataQueryWebResponse(){

    }

    public GeneratorDataQueryWebResponse(List<GeneratorDataQueryWebVo> body){
        setBody(body);
    }

}
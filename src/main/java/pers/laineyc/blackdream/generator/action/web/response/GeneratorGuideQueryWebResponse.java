package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGuideQueryWebVo;

/**
 * 生成器指南多个查询Response
 * @author LaineyC
 */
public class GeneratorGuideQueryWebResponse extends Response<List<GeneratorGuideQueryWebVo>> {

    public GeneratorGuideQueryWebResponse(){

    }

    public GeneratorGuideQueryWebResponse(List<GeneratorGuideQueryWebVo> body){
        setBody(body);
    }

}
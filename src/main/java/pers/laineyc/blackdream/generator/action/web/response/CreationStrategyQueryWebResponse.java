package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyQueryWebVo;

/**
 * 生成器生成策略多个查询Response
 * @author LaineyC
 */
public class CreationStrategyQueryWebResponse extends Response<List<CreationStrategyQueryWebVo>> {

    public CreationStrategyQueryWebResponse(){

    }

    public CreationStrategyQueryWebResponse(List<CreationStrategyQueryWebVo> body){
        setBody(body);
    }

}
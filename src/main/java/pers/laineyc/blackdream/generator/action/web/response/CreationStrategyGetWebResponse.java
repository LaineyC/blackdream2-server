package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyGetWebVo;

/**
 * 生成器生成策略单个查询Response
 * @author LaineyC
 */
public class CreationStrategyGetWebResponse extends Response<CreationStrategyGetWebVo> {

    public CreationStrategyGetWebResponse(){

    }

    public CreationStrategyGetWebResponse(CreationStrategyGetWebVo body){
        setBody(body);
    }

}
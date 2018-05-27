package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyUpdateWebVo;

/**
 * 生成器生成策略修改Response
 * @author LaineyC
 */
public class CreationStrategyUpdateWebResponse extends Response<CreationStrategyUpdateWebVo> {

    public CreationStrategyUpdateWebResponse(){

    }

    public CreationStrategyUpdateWebResponse(CreationStrategyUpdateWebVo body){
        setBody(body);
    }

}
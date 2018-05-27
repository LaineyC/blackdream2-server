package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyCreateWebVo;

/**
 * 生成器生成策略创建Response
 * @author LaineyC
 */
public class CreationStrategyCreateWebResponse extends Response<CreationStrategyCreateWebVo> {

    public CreationStrategyCreateWebResponse(){

    }

    public CreationStrategyCreateWebResponse(CreationStrategyCreateWebVo body){
        setBody(body);
    }

}
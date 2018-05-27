package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyDeleteWebVo;

/**
 * 生成器生成策略删除Response
 * @author LaineyC
 */
public class CreationStrategyDeleteWebResponse extends Response<CreationStrategyDeleteWebVo> {

    public CreationStrategyDeleteWebResponse(){

    }

    public CreationStrategyDeleteWebResponse(CreationStrategyDeleteWebVo body){
        setBody(body);
    }

}
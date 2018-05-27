package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategyInfoSearchWebVo;

/**
 * 生成器生成策略分页查询Response
 * @author LaineyC
 */
public class CreationStrategyInfoSearchWebResponse extends Response<PageResult<CreationStrategyInfoSearchWebVo>> {

    public CreationStrategyInfoSearchWebResponse(){

    }

    public CreationStrategyInfoSearchWebResponse(PageResult<CreationStrategyInfoSearchWebVo> body){
        setBody(body);
    }

}
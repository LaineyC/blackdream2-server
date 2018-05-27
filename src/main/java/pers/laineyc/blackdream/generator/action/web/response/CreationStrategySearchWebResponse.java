package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategySearchWebVo;

/**
 * 生成器生成策略分页查询Response
 * @author LaineyC
 */
public class CreationStrategySearchWebResponse extends Response<PageResult<CreationStrategySearchWebVo>> {

    public CreationStrategySearchWebResponse(){

    }

    public CreationStrategySearchWebResponse(PageResult<CreationStrategySearchWebVo> body){
        setBody(body);
    }

}
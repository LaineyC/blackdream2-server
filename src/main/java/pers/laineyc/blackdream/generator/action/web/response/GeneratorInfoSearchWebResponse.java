package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInfoSearchWebVo;

/**
 * 生成器分页查询Response
 * @author LaineyC
 */
public class GeneratorInfoSearchWebResponse extends Response<PageResult<GeneratorInfoSearchWebVo>> {

    public GeneratorInfoSearchWebResponse(){

    }

    public GeneratorInfoSearchWebResponse(PageResult<GeneratorInfoSearchWebVo> body){
        setBody(body);
    }

}
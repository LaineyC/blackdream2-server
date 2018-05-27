package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceInfoSearchWebVo;

/**
 * 生成器实例分页查询Response
 * @author LaineyC
 */
public class GeneratorInstanceInfoSearchWebResponse extends Response<PageResult<GeneratorInstanceInfoSearchWebVo>> {

    public GeneratorInstanceInfoSearchWebResponse(){

    }

    public GeneratorInstanceInfoSearchWebResponse(PageResult<GeneratorInstanceInfoSearchWebVo> body){
        setBody(body);
    }

}
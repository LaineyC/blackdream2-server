package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceSearchWebVo;

/**
 * 生成器实例分页查询Response
 * @author LaineyC
 */
public class GeneratorInstanceSearchWebResponse extends Response<PageResult<GeneratorInstanceSearchWebVo>> {

    public GeneratorInstanceSearchWebResponse(){

    }

    public GeneratorInstanceSearchWebResponse(PageResult<GeneratorInstanceSearchWebVo> body){
        setBody(body);
    }

}
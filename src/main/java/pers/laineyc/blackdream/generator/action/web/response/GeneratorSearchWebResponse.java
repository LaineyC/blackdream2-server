package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorSearchWebVo;

/**
 * 生成器分页查询Response
 * @author LaineyC
 */
public class GeneratorSearchWebResponse extends Response<PageResult<GeneratorSearchWebVo>> {

    public GeneratorSearchWebResponse(){

    }

    public GeneratorSearchWebResponse(PageResult<GeneratorSearchWebVo> body){
        setBody(body);
    }

}
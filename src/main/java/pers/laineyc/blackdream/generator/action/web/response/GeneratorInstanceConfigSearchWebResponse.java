package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigSearchWebVo;

/**
 * 生成器实例设置分页查询Response
 * @author LaineyC
 */
public class GeneratorInstanceConfigSearchWebResponse extends Response<PageResult<GeneratorInstanceConfigSearchWebVo>> {

    public GeneratorInstanceConfigSearchWebResponse(){

    }

    public GeneratorInstanceConfigSearchWebResponse(PageResult<GeneratorInstanceConfigSearchWebVo> body){
        setBody(body);
    }

}
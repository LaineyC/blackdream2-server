package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataSearchWebVo;

/**
 * 生成器数据分页查询Response
 * @author LaineyC
 */
public class GeneratorDataSearchWebResponse extends Response<PageResult<GeneratorDataSearchWebVo>> {

    public GeneratorDataSearchWebResponse(){

    }

    public GeneratorDataSearchWebResponse(PageResult<GeneratorDataSearchWebVo> body){
        setBody(body);
    }

}
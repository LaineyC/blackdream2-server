package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataSortWebVo;

/**
 * 生成器数据排序Response
 * @author LaineyC
 */
public class GeneratorDataSortWebResponse extends Response<GeneratorDataSortWebVo> {

    public GeneratorDataSortWebResponse(){

    }

    public GeneratorDataSortWebResponse(GeneratorDataSortWebVo body){
        setBody(body);
    }

}
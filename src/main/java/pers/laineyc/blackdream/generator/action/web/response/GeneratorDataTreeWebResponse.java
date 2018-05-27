package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataTreeWebVo;

/**
 * 生成器数据树形查询Response
 * @author LaineyC
 */
public class GeneratorDataTreeWebResponse extends Response<List<GeneratorDataTreeWebVo>> {

    public GeneratorDataTreeWebResponse(){

    }

    public GeneratorDataTreeWebResponse(List<GeneratorDataTreeWebVo> body){
        setBody(body);
    }

}
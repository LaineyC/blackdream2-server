package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.CreationStrategySortWebVo;

/**
 * 生成器生成策略排序Response
 * @author LaineyC
 */
public class CreationStrategySortWebResponse extends Response<CreationStrategySortWebVo> {

    public CreationStrategySortWebResponse(){

    }

    public CreationStrategySortWebResponse(CreationStrategySortWebVo body){
        setBody(body);
    }

}
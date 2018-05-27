package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelUpdateWebVo;

/**
 * 生成器数据模型修改Response
 * @author LaineyC
 */
public class DataModelUpdateWebResponse extends Response<DataModelUpdateWebVo> {

    public DataModelUpdateWebResponse(){

    }

    public DataModelUpdateWebResponse(DataModelUpdateWebVo body){
        setBody(body);
    }

}
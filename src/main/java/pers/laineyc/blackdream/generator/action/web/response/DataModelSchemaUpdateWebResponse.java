package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaUpdateWebVo;

/**
 * 生成器数据模型模式修改Response
 * @author LaineyC
 */
public class DataModelSchemaUpdateWebResponse extends Response<DataModelSchemaUpdateWebVo> {

    public DataModelSchemaUpdateWebResponse(){

    }

    public DataModelSchemaUpdateWebResponse(DataModelSchemaUpdateWebVo body){
        setBody(body);
    }

}
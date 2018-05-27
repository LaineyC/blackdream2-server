package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaGetWebVo;

/**
 * 生成器数据模型模式单个查询Response
 * @author LaineyC
 */
public class DataModelSchemaGetWebResponse extends Response<DataModelSchemaGetWebVo> {

    public DataModelSchemaGetWebResponse(){

    }

    public DataModelSchemaGetWebResponse(DataModelSchemaGetWebVo body){
        setBody(body);
    }

}
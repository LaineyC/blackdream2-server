package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaDeleteWebVo;

/**
 * 生成器数据模型模式删除Response
 * @author LaineyC
 */
public class DataModelSchemaDeleteWebResponse extends Response<DataModelSchemaDeleteWebVo> {

    public DataModelSchemaDeleteWebResponse(){

    }

    public DataModelSchemaDeleteWebResponse(DataModelSchemaDeleteWebVo body){
        setBody(body);
    }

}
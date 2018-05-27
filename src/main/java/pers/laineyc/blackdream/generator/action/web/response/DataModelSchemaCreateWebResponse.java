package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaCreateWebVo;

/**
 * 生成器数据模型模式创建Response
 * @author LaineyC
 */
public class DataModelSchemaCreateWebResponse extends Response<DataModelSchemaCreateWebVo> {

    public DataModelSchemaCreateWebResponse(){

    }

    public DataModelSchemaCreateWebResponse(DataModelSchemaCreateWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaSaveWebVo;

/**
 * 生成器数据模型模式保存Response
 * @author LaineyC
 */
public class DataModelSchemaSaveWebResponse extends Response<DataModelSchemaSaveWebVo> {

    public DataModelSchemaSaveWebResponse(){

    }

    public DataModelSchemaSaveWebResponse(DataModelSchemaSaveWebVo body){
        setBody(body);
    }

}
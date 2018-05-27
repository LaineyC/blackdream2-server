package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaQueryWebVo;

/**
 * 生成器数据模型模式多个查询Response
 * @author LaineyC
 */
public class DataModelSchemaQueryWebResponse extends Response<List<DataModelSchemaQueryWebVo>> {

    public DataModelSchemaQueryWebResponse(){

    }

    public DataModelSchemaQueryWebResponse(List<DataModelSchemaQueryWebVo> body){
        setBody(body);
    }

}
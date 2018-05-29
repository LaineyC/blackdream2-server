package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSchemaSearchWebVo;

/**
 * 生成器数据模型模式分页查询Response
 * @author LaineyC
 */
public class DataModelSchemaSearchWebResponse extends Response<PageResult<DataModelSchemaSearchWebVo>> {

    public DataModelSchemaSearchWebResponse(){

    }

    public DataModelSchemaSearchWebResponse(PageResult<DataModelSchemaSearchWebVo> body){
        setBody(body);
    }

}
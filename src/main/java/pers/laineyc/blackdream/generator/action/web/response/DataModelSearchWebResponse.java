package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSearchWebVo;

/**
 * 生成器数据模型分页查询Response
 * @author LaineyC
 */
public class DataModelSearchWebResponse extends Response<PageResult<DataModelSearchWebVo>> {

    public DataModelSearchWebResponse(){

    }

    public DataModelSearchWebResponse(PageResult<DataModelSearchWebVo> body){
        setBody(body);
    }

}
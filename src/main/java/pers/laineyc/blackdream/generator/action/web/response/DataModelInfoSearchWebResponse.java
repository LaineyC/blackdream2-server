package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelInfoSearchWebVo;

/**
 * 生成器数据模型分页查询Response
 * @author LaineyC
 */
public class DataModelInfoSearchWebResponse extends Response<PageResult<DataModelInfoSearchWebVo>> {

    public DataModelInfoSearchWebResponse(){

    }

    public DataModelInfoSearchWebResponse(PageResult<DataModelInfoSearchWebVo> body){
        setBody(body);
    }

}
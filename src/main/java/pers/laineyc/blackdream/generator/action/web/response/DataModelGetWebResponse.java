package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelGetWebVo;

/**
 * 生成器数据模型单个查询Response
 * @author LaineyC
 */
public class DataModelGetWebResponse extends Response<DataModelGetWebVo> {

    public DataModelGetWebResponse(){

    }

    public DataModelGetWebResponse(DataModelGetWebVo body){
        setBody(body);
    }

}
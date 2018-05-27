package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelSortWebVo;

/**
 * 生成器数据模型排序Response
 * @author LaineyC
 */
public class DataModelSortWebResponse extends Response<DataModelSortWebVo> {

    public DataModelSortWebResponse(){

    }

    public DataModelSortWebResponse(DataModelSortWebVo body){
        setBody(body);
    }

}
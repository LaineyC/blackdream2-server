package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelDeleteWebVo;

/**
 * 生成器数据模型删除Response
 * @author LaineyC
 */
public class DataModelDeleteWebResponse extends Response<DataModelDeleteWebVo> {

    public DataModelDeleteWebResponse(){

    }

    public DataModelDeleteWebResponse(DataModelDeleteWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelCreateWebVo;

/**
 * 生成器数据模型创建Response
 * @author LaineyC
 */
public class DataModelCreateWebResponse extends Response<DataModelCreateWebVo> {

    public DataModelCreateWebResponse(){

    }

    public DataModelCreateWebResponse(DataModelCreateWebVo body){
        setBody(body);
    }

}
package pers.laineyc.blackdream.generator.action.web.response;

import java.util.List;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.vo.DataModelQueryWebVo;

/**
 * 生成器数据模型多个查询Response
 * @author LaineyC
 */
public class DataModelQueryWebResponse extends Response<List<DataModelQueryWebVo>> {

    public DataModelQueryWebResponse(){

    }

    public DataModelQueryWebResponse(List<DataModelQueryWebVo> body){
        setBody(body);
    }

}
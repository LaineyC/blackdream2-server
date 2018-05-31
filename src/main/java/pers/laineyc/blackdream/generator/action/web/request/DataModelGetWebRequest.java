package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据模型单个查询Request
 * @author LaineyC
 */
@ApiModel
public class DataModelGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    public DataModelGetWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
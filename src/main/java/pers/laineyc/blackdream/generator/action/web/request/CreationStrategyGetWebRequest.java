package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器生成策略单个查询Request
 * @author LaineyC
 */
@ApiModel
public class CreationStrategyGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    public CreationStrategyGetWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
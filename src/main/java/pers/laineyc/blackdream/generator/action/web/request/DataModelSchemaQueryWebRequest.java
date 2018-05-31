package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据模型模式多个查询Request
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaQueryWebRequest extends Request {

    @ApiModelProperty(value = "所属用户")
    private String userId;

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    public DataModelSchemaQueryWebRequest() {

    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
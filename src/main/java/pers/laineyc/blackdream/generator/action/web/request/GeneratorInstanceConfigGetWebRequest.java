package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器实例设置单个查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceConfigGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    public GeneratorInstanceConfigGetWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }
}
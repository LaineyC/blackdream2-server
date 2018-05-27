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
    private Long id;

    @ApiModelProperty(value = "所属生成器实例")
    private Long generatorInstanceId;

    public GeneratorInstanceConfigGetWebRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }
}
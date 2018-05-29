package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据树形查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataTreeWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private Long generatorInstanceId;

    public GeneratorDataTreeWebRequest() {

    }

    public Long getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

}
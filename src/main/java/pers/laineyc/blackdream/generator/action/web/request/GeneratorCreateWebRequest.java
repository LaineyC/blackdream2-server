package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器创建Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorCreateWebRequest extends Request {

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "引擎类型：1Velocity；2FreeMarker")
    private Integer engineType;

    @ApiModelProperty(value = "描述")
    private String description;

    public GeneratorCreateWebRequest() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
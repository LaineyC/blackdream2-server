package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器实例修改Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceUpdateWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    public GeneratorInstanceUpdateWebRequest() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
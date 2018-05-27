package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器实例多个查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceQueryWebRequest extends Request {

    @ApiModelProperty(value = "所属用户")
    private Long userId;

    @ApiModelProperty(value = "所属生成器")
    private Long generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    public GeneratorInstanceQueryWebRequest() {

    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
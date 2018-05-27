package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器多个查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorQueryWebRequest extends Request {

    @ApiModelProperty(value = "所属用户")
    private Long userId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "状态：1开发；2发布")
    private Integer status;

    @ApiModelProperty(value = "引擎类型：1Velocity；2FreeMarker")
    private Integer engineType;

    public GeneratorQueryWebRequest() {

    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

}
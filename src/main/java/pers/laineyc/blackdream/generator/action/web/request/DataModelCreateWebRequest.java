package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据模型创建Request
 * @author LaineyC
 */
@ApiModel
public class DataModelCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器")
    private Long generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "图标样式", required = true)
    private String iconStyle;

    @ApiModelProperty(value = "描述")
    private String description;

    public DataModelCreateWebRequest() {

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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIconStyle() {
        return this.iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
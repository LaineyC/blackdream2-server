package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;

/**
 * 生成器数据模型字段
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceDataModelAttributeConfig extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段注释")
    private String comment;

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    @ApiModelProperty(value = "显示宽度")
    private Double displayWidth;

    @ApiModelProperty(value = "是否显示控件")
    private Boolean isShow;

	public GeneratorInstanceDataModelAttributeConfig() {

	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDisplayGroup() {
        return displayGroup;
    }

    public void setDisplayGroup(String displayGroup) {
        this.displayGroup = displayGroup;
    }

    public Double getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(Double displayWidth) {
        this.displayWidth = displayWidth;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }
}
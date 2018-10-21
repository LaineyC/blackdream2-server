package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.*;

/**
 * 生成器数据模型属性
 * @author LaineyC
 */
@ApiModel
public class DataModelAttribute extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性名称")
    private String name;

    @ApiModelProperty(value = "是否首要属性")
    private Boolean isPrimary;

    @ApiModelProperty(value = "属性注释")
    private String comment;

    @ApiModelProperty(value = "数据类型：1NONE；2BOOLEAN；3INTEGER；4FLOAT；5STRING；6DATE；7TIME；8DATETIME；15MODEL_REF")
    private Integer dataType;

    @ApiModelProperty(value = "默认值")
    private Object defaultValue;

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    @ApiModelProperty(value = "显示宽度")
    private Double displayWidth;

    @ApiModelProperty(value = "显示方式：1默认显示；2默认隐藏；3强制显示；")
    private Integer displayType;

    @ApiModelProperty(value = "数据验证集合")
    private Map<Integer, DataModelAttributeDataValidator> dataValidatorMap = new HashMap<>();

    @ApiModelProperty(value = "级联脚本")
    private String cascadeScript;

	public DataModelAttribute() {

	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
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

    public Integer getDisplayType() {
        return displayType;
    }

    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    public Map<Integer, DataModelAttributeDataValidator> getDataValidatorMap() {
        return dataValidatorMap;
    }

    public void setDataValidatorMap(Map<Integer, DataModelAttributeDataValidator> dataValidatorMap) {
        this.dataValidatorMap = dataValidatorMap;
    }

    public String getCascadeScript() {
        return cascadeScript;
    }

    public void setCascadeScript(String cascadeScript) {
        this.cascadeScript = cascadeScript;
    }
}
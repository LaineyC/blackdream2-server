package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型字段
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

    @ApiModelProperty(value = "数据类型：1NONE；2BOOLEAN；3INTEGER；4FLOAT；5STRING；15MODEL_REF")
    private Integer dataType;

    @ApiModelProperty(value = "默认值")
    private Object defaultValue;

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    @ApiModelProperty(value = "显示宽度")
    private Double displayWidth;

    @ApiModelProperty(value = "显示方式：1默认显示；2默认隐藏；3强制显示；")
    private Integer displayType;

    @ApiModelProperty(value = "是否枚举")
    private Boolean isEnum;

    @ApiModelProperty(value = "枚举值列表")
    private List<DataModelAttributeEnumItem> enumList = new ArrayList<>();

    @ApiModelProperty(value = "是否必填项")
    private Boolean isRequired;

    @ApiModelProperty(value = "最小值")
    private Double minValue;

    @ApiModelProperty(value = "最大值")
    private Double maxValue;

    @ApiModelProperty(value = "长度")
    private Integer length;

    @ApiModelProperty(value = "最小长度")
    private Integer minLength;

    @ApiModelProperty(value = "最大长度")
    private Integer maxLength;

    @ApiModelProperty(value = "正则表达式")
    private String regex;

    @ApiModelProperty(value = "正则提示")
    private String regexMessage;

    @ApiModelProperty(value = "验证脚本")
    private String validateScript;

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

    public Boolean getIsEnum() {
        return isEnum;
    }

    public void setIsEnum(Boolean isEnum) {
        this.isEnum = isEnum;
    }

    public List<DataModelAttributeEnumItem> getEnumList() {
        return enumList;
    }

    public void setEnumList(List<DataModelAttributeEnumItem> enumList) {
        this.enumList = enumList;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getRegexMessage() {
        return regexMessage;
    }

    public void setRegexMessage(String regexMessage) {
        this.regexMessage = regexMessage;
    }

    public String getValidateScript() {
        return validateScript;
    }

    public void setValidateScript(String validateScript) {
        this.validateScript = validateScript;
    }

    public String getCascadeScript() {
        return cascadeScript;
    }

    public void setCascadeScript(String cascadeScript) {
        this.cascadeScript = cascadeScript;
    }
}
package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型字段
 * @author LaineyC
 */
@ApiModel
public class DataModelField extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段注释")
    private String comment;

    @ApiModelProperty(value = "数据类型：1BOOLEAN；2INTEGER；3FLOAT；4NUMBER；5TEXT；6ENUM_SINGLE；7ENUM_MULTIPLE；8DATE；9TIME；10DATETIME；15MODEL_REF")
    private Integer dataType;

    @ApiModelProperty(value = "默认值")
    private Object defaultValue;

    @ApiModelProperty(value = "可选值数据列表")
    private List<Map.Entry<String, Object>> optionValueList = new ArrayList<>();

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    @ApiModelProperty(value = "显示宽度")
    private Double displayWidth;

    @ApiModelProperty(value = "显示方式：1默认显示；2默认隐藏；3强制显示；4强制隐藏")
    private Integer displayType;

    @ApiModelProperty(value = "是否只读控件")
    private Boolean isReadonly;

    @ApiModelProperty(value = "是否禁用控件")
    private Boolean isDisabled;

    @ApiModelProperty(value = "必填项")
    private Boolean isRequired;

    @ApiModelProperty(value = "最小值")
    private Double minValue;

    @ApiModelProperty(value = "最大值")
    private Double maxValue;

    @ApiModelProperty(value = "最小长度")
    private Integer minLength;

    @ApiModelProperty(value = "最大长度")
    private Integer maxLength;

    @ApiModelProperty(value = "正则表达式")
    private String regex;

    @ApiModelProperty(value = "错误提示")
    private String errorMessage;

    @ApiModelProperty(value = "验证脚本")
    private String validateScript;

    @ApiModelProperty(value = "级联脚本")
    private String cascadeScript;

	public DataModelField() {

	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Map.Entry<String, Object>> getOptionValueList() {
        return optionValueList;
    }

    public void setOptionValueList(List<Map.Entry<String, Object>> optionValueList) {
        this.optionValueList = optionValueList;
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

    public Boolean getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(Boolean isReadonly) {
        this.isReadonly = isReadonly;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
        this.isDisabled = isDisabled;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
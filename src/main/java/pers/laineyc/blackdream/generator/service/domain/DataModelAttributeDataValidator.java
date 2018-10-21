package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型属性数据验证器
 * @author LaineyC
 */
@ApiModel
public class DataModelAttributeDataValidator extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否枚举")
    private Boolean isEnum;

    @ApiModelProperty(value = "枚举值列表")
    private List<DataModelAttributeEnumItem> enumList = new ArrayList<>();

    @ApiModelProperty(value = "是否必填项")
    private Boolean isRequired;

    @ApiModelProperty(value = "最小值")
    private Object minValue;

    @ApiModelProperty(value = "最大值")
    private Object maxValue;

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

	public DataModelAttributeDataValidator() {

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

    public Object getMinValue() {
        return minValue;
    }

    public void setMinValue(Object minValue) {
        this.minValue = minValue;
    }

    public Object getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Object maxValue) {
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
}
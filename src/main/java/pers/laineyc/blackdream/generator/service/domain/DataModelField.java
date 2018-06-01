package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型字段
 * @author LaineyC
 */
public class DataModelField extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段注释
     */
    private String comment;

    /**
     * 数据类型：1Boolean；2Integer；3Decimal；4Text；5Enum；6Date；7Time；8Model
     */
    private Integer dataType;

    /**
     * 默认值
     */
    private Object defaultValue;

    /**
     * 可选值列表数据
     */
    private List<Map.Entry<String, Object>> optionValueList = new ArrayList<>();

    /**
     * 显示分组
     */
    private String displayGroup;

    /**
     * 显示宽度
     */
    private Double displayWidth;

    /**
     * 显示方式：1默认显示；2默认隐藏下拉；3强制显示
     */
    private Integer displayType;

    /**
     * 是否只读控件
     */
    private Boolean isReadonly;

    /**
     * 是否禁用控件
     */
    private Boolean isDisabled;

    /**
     * 必填项
     */
    private Boolean isRequired;

    /**
     * 最小值
     */
    private Double min;

    /**
     * 最大值
     */
    private Double max;

    /**
     * 最小长度
     */
    private Integer minLength;

    /**
     * 最大长度
     */
    private Integer maxLength;

    /**
     * 正则
     */
    private String pattern;

    /**
     * 正则提示
     */
    private String patternMessage;

    /**
     * 约束脚本
     */
    private String constraintScript;

    /**
     * 级联脚本
     */
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

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPatternMessage() {
        return patternMessage;
    }

    public void setPatternMessage(String patternMessage) {
        this.patternMessage = patternMessage;
    }

    public String getConstraintScript() {
        return constraintScript;
    }

    public void setConstraintScript(String constraintScript) {
        this.constraintScript = constraintScript;
    }

    public String getCascadeScript() {
        return cascadeScript;
    }

    public void setCascadeScript(String cascadeScript) {
        this.cascadeScript = cascadeScript;
    }
}
package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.generator.service.domain.DataModelField;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型创建Request
 * @author LaineyC
 */
@ApiModel
public class DataModelCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "图标样式", required = true)
    private String iconStyle;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "属性列表")
    private List<DataModelField> propertyList = new ArrayList<>();

    @ApiModelProperty(value = "字段列表")
    private List<DataModelField> fieldList = new ArrayList<>();

    @ApiModelProperty(value = "默认记录列表")
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public DataModelCreateWebRequest() {

    }

    public String getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(String generatorId) {
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

    public List<DataModelField> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<DataModelField> propertyList) {
        this.propertyList = propertyList;
    }

    public List<DataModelField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DataModelField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Map<String, Object>> getDefaultRecordList() {
        return defaultRecordList;
    }

    public void setDefaultRecordList(List<Map<String, Object>> defaultRecordList) {
        this.defaultRecordList = defaultRecordList;
    }

    public static class DataModelField {

        @ApiModelProperty(value = "主键")
        private String id;

        @ApiModelProperty(value = "字段名称")
        private String name;

        @ApiModelProperty(value = "字段注释")
        private String comment;

        @ApiModelProperty(value = "数据类型：1Boolean；2Integer；3Decimal；4Text；5Enum；6Date；7Time；8Model")
        private Integer dataType;

        @ApiModelProperty(value = "默认值")
        private Object defaultValue;

        @ApiModelProperty(value = "可选值列表数据")
        private List<Map.Entry<String, Object>> optionValueList = new ArrayList<>();

        @ApiModelProperty(value = "显示分组")
        private String displayGroup;

        @ApiModelProperty(value = "显示宽度")
        private Double displayWidth;

        @ApiModelProperty(value = "是否只读控件")
        private Boolean isReadonly;

        @ApiModelProperty(value = "是否禁用控件")
        private Boolean isDisabled;

        @ApiModelProperty(value = "默认记录列表")
        private Boolean isDropdown;

        @ApiModelProperty(value = "必填项")
        private Boolean isRequired;

        @ApiModelProperty(value = "最小值")
        private Double min;

        @ApiModelProperty(value = "最大值")
        private Double max;

        @ApiModelProperty(value = "最小长度")
        private Integer minLength;

        @ApiModelProperty(value = "最大长度")
        private Integer maxLength;

        @ApiModelProperty(value = "正则")
        private String pattern;

        @ApiModelProperty(value = "正则提示")
        private String patternMessage;

        @ApiModelProperty(value = "约束脚本")
        private String constraintScript;

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

        public Boolean getIsDropdown() {
            return isDropdown;
        }

        public void setIsDropdown(Boolean isDropdown) {
            this.isDropdown = isDropdown;
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
}
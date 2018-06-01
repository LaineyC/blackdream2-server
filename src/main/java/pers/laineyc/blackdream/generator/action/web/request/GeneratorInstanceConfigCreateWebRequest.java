package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置创建Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceConfigCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "属性列表")
    private List<DataModelFieldConfig> propertyList = new ArrayList<>();

    @ApiModelProperty(value = "字段列表")
    private List<DataModelFieldConfig> fieldList = new ArrayList<>();

    @ApiModelProperty(value = "是否直接添加默认记录")
    private Boolean isAddDefaultRecordList;

    @ApiModelProperty(value = "默认记录集合数据")
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public GeneratorInstanceConfigCreateWebRequest() {

    }

    public String getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DataModelFieldConfig> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<DataModelFieldConfig> propertyList) {
        this.propertyList = propertyList;
    }

    public List<DataModelFieldConfig> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DataModelFieldConfig> fieldList) {
        this.fieldList = fieldList;
    }

    public Boolean getIsAddDefaultRecordList() {
        return isAddDefaultRecordList;
    }

    public void setIsAddDefaultRecordList(Boolean isAddDefaultRecordList) {
        this.isAddDefaultRecordList = isAddDefaultRecordList;
    }

    public List<Map<String, Object>> getDefaultRecordList() {
        return defaultRecordList;
    }

    public void setDefaultRecordList(List<Map<String, Object>> defaultRecordList) {
        this.defaultRecordList = defaultRecordList;
    }

    @ApiModel
    public static class DataModelFieldConfig {

        @ApiModelProperty(value = "主键")
        private String id;

        @ApiModelProperty(value = "字段名称")
        private String name;

        @ApiModelProperty(value = "字段注释")
        private String comment;

        @ApiModelProperty(value = "默认值")
        private Object defaultValue;

        @ApiModelProperty(value = "显示分组")
        private String displayGroup;

        @ApiModelProperty(value = "显示宽度")
        private Double displayWidth;

        @ApiModelProperty(value = "是否显示控件")
        private Boolean isShow;

        public DataModelFieldConfig() {

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

        public Boolean getIsShow() {
            return isShow;
        }

        public void setIsShow(Boolean isShow) {
            this.isShow = isShow;
        }
    }
}
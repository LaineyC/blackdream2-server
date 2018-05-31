package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.DataModelField;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型创建Parameter
 * @author LaineyC
 */
public class DataModelCreateParameter extends Parameter {

    /**
     * 所属生成器
     */
    private String generatorId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图标样式
     */
    private String iconStyle;

    /**
     * 描述
     */
    private String description;

    /**
     * 属性列表
     */
    private List<DataModelField> propertyList = new ArrayList<>();

    /**
     * 字段列表
     */
    private List<DataModelField> fieldList = new ArrayList<>();

    /**
     * 默认记录列表
     */
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public DataModelCreateParameter() {

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
}
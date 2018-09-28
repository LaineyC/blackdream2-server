package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceDataModelAttributeConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置保存Parameter
 * @author LaineyC
 */
public class GeneratorInstanceConfigSaveParameter extends Parameter {

    /**
     * 所属生成器实例
     */
    private String generatorInstanceId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 属性列表
     */
    private List<GeneratorInstanceDataModelAttributeConfig> propertyList = new ArrayList<>();

    /**
     * 字段列表
     */
    private List<GeneratorInstanceDataModelAttributeConfig> fieldList = new ArrayList<>();

    /**
     * 是否直接添加默认记录
     */
    private Boolean isAddDefaultRecordList;

    /**
     * 默认记录集合数据
     */
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public GeneratorInstanceConfigSaveParameter() {

    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GeneratorInstanceDataModelAttributeConfig> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<GeneratorInstanceDataModelAttributeConfig> propertyList) {
        this.propertyList = propertyList;
    }

    public List<GeneratorInstanceDataModelAttributeConfig> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<GeneratorInstanceDataModelAttributeConfig> fieldList) {
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

}
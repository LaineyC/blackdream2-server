package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据创建Parameter
 * @author LaineyC
 */
public class GeneratorDataCreateParameter extends Parameter {

    /**
     * 所属生成器实例
     */
    private Long generatorInstanceId;

    /**
     * 所属生成器数据模型
     */
    private Long dataModelId;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否展开
     */
    private Boolean isExpanded;

    /**
     * 父节点
     */
    private Long parentId;

    /**
     * 属性集
     */
    private Map<String, Object> property = new LinkedHashMap<>();

    /**
     * 记录列表
     */
    private List<Map<String, Object>> recordList = new ArrayList<>();

    public GeneratorDataCreateParameter() {

    }

    public Long getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public Long getDataModelId() {
        return this.dataModelId;
    }

    public void setDataModelId(Long dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsExpanded() {
        return this.isExpanded;
    }

    public void setIsExpanded(Boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Map<String, Object> getProperty() {
        return property;
    }

    public void setProperty(Map<String, Object> property) {
        this.property = property;
    }

    public List<Map<String, Object>> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Map<String, Object>> recordList) {
        this.recordList = recordList;
    }
}
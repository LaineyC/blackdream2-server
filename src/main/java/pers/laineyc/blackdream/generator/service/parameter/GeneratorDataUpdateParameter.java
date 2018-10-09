package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.dao.support.FetchLazy;
import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorDataAttributeControl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据修改Parameter
 * @author LaineyC
 */
public class GeneratorDataUpdateParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

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
    private String parentId;

    /**
     * 属性集
     */
    private Map<String, GeneratorDataAttributeControl> properties = new LinkedHashMap<>();

    /**
     * 记录列表
     */
    private List<Map<String, GeneratorDataAttributeControl>> tupleList = new ArrayList<>();

    public GeneratorDataUpdateParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
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

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Map<String, GeneratorDataAttributeControl> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, GeneratorDataAttributeControl> properties) {
        this.properties = properties;
    }

    public List<Map<String, GeneratorDataAttributeControl>> getTupleList() {
        return tupleList;
    }

    public void setTupleList(List<Map<String, GeneratorDataAttributeControl>> tupleList) {
        this.tupleList = tupleList;
    }
}
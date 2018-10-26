package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchemaRuleItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型模式修改Parameter
 * @author LaineyC
 */
public class DataModelSchemaUpdateParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 规则集合
     */
    private Map<String, DataModelSchemaRuleItem> ruleItemMap = new HashMap<>();

    public DataModelSchemaUpdateParameter() {

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, DataModelSchemaRuleItem> getRuleItemMap() {
        return ruleItemMap;
    }

    public void setRuleItemMap(Map<String, DataModelSchemaRuleItem> ruleItemMap) {
        this.ruleItemMap = ruleItemMap;
    }
}
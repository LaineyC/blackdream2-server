package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceDataModelAttributeConfig;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceDataModelConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置创建Parameter
 * @author LaineyC
 */
public class GeneratorInstanceConfigCreateParameter extends Parameter {

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
     * 根据数据模型的设置
     */
    private Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap = new HashMap<>();

    public GeneratorInstanceConfigCreateParameter() {

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

    public Map<String, GeneratorInstanceDataModelConfig> getDataModelConfigMap() {
        return dataModelConfigMap;
    }

    public void setDataModelConfigMap(Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap) {
        this.dataModelConfigMap = dataModelConfigMap;
    }
}
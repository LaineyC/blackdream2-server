package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器指南单个查询Parameter
 * @author LaineyC
 */
public class GeneratorGuideGetParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 所属生成器
     */
    private String generatorId;

    public GeneratorGuideGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }
}
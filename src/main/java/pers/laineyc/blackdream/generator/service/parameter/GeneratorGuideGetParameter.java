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
    private Long id;

    /**
     * 所属生成器
     */
    private Long generatorId;

    public GeneratorGuideGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }
}
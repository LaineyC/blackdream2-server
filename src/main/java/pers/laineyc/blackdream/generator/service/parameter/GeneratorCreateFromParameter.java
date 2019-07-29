package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器创建Parameter
 * @author LaineyC
 */
public class GeneratorCreateFromParameter extends Parameter {

    /**
     * 名称
     */
    private String name;

    /**
     * 引擎类型：1Velocity；2FreeMarker
     */
    private Integer engineType;

    /**
     * 描述
     */
    private String description;

    /**
     * 生成器
     */
    private String fromGeneratorId;

    public GeneratorCreateFromParameter() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromGeneratorId() {
        return fromGeneratorId;
    }

    public void setFromGeneratorId(String fromGeneratorId) {
        this.fromGeneratorId = fromGeneratorId;
    }
}
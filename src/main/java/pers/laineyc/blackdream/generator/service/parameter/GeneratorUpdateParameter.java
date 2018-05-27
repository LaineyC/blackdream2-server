package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器修改Parameter
 * @author LaineyC
 */
public class GeneratorUpdateParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

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

    public GeneratorUpdateParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
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

}
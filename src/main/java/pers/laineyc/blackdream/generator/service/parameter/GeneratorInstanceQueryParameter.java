package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器实例多个查询Parameter
 * @author LaineyC
 */
public class GeneratorInstanceQueryParameter extends Parameter {

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 名称
     */
    private String name;

    public GeneratorInstanceQueryParameter() {

    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器实例设置单个查询Parameter
 * @author LaineyC
 */
public class GeneratorInstanceConfigGetParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 所属生成器实例
     */
    private String generatorInstanceId;

    public GeneratorInstanceConfigGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }
}
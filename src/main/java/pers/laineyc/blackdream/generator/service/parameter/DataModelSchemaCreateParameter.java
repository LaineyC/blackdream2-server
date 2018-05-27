package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据模型模式创建Parameter
 * @author LaineyC
 */
public class DataModelSchemaCreateParameter extends Parameter {

    /**
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 脚本
     */
    private String script;

    public DataModelSchemaCreateParameter() {

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
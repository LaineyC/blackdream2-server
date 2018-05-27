package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据多个查询Parameter
 * @author LaineyC
 */
public class GeneratorDataQueryParameter extends Parameter {

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 所属生成器实例
     */
    private Long generatorInstanceId;

    /**
     * 所属生成器数据模型
     */
    private Long dataModelId;

    /**
     * 名称
     */
    private String name;

    /**
     * 父节点
     */
    private Long parentId;

    public GeneratorDataQueryParameter() {

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

    public Long getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public Long getDataModelId() {
        return this.dataModelId;
    }

    public void setDataModelId(Long dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
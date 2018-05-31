package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据树形查询Parameter
 * @author LaineyC
 */
public class GeneratorDataTreeParameter extends Parameter {

    /**
     * 所属生成器实例
     */
    private String generatorInstanceId;

    public GeneratorDataTreeParameter() {

    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }
}
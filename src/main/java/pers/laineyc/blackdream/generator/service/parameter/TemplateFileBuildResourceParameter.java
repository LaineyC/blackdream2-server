package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器模板文件排序Parameter
 * @author LaineyC
 */
public class TemplateFileBuildResourceParameter extends Parameter {

    /**
     * 所属生成器
     */
    private String generatorId;

    public TemplateFileBuildResourceParameter() {

    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }
}
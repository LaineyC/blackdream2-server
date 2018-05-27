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
    private Long generatorId;

    public TemplateFileBuildResourceParameter() {

    }

    public Long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }
}
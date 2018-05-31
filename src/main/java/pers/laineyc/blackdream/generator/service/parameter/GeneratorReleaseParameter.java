package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器发布Parameter
 * @author LaineyC
 */
public class GeneratorReleaseParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorReleaseParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器实例版本同步Parameter
 * @author LaineyC
 */
public class GeneratorInstanceVersionSyncParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorInstanceVersionSyncParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
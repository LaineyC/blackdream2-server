package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器实例设置删除Parameter
 * @author LaineyC
 */
public class GeneratorInstanceConfigDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorInstanceConfigDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
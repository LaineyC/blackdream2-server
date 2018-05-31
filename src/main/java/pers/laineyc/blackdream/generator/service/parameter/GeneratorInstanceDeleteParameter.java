package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器实例删除Parameter
 * @author LaineyC
 */
public class GeneratorInstanceDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorInstanceDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
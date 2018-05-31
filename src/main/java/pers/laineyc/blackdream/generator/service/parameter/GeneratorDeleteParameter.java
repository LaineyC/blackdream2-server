package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器删除Parameter
 * @author LaineyC
 */
public class GeneratorDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
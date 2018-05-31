package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器指南删除Parameter
 * @author LaineyC
 */
public class GeneratorGuideDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorGuideDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
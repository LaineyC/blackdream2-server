package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据删除Parameter
 * @author LaineyC
 */
public class GeneratorDataDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public GeneratorDataDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
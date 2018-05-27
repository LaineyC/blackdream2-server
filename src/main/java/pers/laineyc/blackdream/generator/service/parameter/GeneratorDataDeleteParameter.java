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
    private Long id;

    public GeneratorDataDeleteParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
}
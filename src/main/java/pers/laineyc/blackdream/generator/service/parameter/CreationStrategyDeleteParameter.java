package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器生成策略删除Parameter
 * @author LaineyC
 */
public class CreationStrategyDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public CreationStrategyDeleteParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
}
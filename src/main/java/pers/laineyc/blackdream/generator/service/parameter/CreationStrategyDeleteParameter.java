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
    private String id;

    public CreationStrategyDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
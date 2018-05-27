package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据模型删除Parameter
 * @author LaineyC
 */
public class DataModelDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public DataModelDeleteParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
}
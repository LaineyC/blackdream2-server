package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据模型模式删除Parameter
 * @author LaineyC
 */
public class DataModelSchemaDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public DataModelSchemaDeleteParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
}
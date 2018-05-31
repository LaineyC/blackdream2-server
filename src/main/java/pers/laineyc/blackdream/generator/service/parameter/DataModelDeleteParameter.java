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
    private String id;

    public DataModelDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
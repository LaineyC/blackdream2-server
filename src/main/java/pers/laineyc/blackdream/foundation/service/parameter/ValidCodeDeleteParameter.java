package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 验证码删除Parameter
 * @author LaineyC
 */
public class ValidCodeDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public ValidCodeDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
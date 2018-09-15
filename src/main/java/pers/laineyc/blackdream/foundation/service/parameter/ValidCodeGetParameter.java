package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 验证码单个查询Parameter
 * @author LaineyC
 */
public class ValidCodeGetParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public ValidCodeGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户单个查询Parameter
 * @author LaineyC
 */
public class UserGetParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public UserGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
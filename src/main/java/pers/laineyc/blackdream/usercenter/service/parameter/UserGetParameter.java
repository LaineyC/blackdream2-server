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
    private Long id;

    public UserGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
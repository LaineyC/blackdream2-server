package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * @author LaineyC
 */
public class UserUsernameExistParameter extends Parameter {

    /**
     * 用户名
     */
    private String username;

    public UserUsernameExistParameter() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户密码更改Parameter
 * @author LaineyC
 */
public class UserPasswordResetValidCodeSendParameter extends Parameter {

    /**
     * 用户名
     */
    private String username;

    public UserPasswordResetValidCodeSendParameter() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
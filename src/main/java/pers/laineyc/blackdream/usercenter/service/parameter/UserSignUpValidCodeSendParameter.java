package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户密码更改Parameter
 * @author LaineyC
 */
public class UserSignUpValidCodeSendParameter extends Parameter {

    /**
     * 邮箱
     */
    private String email;

    public UserSignUpValidCodeSendParameter() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
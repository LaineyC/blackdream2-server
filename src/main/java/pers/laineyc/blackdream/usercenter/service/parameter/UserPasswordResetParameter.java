package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户密码更改Parameter
 * @author LaineyC
 */
public class UserPasswordResetParameter extends Parameter {

    /**
     * 用户名或邮箱
     */
    private String username;

    /**
     * 验证码
     */
    private String validCode;

    /**
     * 新密码
     */
    private String newPassword;

    public UserPasswordResetParameter() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
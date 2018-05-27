package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户密码更改Parameter
 * @author LaineyC
 */
public class UserPasswordChangeParameter extends Parameter {

    /**
     * 旧密码
     */
    private String oldPassword;

    /**
     * 新密码
     */
    private String newPassword;

    public UserPasswordChangeParameter() {

    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
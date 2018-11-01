package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 密码重置
 * @author LaineyC
 */
@ApiModel
public class UserPasswordResetWebRequest extends Request {

    @ApiModelProperty(value = "用户名或邮箱", required = true)
    private String username;

    @ApiModelProperty(value = "验证码", required = true)
    private String validCode;

    @ApiModelProperty(value = "新密码", required = true)
    private String newPassword;

    public UserPasswordResetWebRequest() {

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
package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 密码重置验证码发送Request
 * @author LaineyC
 */
@ApiModel
public class UserPasswordResetValidCodeSendWebRequest extends Request {

    @ApiModelProperty(value = "用户名或邮箱", required = true)
    private String username;

    public UserPasswordResetValidCodeSendWebRequest() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
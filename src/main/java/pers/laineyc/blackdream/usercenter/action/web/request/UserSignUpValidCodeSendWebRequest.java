package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 用户注册邮箱验证码发送Request
 * @author LaineyC
 */
@ApiModel
public class UserSignUpValidCodeSendWebRequest extends Request {

    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    public UserSignUpValidCodeSendWebRequest() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
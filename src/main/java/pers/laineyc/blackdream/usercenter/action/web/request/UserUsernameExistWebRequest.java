package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 用户注册Request
 * @author LaineyC
 */
@ApiModel
public class UserUsernameExistWebRequest extends Request {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    public UserUsernameExistWebRequest() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
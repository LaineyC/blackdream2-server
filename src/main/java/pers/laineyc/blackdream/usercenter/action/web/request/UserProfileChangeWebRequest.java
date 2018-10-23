package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * @author LaineyC
 */
@ApiModel
public class UserProfileChangeWebRequest extends Request {

    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;

    public UserProfileChangeWebRequest() {

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
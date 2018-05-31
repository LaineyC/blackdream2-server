package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * @author LaineyC
 */
@ApiModel
public class UserIconChangeWebRequest extends Request {

    @ApiModelProperty(value = "头像文件", required = true)
    private String iconFileId;

    public UserIconChangeWebRequest() {

    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId;
    }

}
package pers.laineyc.blackdream.usercenter.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 用户单个查询Request
 * @author LaineyC
 */
@ApiModel
public class UserGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    public UserGetWebRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
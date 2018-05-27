package pers.laineyc.blackdream.foundation.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 游离文件单个查询Request
 * @author LaineyC
 */
@ApiModel
public class DetachedFileGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    public DetachedFileGetWebRequest() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
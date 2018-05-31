package pers.laineyc.blackdream.foundation.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;

/**
 * 游离文件上传Vo
 * @author LaineyC
 */
@ApiModel
public class DetachedFileUploadWebVo extends Vo {

    @ApiModelProperty(value = "主键")
    private String id;

    public DetachedFileUploadWebVo() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
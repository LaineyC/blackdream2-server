package pers.laineyc.blackdream.foundation.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 游离文件多个查询Request
 * @author LaineyC
 */
@ApiModel
public class DetachedFileQueryWebRequest extends Request {

    @ApiModelProperty(value = "所属用户")
    private String userId;

    @ApiModelProperty(value = "状态：1游离；2受管")
    private Integer status;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "扩展名")
    private String extension;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    public DetachedFileQueryWebRequest() {

    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
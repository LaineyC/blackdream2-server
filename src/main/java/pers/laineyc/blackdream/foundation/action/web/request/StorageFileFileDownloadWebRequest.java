package pers.laineyc.blackdream.foundation.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 游离文件下载Request
 * @author LaineyC
 */
@ApiModel
public class StorageFileFileDownloadWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    public StorageFileFileDownloadWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
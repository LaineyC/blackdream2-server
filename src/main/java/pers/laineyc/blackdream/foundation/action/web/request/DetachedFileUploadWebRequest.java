package pers.laineyc.blackdream.foundation.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 游离文件上传Request
 * @author LaineyC
 */
@ApiModel
public class DetachedFileUploadWebRequest extends Request {

    @ApiModelProperty(value = "文件", required = true)
    private MultipartFile file;

    public DetachedFileUploadWebRequest() {

    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

}
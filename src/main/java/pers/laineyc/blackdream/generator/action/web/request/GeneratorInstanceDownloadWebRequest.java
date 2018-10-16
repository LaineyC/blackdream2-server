package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器实例创建Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceDownloadWebRequest extends Request {

    @ApiModelProperty(value = "url")
    private String url;

    public GeneratorInstanceDownloadWebRequest() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
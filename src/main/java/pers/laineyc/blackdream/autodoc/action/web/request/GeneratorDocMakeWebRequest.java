package pers.laineyc.blackdream.autodoc.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器文档生成Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDocMakeWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "文档语言：1Java")
    private Integer docLanguage;

    @ApiModelProperty(value = "是否生成文档")
    private Boolean isMakeDoc;

    @ApiModelProperty(value = "是否生成Sdk")
    private Boolean isMakeSdk;

    public GeneratorDocMakeWebRequest() {

    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public Integer getDocLanguage() {
        return docLanguage;
    }

    public void setDocLanguage(Integer docLanguage) {
        this.docLanguage = docLanguage;
    }

    public Boolean getIsMakeDoc() {
        return isMakeDoc;
    }

    public void setIsMakeDoc(Boolean isMakeDoc) {
        this.isMakeDoc = isMakeDoc;
    }

    public Boolean getIsMakeSdk() {
        return isMakeSdk;
    }

    public void setIsMakeSdk(Boolean isMakeSdk) {
        this.isMakeSdk = isMakeSdk;
    }
}
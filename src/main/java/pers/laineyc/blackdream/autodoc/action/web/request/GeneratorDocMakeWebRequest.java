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

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "文档语言")
    private Integer docLanguage;

    @ApiModelProperty(value = "是否生成文档")
    private Boolean isMakeDoc;

    @ApiModelProperty(value = "是否生成Sdk")
    private Boolean isMakeSdk;

    public GeneratorDocMakeWebRequest() {

    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
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
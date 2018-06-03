package pers.laineyc.blackdream.autodoc.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器文档生成Parameter
 * @author LaineyC
 */
public class GeneratorDocMakeParameter extends Parameter {

    /**
     * 所属生成器实例
     */
    private String generatorInstanceId;

    /**
     * 文档语言：1Java
     */
    private Integer docLanguage;

    /**
     * 是否生成文档
     */
    private Boolean isMakeDoc;

    /**
     * 是否生成Sdk
     */
    private Boolean isMakeSdk;

    public GeneratorDocMakeParameter() {

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
package pers.laineyc.blackdream.autodoc.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器文档生成Parameter
 * @author LaineyC
 */
public class GeneratorDocMakeParameter extends Parameter {

    /**
     * 所属生成器
     */
    private String generatorId;

    /**
     * 文档语言
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
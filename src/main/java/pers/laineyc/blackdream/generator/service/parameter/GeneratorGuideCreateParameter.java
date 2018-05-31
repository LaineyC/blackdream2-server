package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器指南创建Parameter
 * @author LaineyC
 */
public class GeneratorGuideCreateParameter extends Parameter {

    /**
     * 所属生成器
     */
    private String generatorId;

    /**
     * 名称
     */
    private String name;

    /**
     * 文档类型：1markdown
     */
    private Integer docType;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    public GeneratorGuideCreateParameter() {

    }

    public String getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
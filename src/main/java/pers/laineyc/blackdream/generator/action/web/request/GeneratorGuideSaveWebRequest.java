package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器指南保存Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorGuideSaveWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器")
    private Long generatorId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "文档类型：1markdown")
    private Integer docType;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "内容")
    private String content;

    public GeneratorGuideSaveWebRequest() {

    }

    public Long getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return name;
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
        return description;
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
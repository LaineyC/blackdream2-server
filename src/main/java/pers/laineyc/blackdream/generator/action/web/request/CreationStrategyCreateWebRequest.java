package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器生成策略创建Request
 * @author LaineyC
 */
@ApiModel
public class CreationStrategyCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "脚本语言：1javascript", required = true)
    private Integer scriptLanguage;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "脚本")
    private String script;

    public CreationStrategyCreateWebRequest() {

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

    public Integer getScriptLanguage() {
        return scriptLanguage;
    }

    public void setScriptLanguage(Integer scriptLanguage) {
        this.scriptLanguage = scriptLanguage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
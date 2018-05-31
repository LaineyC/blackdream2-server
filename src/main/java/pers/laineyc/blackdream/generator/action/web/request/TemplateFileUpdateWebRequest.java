package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器模板文件修改Request
 * @author LaineyC
 */
@ApiModel
public class TemplateFileUpdateWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "引擎类型：1Velocity；2FreeMarker")
    private Integer engineType;

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "脚本")
    private String script;

    public TemplateFileUpdateWebRequest() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDisplayGroup() {
        return this.displayGroup;
    }

    public void setDisplayGroup(String displayGroup) {
        this.displayGroup = displayGroup;
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
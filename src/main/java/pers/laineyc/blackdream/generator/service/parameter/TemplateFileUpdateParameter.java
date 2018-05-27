package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器模板文件修改Parameter
 * @author LaineyC
 */
public class TemplateFileUpdateParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 引擎类型：1Velocity；2FreeMarker
     */
    private Integer engineType;

    /**
     * 显示分组
     */
    private String displayGroup;

    /**
     * 描述
     */
    private String description;

    /**
     * 脚本
     */
    private String script;

    public TemplateFileUpdateParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
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
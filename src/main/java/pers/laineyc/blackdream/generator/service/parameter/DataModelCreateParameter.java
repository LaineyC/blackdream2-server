package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据模型创建Parameter
 * @author LaineyC
 */
public class DataModelCreateParameter extends Parameter {

    /**
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图标样式
     */
    private String iconStyle;

    /**
     * 描述
     */
    private String description;

    public DataModelCreateParameter() {

    }

    public Long getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
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

    public String getIconStyle() {
        return this.iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
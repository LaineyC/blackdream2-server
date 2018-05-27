package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器模板文件单个查询Parameter
 * @author LaineyC
 */
public class TemplateFileGetParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public TemplateFileGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
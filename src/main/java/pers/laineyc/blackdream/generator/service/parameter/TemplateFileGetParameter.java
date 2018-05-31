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
    private String id;

    public TemplateFileGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
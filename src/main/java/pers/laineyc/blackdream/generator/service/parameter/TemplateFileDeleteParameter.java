package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器模板文件删除Parameter
 * @author LaineyC
 */
public class TemplateFileDeleteParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public TemplateFileDeleteParameter() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
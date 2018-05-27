package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器单个查询Parameter
 * @author LaineyC
 */
public class GeneratorGetParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public GeneratorGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
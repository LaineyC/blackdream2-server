package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器数据单个查询Parameter
 * @author LaineyC
 */
public class GeneratorDataGetParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public GeneratorDataGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
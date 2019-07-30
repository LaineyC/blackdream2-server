package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器多个查询Parameter
 * @author LaineyC
 */
public class GeneratorQueryTopParameter extends Parameter {

    private Integer topNumber;

    public GeneratorQueryTopParameter() {

    }

    public Integer getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(Integer topNumber) {
        this.topNumber = topNumber;
    }
}
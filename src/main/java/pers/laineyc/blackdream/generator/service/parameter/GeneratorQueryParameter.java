package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器多个查询Parameter
 * @author LaineyC
 */
public class GeneratorQueryParameter extends Parameter {

    /**
     * 所属用户
     */
    private String userId;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：1开发；2发布
     */
    private Integer status;

    /**
     * 引擎类型：1Velocity；2FreeMarker
     */
    private Integer engineType;

    public GeneratorQueryParameter() {

    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

}
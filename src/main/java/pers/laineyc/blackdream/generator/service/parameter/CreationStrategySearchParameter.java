package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器生成策略分页查询Parameter
 * @author LaineyC
 */
public class CreationStrategySearchParameter extends Parameter {

    /**
     * 页数
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 所属用户
     */
    private String userId;

    /**
     * 所属生成器
     */
    private String generatorId;

    /**
     * 名称
     */
    private String name;

    public CreationStrategySearchParameter() {

    }
        
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
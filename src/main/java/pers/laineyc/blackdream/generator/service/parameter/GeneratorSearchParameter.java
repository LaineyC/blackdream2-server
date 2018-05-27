package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器分页查询Parameter
 * @author LaineyC
 */
public class GeneratorSearchParameter extends Parameter {

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
    private Long userId;

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

    public GeneratorSearchParameter() {

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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
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
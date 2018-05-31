package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器实例分页查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceInfoSearchWebRequest extends Request {

    @ApiModelProperty(value = "页数", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    public GeneratorInstanceInfoSearchWebRequest() {

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

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
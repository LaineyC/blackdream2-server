package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据分页查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataSearchWebRequest extends Request {

    @ApiModelProperty(value = "页数", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "所属用户")
    private String userId;

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "所属生成器数据模型")
    private String dataModelId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "父节点")
    private String parentId;

    public GeneratorDataSearchWebRequest() {

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

    public String getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getDataModelId() {
        return this.dataModelId;
    }

    public void setDataModelId(String dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

}
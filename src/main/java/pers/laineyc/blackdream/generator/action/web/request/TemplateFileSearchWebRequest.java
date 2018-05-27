package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器模板文件分页查询Request
 * @author LaineyC
 */
@ApiModel
public class TemplateFileSearchWebRequest extends Request {

    @ApiModelProperty(value = "页数", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "所属用户")
    private Long userId;

    @ApiModelProperty(value = "所属生成器")
    private Long generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "引擎类型：1Velocity；2FreeMarker")
    private Integer engineType;

    @ApiModelProperty(value = "显示分组")
    private String displayGroup;

    public TemplateFileSearchWebRequest() {

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

    public Long getGeneratorId() {
        return this.generatorId;
    }

    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDisplayGroup() {
        return this.displayGroup;
    }

    public void setDisplayGroup(String displayGroup) {
        this.displayGroup = displayGroup;
    }

}
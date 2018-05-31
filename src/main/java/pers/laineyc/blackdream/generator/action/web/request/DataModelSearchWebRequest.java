package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据模型分页查询Request
 * @author LaineyC
 */
@ApiModel
public class DataModelSearchWebRequest extends Request {

    @ApiModelProperty(value = "页数", required = true)
    private Integer page;

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize;

    @ApiModelProperty(value = "所属用户")
    private String userId;

    @ApiModelProperty(value = "所属生成器")
    private String generatorId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "图标样式", required = true)
    private String iconStyle;

    public DataModelSearchWebRequest() {

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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIconStyle() {
        return this.iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

}
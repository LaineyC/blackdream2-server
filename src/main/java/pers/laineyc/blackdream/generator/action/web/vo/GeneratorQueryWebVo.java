package pers.laineyc.blackdream.generator.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;

/**
 * 生成器
 * @author LaineyC
 */
@ApiModel
public class GeneratorQueryWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "状态：1开发；2发布")
    private Integer status;

    @ApiModelProperty(value = "版本号")
    private Integer releaseVersion;

    @ApiModelProperty(value = "发布时间")
    private Date releaseTime;

    @ApiModelProperty(value = "开发时间")
    private Date developTime;

    @ApiModelProperty(value = "引擎类型：1Velocity；2FreeMarker")
    private Integer engineType;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

	public GeneratorQueryWebVo() {

	}

    public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

	public void setUser(User user) {
        this.user = user;
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

    public Integer getReleaseVersion() {
        return this.releaseVersion;
    }

	public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Date getReleaseTime() {
        return this.releaseTime;
    }

	public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getDevelopTime() {
        return this.developTime;
    }

	public void setDevelopTime(Date developTime) {
        this.developTime = developTime;
    }

    public Integer getEngineType() {
        return this.engineType;
    }

	public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModel
    public static class User {

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "名称")
        private String name;

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.Date;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器
 * @author LaineyC
 */
public class Generator extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 所属用户
     */
    private User user;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：1开发；2发布
     */
    private Integer status;

    /**
     * 版本号
     */
    private Integer releaseVersion;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 开发时间
     */
    private Date developTime;

    /**
     * 引擎类型：1Velocity；2FreeMarker
     */
    private Integer engineType;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public Generator() {

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

}
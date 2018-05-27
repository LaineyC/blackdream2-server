package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.Date;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器实例
 * @author LaineyC
 */
public class GeneratorInstance extends Domain {

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
     * 所属生成器
     */
    private Generator generator;

    /**
     * 名称
     */
    private String name;

    /**
     * 发布版本号
     */
    private Integer releaseVersion;

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

	public GeneratorInstance() {

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

    public Generator getGenerator() {
        return this.generator;
    }

	public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseVersion() {
        return this.releaseVersion;
    }

	public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
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
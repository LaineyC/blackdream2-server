package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 生成器Po
 * @author LaineyC
 */
@Document(collection = "Generator")
public class GeneratorPo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private Long id;

	/**
	 *  所属用户
	 */
    @Indexed
	private Long userId;

	/**
	 *  名称
	 */
	private String name;

	/**
	 *  状态：1开发；2发布
	 */
	private Integer status;

	/**
	 *  版本号
	 */
	private Integer releaseVersion;

	/**
	 *  发布时间
	 */
	private Date releaseTime;

	/**
	 *  开发时间
	 */
	private Date developTime;

	/**
	 *  引擎类型：1Velocity；2FreeMarker
	 */
	private Integer engineType;

	/**
	 *  描述
	 */
	private String description;

	/**
	 *  是否删除
	 */
	private Boolean isDeleted;

	/**
	 *  创建时间
	 */
	private Date createTime;

	/**
	 *  修改时间
	 */
	private Date updateTime;

	public GeneratorPo() {

	}

    public Long getId() {
        return id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

	public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

	public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReleaseVersion() {
        return releaseVersion;
    }

	public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

	public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getDevelopTime() {
        return developTime;
    }

	public void setDevelopTime(Date developTime) {
        this.developTime = developTime;
    }

    public Integer getEngineType() {
        return engineType;
    }

	public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

	public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
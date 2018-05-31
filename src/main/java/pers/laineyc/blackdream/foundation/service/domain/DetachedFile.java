package pers.laineyc.blackdream.foundation.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.Date;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 游离文件
 * @author LaineyC
 */
public class DetachedFile extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 所属用户
     */
    private User user;

    /**
     * 状态：1游离；2受管
     */
    private Integer status;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 扩展名
     */
    private String extension;

    /**
     * 文件类型
     */
    private String contentType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public DetachedFile() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

	public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSize() {
        return this.size;
    }

	public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return this.extension;
    }

	public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return this.contentType;
    }

	public void setContentType(String contentType) {
        this.contentType = contentType;
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
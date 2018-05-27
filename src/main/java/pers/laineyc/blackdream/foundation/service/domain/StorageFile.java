package pers.laineyc.blackdream.foundation.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author LaineyC
 */
public class StorageFile extends Domain{

    /**
     * 主键
     */
    private Long id;

    /**
     * 所属用户
     */
    private User user;

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

    private InputStream inputStream;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

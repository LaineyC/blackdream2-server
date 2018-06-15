package pers.laineyc.blackdream.usercenter.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;

import java.util.Date;

/**
 * 用户认证
 * @author LaineyC
 */
public class UserAuth extends Domain {

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
     * 状态：1冻结；2启用
     */
    private Integer status;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     *  密码
     */
    private String password;

    /**
     *  访问令牌
     */
    private String accessToken;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public UserAuth() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getStatus() {
        return this.status;
    }

	public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
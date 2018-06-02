package pers.laineyc.blackdream.usercenter.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.Date;

/**
 * 用户
 * @author LaineyC
 */
public class User extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 状态：1冻结；2启用
     */
    private Integer status;

    /**
     * 状态：1一般用户；2开发用户
     */
    private Integer type;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像文件
     */
    private String iconFileId;

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
     * 登录次数
     */
    private Integer signInCount;

    /**
     * 登录IP
     */
    private String signInIp;

    /**
     * 登录时间
     */
    private Date signInTime;

    /**
     * 注册时间
     */
    private Date signUpTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public User() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return this.status;
    }

	public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickname() {
        return this.nickname;
    }

	public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId;
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

    public Integer getSignInCount() {
        return this.signInCount;
    }

	public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public String getSignInIp() {
        return this.signInIp;
    }

	public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public Date getSignInTime() {
        return this.signInTime;
    }

	public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignUpTime() {
        return this.signUpTime;
    }

	public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
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
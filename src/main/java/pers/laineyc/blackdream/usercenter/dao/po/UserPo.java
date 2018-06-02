package pers.laineyc.blackdream.usercenter.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 用户Po
 * @author LaineyC
 */
@Document(collection = "User")
public class UserPo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private String id;

	/**
	 *  状态：1冻结；2启用
	 */
	private Integer status;

    /**
     * 状态：1一般用户；2开发用户
     */
    private Integer type;

	/**
	 *  昵称
	 */
	private String nickname;

	/**
	 *  头像文件Id
	 */
	private String iconFileId;

	/**
	 *  用户名
	 */
    @Indexed(unique = true)
	private String username;

	/**
	 *  邮箱
	 */
    @Indexed(unique = true)
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
	 *  登录次数
	 */
	private Integer signInCount;

	/**
	 *  登录IP
	 */
	private String signInIp;

	/**
	 *  登录时间
	 */
	private Date signInTime;

	/**
	 *  注册时间
	 */
	private Date signUpTime;

	/**
	 *  创建时间
	 */
	private Date createTime;

	/**
	 *  修改时间
	 */
	private Date updateTime;

	public UserPo() {

	}

    public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
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
        return nickname;
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
        return username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
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
        return signInCount;
    }

	public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public String getSignInIp() {
        return signInIp;
    }

	public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public Date getSignInTime() {
        return signInTime;
    }

	public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignUpTime() {
        return signUpTime;
    }

	public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
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
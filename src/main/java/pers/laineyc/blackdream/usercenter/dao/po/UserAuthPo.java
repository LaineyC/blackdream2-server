package pers.laineyc.blackdream.usercenter.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;

import java.util.Date;

/**
 * 用户认证Po
 * @author LaineyC
 */
@Document(collection = "UserAuth")
public class UserAuthPo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private String id;

    /**
     * 所属用户
     */
    @Indexed(unique = true)
    private String userId;

	/**
	 *  状态：1冻结；2启用
	 */
	private Integer status;

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
	 *  创建时间
	 */
	private Date createTime;

	/**
	 *  修改时间
	 */
	private Date updateTime;

	public UserAuthPo() {

	}

    public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

	public void setStatus(Integer status) {
        this.status = status;
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
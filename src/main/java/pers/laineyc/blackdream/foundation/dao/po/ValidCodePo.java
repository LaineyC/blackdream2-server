package pers.laineyc.blackdream.foundation.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 验证码Po
 * @author LaineyC
 */
@Document(collection = "ValidCode")
public class ValidCodePo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private String id;

    /**
     * 用户id
     */
    private String userId;

	/**
	 *  类型：1注册；2找回密码
	 */
	private Integer type;

	/**
	 *  发送平台类型：1邮箱
	 */
	private Integer platformType;

	/**
	 *  平台账号（如手机、邮箱）
	 */
	private String platformAccount;

	/**
	 *  验证码
	 */
	private String code;

	/**
	 *  发送间隔时间（秒）
	 */
	private Integer interval;

	/**
	 *  发送超时时间（秒）
	 */
	private Integer timeout;

	/**
	 *  验证失败次数
	 */
	private Integer failCount;

	/**
	 *  允许验证次数
	 */
	private Integer maxFailCount;

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

	public ValidCodePo() {

	}

    public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

	public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlatformType() {
        return platformType;
    }

	public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getPlatformAccount() {
        return platformAccount;
    }

	public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
    }

    public String getCode() {
        return code;
    }

	public void setCode(String code) {
        this.code = code;
    }

    public Integer getInterval() {
        return interval;
    }

	public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getTimeout() {
        return timeout;
    }

	public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getFailCount() {
        return failCount;
    }

	public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getMaxFailCount() {
        return maxFailCount;
    }

	public void setMaxFailCount(Integer maxFailCount) {
        this.maxFailCount = maxFailCount;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
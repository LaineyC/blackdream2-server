package pers.laineyc.blackdream.foundation.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;

import java.util.Date;

/**
 * 验证码
 * @author LaineyC
 */
@ApiModel
public class ValidCode extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "类型：1注册；2找回密码")
    private Integer type;

    @ApiModelProperty(value = "发送平台类型：1邮箱")
    private Integer platformType;

    @ApiModelProperty(value = "平台账号（如手机、邮箱）")
    private String platformAccount;

    @ApiModelProperty(value = "验证码")
    private String code;

    @ApiModelProperty(value = "发送间隔时间（秒）")
    private Integer interval;

    @ApiModelProperty(value = "发送超时时间（秒）")
    private Integer timeout;

    @ApiModelProperty(value = "验证失败次数")
    private Integer failCount;

    @ApiModelProperty(value = "允许验证次数")
    private Integer maxFailCount;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

	public ValidCode() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

	public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlatformType() {
        return this.platformType;
    }

	public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    public String getPlatformAccount() {
        return this.platformAccount;
    }

	public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
    }

    public String getCode() {
        return this.code;
    }

	public void setCode(String code) {
        this.code = code;
    }

    public Integer getInterval() {
        return this.interval;
    }

	public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

	public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getFailCount() {
        return this.failCount;
    }

	public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public Integer getMaxFailCount() {
        return this.maxFailCount;
    }

	public void setMaxFailCount(Integer maxFailCount) {
        this.maxFailCount = maxFailCount;
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
package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 验证码多个查询Parameter
 * @author LaineyC
 */
public class ValidCodeQueryParameter extends Parameter {

    /**
     * 类型：1注册；2找回密码
     */
    private Integer type;

    /**
     * 发送平台类型：1邮箱
     */
    private Integer platformType;

    /**
     * 平台账号（如手机、邮箱）
     */
    private String platformAccount;

    /**
     * 验证码
     */
    private String code;

    /**
     * 发送间隔时间（秒）
     */
    private Integer interval;

    /**
     * 发送超时时间（秒）
     */
    private Integer timeout;

    /**
     * 验证失败次数
     */
    private Integer failCount;

    /**
     * 允许验证次数
     */
    private Integer maxFailCount;

    public ValidCodeQueryParameter() {

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

}
package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.foundation.constant.ValidCodeTypeEnum;
import pers.laineyc.blackdream.framework.service.parameter.Parameter;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证码创建Parameter
 * @author LaineyC
 */
public class ValidCodeSendParameter extends Parameter {

    /**
     * 类型：1注册；2找回密码
     */
    private ValidCodeTypeEnum type;

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
     * 允许验证次数
     */
    private Integer maxFailCount;

    /**
     * 模板参数
     */
    private Map<String, String> templateParameter = new HashMap<>();

    public ValidCodeSendParameter() {

    }

    public ValidCodeTypeEnum getType() {
        return this.type;
    }

    public void setType(ValidCodeTypeEnum type) {
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

    public Integer getMaxFailCount() {
        return this.maxFailCount;
    }

    public void setMaxFailCount(Integer maxFailCount) {
        this.maxFailCount = maxFailCount;
    }

    public Map<String, String> getTemplateParameter() {
        return templateParameter;
    }

    public void setTemplateParameter(Map<String, String> templateParameter) {
        this.templateParameter = templateParameter;
    }
}
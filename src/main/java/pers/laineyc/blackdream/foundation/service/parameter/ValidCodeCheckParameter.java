package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.foundation.constant.ValidCodeTypeEnum;
import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 验证码验证有效Parameter
 * @author LaineyC
 */
public class ValidCodeCheckParameter extends Parameter {

    /**
     * 类型：1注册；2找回密码
     */
    private ValidCodeTypeEnum type;

    /**
     * 平台账号（如手机、邮箱）
     */
    private String platformAccount;

    /**
     * 验证码
     */
    private String code;

    public ValidCodeCheckParameter() {

    }

    public ValidCodeTypeEnum getType() {
        return type;
    }

    public void setType(ValidCodeTypeEnum type) {
        this.type = type;
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
}
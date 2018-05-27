package pers.laineyc.blackdream.usercenter.tool;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LaineyC
 *
 */
public class EmailValidCode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String validCode;

    /**
     * 间隔时间
     */
    private Integer interval;

    /**
     * 失效时间
     */
    private Integer timeout;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 验证错误次数
     */
    private Integer errorTimes;

    public EmailValidCode(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getErrorTimes() {
        return errorTimes;
    }

    public void setErrorTimes(Integer errorTimes) {
        this.errorTimes = errorTimes;
    }

}

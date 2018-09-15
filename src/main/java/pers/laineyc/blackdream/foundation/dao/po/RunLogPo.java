package pers.laineyc.blackdream.foundation.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 用户
 * @author LaineyC
 */
@Document(collection = "RunLog")
public class RunLogPo extends Po {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    /**
     * 日志级别
     *  1-5
     *  DEBUG < INFO < WARN < ERROR < FATAL
     */
    private Integer level;

    /**
     * 调用时间
     */
    private Date invokeTime;

    /**
     * 运行耗时
     */
    private Long runTime;

    /**
     * 日志模块
     */
    private String module;

    /**
     * 接口名称 可以是url，也可以是方法名称
     */
    private String action;

    /**
     * 公共参数
     */
    private String commonParameter;

    /**
     * 请求参数
     */
    private String requestParameter;

    /**
     * 请求auth参数
     */
    private String authParameter;

    /**
     * 日志描述
     */
    private String message;

    /**
     * 异常信息
     */
    private String exception;

	public RunLogPo() {

	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getInvokeTime() {
        return invokeTime;
    }

    public void setInvokeTime(Date invokeTime) {
        this.invokeTime = invokeTime;
    }

    public Long getRunTime() {
        return runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCommonParameter() {
        return commonParameter;
    }

    public void setCommonParameter(String commonParameter) {
        this.commonParameter = commonParameter;
    }

    public String getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(String requestParameter) {
        this.requestParameter = requestParameter;
    }

    public String getAuthParameter() {
        return authParameter;
    }

    public void setAuthParameter(String authParameter) {
        this.authParameter = authParameter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
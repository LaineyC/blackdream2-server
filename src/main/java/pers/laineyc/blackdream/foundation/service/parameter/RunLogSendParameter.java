package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.parameter.Parameter;

import java.util.Date;
import java.util.Map;

/**
 * 用户自动登录Parameter
 * @author LaineyC
 */
public class RunLogSendParameter extends Parameter {

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
     * 接口名称 可以是url，也可以是方法名称
     */
    private String action;

    /**
     * 公共参数
     */
    private Map<String, Object> commonParameter;

    /**
     * 请求参数
     */
    private Request requestParameter;

    /**
     * 请求auth参数
     */
    private Auth authParameter;

    /**
     * 日志描述
     */
    private String message;

    /**
     * 异常信息
     */
    private Exception exception;

    public RunLogSendParameter() {

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, Object> getCommonParameter() {
        return commonParameter;
    }

    public void setCommonParameter(Map<String, Object> commonParameter) {
        this.commonParameter = commonParameter;
    }

    public Request getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(Request requestParameter) {
        this.requestParameter = requestParameter;
    }

    public Auth getAuthParameter() {
        return authParameter;
    }

    public void setAuthParameter(Auth authParameter) {
        this.authParameter = authParameter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
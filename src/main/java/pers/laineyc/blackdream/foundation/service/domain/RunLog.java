package pers.laineyc.blackdream.foundation.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.Date;
import java.util.Map;

/**
 * 用户
 * @author LaineyC
 */
@ApiModel
public class RunLog extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "日志级别  1-5 DEBUG < INFO < WARN < ERROR < FATAL")
    private Integer level;

    @ApiModelProperty(value = "调用时间")
    private Date invokeTime;

    @ApiModelProperty(value = "运行耗时")
    private Long runTime;

    @ApiModelProperty(value = "日志模块")
    private String module;

    @ApiModelProperty(value = "接口名称 可以是url，也可以是方法名称")
    private String action;

    @ApiModelProperty(value = "公共参数")
    private Map<String, Object> commonParameter;

    @ApiModelProperty(value = "请求参数")
    private Map<String, Object> requestParameter;

    @ApiModelProperty(value = "请求auth参数")
    private Map<String, Object> authParameter;

    @ApiModelProperty(value = "日志描述")
    private String message;

    @ApiModelProperty(value = "异常信息")
    private String exception;

	public RunLog() {

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

    public Map<String, Object> getCommonParameter() {
        return commonParameter;
    }

    public void setCommonParameter(Map<String, Object> commonParameter) {
        this.commonParameter = commonParameter;
    }

    public Map<String, Object> getRequestParameter() {
        return requestParameter;
    }

    public void setRequestParameter(Map<String, Object> requestParameter) {
        this.requestParameter = requestParameter;
    }

    public Map<String, Object> getAuthParameter() {
        return authParameter;
    }

    public void setAuthParameter(Map<String, Object> authParameter) {
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
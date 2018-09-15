package pers.laineyc.blackdream.foundation.dao.query;

import pers.laineyc.blackdream.foundation.dao.po.ValidCodePo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.util.Date;

/**
 * 验证码Query
 * @author LaineyC
 */
public class ValidCodeQuery extends Query<ValidCodePo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

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
     * 平台账号（如手机、邮箱）Like
     */
    private String platformAccountLike;

    /**
     * 验证码
     */
    private String code;
	
    /**
     * 验证码Like
     */
    private String codeLike;

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

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public ValidCodeQuery() {

	}
	
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
        if(this.id != null){
            this.addWhereExpression(ExpressionBuilder.equal("id", this.id));
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if(this.userId != null){
            this.addWhereExpression(ExpressionBuilder.equal("userId", this.userId));
        }
    }

    public Integer getType() {
        return type;
    }
    
    public void setType(Integer type) {
        this.type = type;
        if(this.type != null){
            this.addWhereExpression(ExpressionBuilder.equal("type", this.type));
        }
    }

    public Integer getPlatformType() {
        return platformType;
    }
    
    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
        if(this.platformType != null){
            this.addWhereExpression(ExpressionBuilder.equal("platformType", this.platformType));
        }
    }

    public String getPlatformAccount() {
        return platformAccount;
    }
    
    public void setPlatformAccount(String platformAccount) {
        this.platformAccount = platformAccount;
        if(this.platformAccount != null){
            this.addWhereExpression(ExpressionBuilder.equal("platformAccount", this.platformAccount));
        }
    }
    
    public String getPlatformAccountLike() {
        return platformAccountLike;
    }
    
    public void setPlatformAccountLike(String platformAccountLike) {
        if(platformAccountLike == null || platformAccountLike.isEmpty()){
            return;
        }
        this.platformAccountLike = platformAccountLike;
        this.addWhereExpression(ExpressionBuilder.like("platformAccount", this.platformAccountLike));
    }

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
        if(this.code != null){
            this.addWhereExpression(ExpressionBuilder.equal("code", this.code));
        }
    }
    
    public String getCodeLike() {
        return codeLike;
    }
    
    public void setCodeLike(String codeLike) {
        if(codeLike == null || codeLike.isEmpty()){
            return;
        }
        this.codeLike = codeLike;
        this.addWhereExpression(ExpressionBuilder.like("code", this.codeLike));
    }

    public Integer getInterval() {
        return interval;
    }
    
    public void setInterval(Integer interval) {
        this.interval = interval;
        if(this.interval != null){
            this.addWhereExpression(ExpressionBuilder.equal("interval", this.interval));
        }
    }

    public Integer getTimeout() {
        return timeout;
    }
    
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
        if(this.timeout != null){
            this.addWhereExpression(ExpressionBuilder.equal("timeout", this.timeout));
        }
    }

    public Integer getFailCount() {
        return failCount;
    }
    
    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
        if(this.failCount != null){
            this.addWhereExpression(ExpressionBuilder.equal("failCount", this.failCount));
        }
    }

    public Integer getMaxFailCount() {
        return maxFailCount;
    }
    
    public void setMaxFailCount(Integer maxFailCount) {
        this.maxFailCount = maxFailCount;
        if(this.maxFailCount != null){
            this.addWhereExpression(ExpressionBuilder.equal("maxFailCount", this.maxFailCount));
        }
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        if(this.isDeleted != null){
            this.addWhereExpression(ExpressionBuilder.equal("isDeleted", this.isDeleted));
        }
    }

    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        if(this.createTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("createTime", this.createTime));
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        if(this.updateTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("updateTime", this.updateTime));
        }
    }

}
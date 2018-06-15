package pers.laineyc.blackdream.usercenter.dao.query;

import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import pers.laineyc.blackdream.usercenter.dao.po.UserAuthPo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户认证Query
 * @author LaineyC
 */
public class UserAuthQuery extends Query<UserAuthPo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 主键
     */
    private List<String> idList = new ArrayList<>();

    /**
     * 所属用户
     */
    private String userId;

    /**
     * 状态：1冻结；2启用
     */
    private Integer status;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户名Like
     */
    private String usernameLike;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱Like
     */
    private String emailLike;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码Like
     */
    private String passwordLike;

    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 访问令牌Like
     */
    private String accessTokenLike;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public UserAuthQuery() {

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

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
        if(this.idList != null && !this.idList.isEmpty()){
            this.addWhereExpression(ExpressionBuilder.in("id", this.idList));
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

    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
        if(this.status != null){
            this.addWhereExpression(ExpressionBuilder.equal("status", this.status));
        }
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
        if(this.username != null){
            this.addWhereExpression(ExpressionBuilder.equal("username", this.username));
        }
    }
    
    public String getUsernameLike() {
        return usernameLike;
    }
    
    public void setUsernameLike(String usernameLike) {
        if(usernameLike == null || usernameLike.isEmpty()){
            return;
        }
        this.usernameLike = usernameLike;
        this.addWhereExpression(ExpressionBuilder.like("username", this.usernameLike));
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
        if(this.email != null){
            this.addWhereExpression(ExpressionBuilder.equal("email", this.email));
        }
    }
    
    public String getEmailLike() {
        return emailLike;
    }
    
    public void setEmailLike(String emailLike) {
        if(emailLike == null || emailLike.isEmpty()){
            return;
        }
        this.emailLike = emailLike;
        this.addWhereExpression(ExpressionBuilder.like("email", this.emailLike));
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
        if(this.password != null){
            this.addWhereExpression(ExpressionBuilder.equal("password", this.password));
        }
    }
    
    public String getPasswordLike() {
        return passwordLike;
    }
    
    public void setPasswordLike(String passwordLike) {
        if(passwordLike == null || passwordLike.isEmpty()){
            return;
        }
        this.passwordLike = passwordLike;
        this.addWhereExpression(ExpressionBuilder.like("password", this.passwordLike));
    }

    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        if(this.accessToken != null){
            this.addWhereExpression(ExpressionBuilder.equal("accessToken", this.accessToken));
        }
    }
    
    public String getAccessTokenLike() {
        return accessTokenLike;
    }
    
    public void setAccessTokenLike(String accessTokenLike) {
        if(accessTokenLike == null || accessTokenLike.isEmpty()){
            return;
        }
        this.accessTokenLike = accessTokenLike;
        this.addWhereExpression(ExpressionBuilder.like("accessToken", this.accessTokenLike));
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
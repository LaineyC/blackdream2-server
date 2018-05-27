package pers.laineyc.blackdream.usercenter.dao.query;

import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.util.Date;

/**
 * 用户Query
 * @author LaineyC
 */
public class UserQuery extends Query<UserPo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态：1冻结；2启用
     */
    private Integer status;

    /**
     * 昵称
     */
    private String nickname;
	
    /**
     * 昵称Like
     */
    private String nicknameLike;

    /**
     * 头像文件Id
     */
    private Long iconFileId;

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
     * 登录次数
     */
    private Integer signInCount;

    /**
     * 登录IP
     */
    private String signInIp;
	
    /**
     * 登录IPLike
     */
    private String signInIpLike;

    /**
     * 登录时间
     */
    private Date signInTime;

    /**
     * 注册时间
     */
    private Date signUpTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public UserQuery() {

	}
	
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
        if(this.id != null){
            this.addWhereExpression(ExpressionBuilder.equal("id", this.id));
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

    public String getNickname() {
        return nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
        if(this.nickname != null){
            this.addWhereExpression(ExpressionBuilder.equal("nickname", this.nickname));
        }
    }
    
    public String getNicknameLike() {
        return nicknameLike;
    }
    
    public void setNicknameLike(String nicknameLike) {
        if(nicknameLike == null || nicknameLike.isEmpty()){
            return;
        }
        this.nicknameLike = nicknameLike;
        this.addWhereExpression(ExpressionBuilder.like("nickname", this.nicknameLike));
    }

    public Long getIconFileId() {
        return iconFileId;
    }
    
    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
        if(this.iconFileId != null){
            this.addWhereExpression(ExpressionBuilder.equal("iconFileId", this.iconFileId));
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

    public Integer getSignInCount() {
        return signInCount;
    }
    
    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
        if(this.signInCount != null){
            this.addWhereExpression(ExpressionBuilder.equal("signInCount", this.signInCount));
        }
    }

    public String getSignInIp() {
        return signInIp;
    }
    
    public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
        if(this.signInIp != null){
            this.addWhereExpression(ExpressionBuilder.equal("signInIp", this.signInIp));
        }
    }
    
    public String getSignInIpLike() {
        return signInIpLike;
    }
    
    public void setSignInIpLike(String signInIpLike) {
        if(signInIpLike == null || signInIpLike.isEmpty()){
            return;
        }
        this.signInIpLike = signInIpLike;
        this.addWhereExpression(ExpressionBuilder.like("signInIp", this.signInIpLike));
    }

    public Date getSignInTime() {
        return signInTime;
    }
    
    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
        if(this.signInTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("signInTime", this.signInTime));
        }
    }

    public Date getSignUpTime() {
        return signUpTime;
    }
    
    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
        if(this.signUpTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("signUpTime", this.signUpTime));
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
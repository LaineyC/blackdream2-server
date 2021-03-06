package pers.laineyc.blackdream.usercenter.dao.query;

import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户Query
 * @author LaineyC
 */
public class UserQuery extends Query<UserPo> {

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
     * 状态：1一般用户；2开发用户
     */
    private Integer type;

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
    private String iconFileId;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public UserQuery() {

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
        if(this.type != null){
            this.addWhereExpression(ExpressionBuilder.equal("type", this.type));
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

    public String getIconFileId() {
        return iconFileId;
    }
    
    public void setIconFileId(String iconFileId) {
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
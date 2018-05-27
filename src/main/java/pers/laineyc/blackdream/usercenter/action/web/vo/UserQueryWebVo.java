package pers.laineyc.blackdream.usercenter.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;

/**
 * 用户
 * @author LaineyC
 */
@ApiModel
public class UserQueryWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "状态：1冻结；2启用")
    private Integer status;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像文件")
    private Long iconFileId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "登录次数")
    private Integer signInCount;

    @ApiModelProperty(value = "登录IP")
    private String signInIp;

    @ApiModelProperty(value = "登录时间")
    private Date signInTime;

    @ApiModelProperty(value = "注册时间")
    private Date signUpTime;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

	public UserQueryWebVo() {

	}

    public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return this.status;
    }

	public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return this.nickname;
    }

	public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
    }

    public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSignInCount() {
        return this.signInCount;
    }

	public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public String getSignInIp() {
        return this.signInIp;
    }

	public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public Date getSignInTime() {
        return this.signInTime;
    }

	public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public Date getSignUpTime() {
        return this.signUpTime;
    }

	public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
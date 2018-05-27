package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户修改Parameter
 * @author LaineyC
 */
public class UserUpdateParameter extends Parameter {

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
     * 头像文件Id
     */
    private Long iconFileId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    public UserUpdateParameter() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
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
        return this.iconFileId;
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

}
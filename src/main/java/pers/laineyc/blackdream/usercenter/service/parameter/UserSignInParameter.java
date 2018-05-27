package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户登录Parameter
 * @author LaineyC
 */
public class UserSignInParameter extends Parameter {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public UserSignInParameter() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
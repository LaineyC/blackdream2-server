package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 用户令牌登录Parameter
 * @author LaineyC
 */
public class UserTokenSignInParameter extends Parameter {

    /**
     * 登录令牌
     */
    private String accessToken;

    public UserTokenSignInParameter() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
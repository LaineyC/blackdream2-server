package pers.laineyc.blackdream.usercenter.model;

import java.util.Date;

/**
 * @author LaineyC
 */
public class AccessToken {

    /**
     * 到期时间
     */
    private Date expiryTime;

    private AccessTokenBody body;

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public AccessTokenBody getBody() {
        return body;
    }

    public void setBody(AccessTokenBody body) {
        this.body = body;
    }

}

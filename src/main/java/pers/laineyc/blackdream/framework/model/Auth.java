package pers.laineyc.blackdream.framework.model;

import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private Integer userType;

    public Auth() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
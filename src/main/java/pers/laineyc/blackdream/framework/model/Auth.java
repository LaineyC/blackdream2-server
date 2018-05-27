package pers.laineyc.blackdream.framework.model;

import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    public Auth() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
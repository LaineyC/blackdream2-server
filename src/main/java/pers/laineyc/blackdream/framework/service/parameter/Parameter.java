package pers.laineyc.blackdream.framework.service.parameter;

import java.io.Serializable;
import pers.laineyc.blackdream.framework.model.Auth;

/**
 * @author LaineyC
 *
 */
public class Parameter implements Serializable {

    private Auth auth;

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}

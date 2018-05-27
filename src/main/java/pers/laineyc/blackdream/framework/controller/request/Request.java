package pers.laineyc.blackdream.framework.controller.request;

import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.model.Auth;
import java.io.Serializable;

/**
 * @author LaineyC
 *
 */
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    private Auth auth;

    public Request(){

    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

}


package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * @author LaineyC
 */
public class UserProfileChangeParameter extends Parameter {

    /**
     * 昵称
     */
    private String nickname;

    public UserProfileChangeParameter() {

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
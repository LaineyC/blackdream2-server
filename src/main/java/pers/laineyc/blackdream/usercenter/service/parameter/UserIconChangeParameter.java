package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * @author LaineyC
 */
public class UserIconChangeParameter extends Parameter {

    /**
     * 头像文件
     */
    private String iconFileId;

    public UserIconChangeParameter() {

    }

    public String getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(String iconFileId) {
        this.iconFileId = iconFileId;
    }

}
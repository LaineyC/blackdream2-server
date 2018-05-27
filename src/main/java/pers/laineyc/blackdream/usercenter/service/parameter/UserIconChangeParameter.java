package pers.laineyc.blackdream.usercenter.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * @author LaineyC
 */
public class UserIconChangeParameter extends Parameter {

    /**
     * 头像文件
     */
    private Long iconFileId;

    public UserIconChangeParameter() {

    }

    public Long getIconFileId() {
        return iconFileId;
    }

    public void setIconFileId(Long iconFileId) {
        this.iconFileId = iconFileId;
    }

}
package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 游离文件单个查询Parameter
 * @author LaineyC
 */
public class DetachedFileGetParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public DetachedFileGetParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
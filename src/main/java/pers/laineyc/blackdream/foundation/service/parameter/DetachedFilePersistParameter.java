package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 游离文件处理Parameter
 * @author LaineyC
 */
public class DetachedFilePersistParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public DetachedFilePersistParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
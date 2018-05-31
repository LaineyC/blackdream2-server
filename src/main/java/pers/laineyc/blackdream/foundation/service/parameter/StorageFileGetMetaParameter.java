package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 游离文件下载Parameter
 * @author LaineyC
 */
public class StorageFileGetMetaParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    public StorageFileGetMetaParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
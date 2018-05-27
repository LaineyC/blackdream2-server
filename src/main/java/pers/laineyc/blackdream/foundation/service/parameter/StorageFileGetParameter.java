package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 游离文件下载Parameter
 * @author LaineyC
 */
public class StorageFileGetParameter extends Parameter {

    /**
     * 主键
     */
    private Long id;

    public StorageFileGetParameter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
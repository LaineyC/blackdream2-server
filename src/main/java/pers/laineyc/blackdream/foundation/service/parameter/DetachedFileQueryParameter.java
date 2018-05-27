package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 游离文件多个查询Parameter
 * @author LaineyC
 */
public class DetachedFileQueryParameter extends Parameter {

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 状态：1游离；2受管
     */
    private Integer status;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 扩展名
     */
    private String extension;

    /**
     * 文件类型
     */
    private String contentType;

    public DetachedFileQueryParameter() {

    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSize() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
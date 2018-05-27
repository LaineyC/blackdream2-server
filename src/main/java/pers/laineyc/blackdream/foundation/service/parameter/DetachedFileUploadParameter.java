package pers.laineyc.blackdream.foundation.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import java.io.InputStream;
import java.util.Date;

/**
 * 游离文件上传Parameter
 * @author LaineyC
 */
public class DetachedFileUploadParameter extends Parameter {

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

    private InputStream inputStream;

    public DetachedFileUploadParameter() {

    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
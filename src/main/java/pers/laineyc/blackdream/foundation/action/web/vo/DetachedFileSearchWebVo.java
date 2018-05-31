package pers.laineyc.blackdream.foundation.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;

/**
 * 游离文件
 * @author LaineyC
 */
@ApiModel
public class DetachedFileSearchWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "文件大小")
    private Long size;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "扩展名")
    private String extension;

    @ApiModelProperty(value = "文件类型")
    private String contentType;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

	public DetachedFileSearchWebVo() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

	public void setUser(User user) {
        this.user = user;
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

    public Date getCreateTime() {
        return this.createTime;
    }

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModel
    public static class User {

        @ApiModelProperty(value = "主键")
        private Long id;

        public User(){

        }

        public Long getId() {
            return this.id;
        }

    	public void setId(Long id) {
            this.id = id;
        }

    }

}
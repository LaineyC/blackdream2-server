package pers.laineyc.blackdream.foundation.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 游离文件Po
 * @author LaineyC
 */
@Document(collection = "DetachedFile")
public class DetachedFilePo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private Long id;

	/**
	 *  所属用户
	 */
	private Long userId;

    /**
     * 状态：1游离；2受管
     */
    private Integer status;

	/**
	 *  文件大小
	 */
	private Long size;

	/**
	 *  文件名称
	 */
	private String name;

	/**
	 *  扩展名
	 */
	private String extension;

	/**
	 *  文件类型
	 */
	private String contentType;

	/**
	 *  创建时间
	 */
	private Date createTime;

	/**
	 *  修改时间
	 */
	private Date updateTime;

	public DetachedFilePo() {

	}

    public Long getId() {
        return id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
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

    public Date getCreateTime() {
        return createTime;
    }

	public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

	public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
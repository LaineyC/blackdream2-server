package pers.laineyc.blackdream.foundation.dao.query;

import pers.laineyc.blackdream.foundation.dao.po.DetachedFilePo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.util.Date;

/**
 * 游离文件Query
 * @author LaineyC
 */
public class DetachedFileQuery extends Query<DetachedFilePo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

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
     * 文件名称Like
     */
    private String nameLike;

    /**
     * 扩展名
     */
    private String extension;
	
    /**
     * 扩展名Like
     */
    private String extensionLike;

    /**
     * 文件类型
     */
    private String contentType;
	
    /**
     * 文件类型Like
     */
    private String contentTypeLike;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public DetachedFileQuery() {

	}
	
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
        if(this.id != null){
            this.addWhereExpression(ExpressionBuilder.equal("id", this.id));
        }
    }

    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
        if(this.userId != null){
            this.addWhereExpression(ExpressionBuilder.equal("userId", this.userId));
        }
    }

    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
        if(this.status != null){
            this.addWhereExpression(ExpressionBuilder.equal("status", this.status));
        }
    }

    public Long getSize() {
        return size;
    }
    
    public void setSize(Long size) {
        this.size = size;
        if(this.size != null){
            this.addWhereExpression(ExpressionBuilder.equal("size", this.size));
        }
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        if(this.name != null){
            this.addWhereExpression(ExpressionBuilder.equal("name", this.name));
        }
    }
    
    public String getNameLike() {
        return nameLike;
    }
    
    public void setNameLike(String nameLike) {
        if(nameLike == null || nameLike.isEmpty()){
            return;
        }
        this.nameLike = nameLike;
        this.addWhereExpression(ExpressionBuilder.like("name", this.nameLike));
    }

    public String getExtension() {
        return extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
        if(this.extension != null){
            this.addWhereExpression(ExpressionBuilder.equal("extension", this.extension));
        }
    }
    
    public String getExtensionLike() {
        return extensionLike;
    }
    
    public void setExtensionLike(String extensionLike) {
        if(extensionLike == null || extensionLike.isEmpty()){
            return;
        }
        this.extensionLike = extensionLike;
        this.addWhereExpression(ExpressionBuilder.like("extension", this.extensionLike));
    }

    public String getContentType() {
        return contentType;
    }
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
        if(this.contentType != null){
            this.addWhereExpression(ExpressionBuilder.equal("contentType", this.contentType));
        }
    }
    
    public String getContentTypeLike() {
        return contentTypeLike;
    }
    
    public void setContentTypeLike(String contentTypeLike) {
        if(contentTypeLike == null || contentTypeLike.isEmpty()){
            return;
        }
        this.contentTypeLike = contentTypeLike;
        this.addWhereExpression(ExpressionBuilder.like("contentType", this.contentTypeLike));
    }

    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        if(this.createTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("createTime", this.createTime));
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        if(this.updateTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("updateTime", this.updateTime));
        }
    }

}
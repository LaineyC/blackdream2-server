package pers.laineyc.blackdream.generator.dao.query;

import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成器Query
 * @author LaineyC
 */
public class GeneratorQuery extends Query<GeneratorPo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 主键
     */
    private List<Long> idList = new ArrayList<>();

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 名称
     */
    private String name;
	
    /**
     * 名称Like
     */
    private String nameLike;

    /**
     * 状态：1开发；2发布
     */
    private Integer status;

    /**
     * 版本号
     */
    private Integer releaseVersion;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 开发时间
     */
    private Date developTime;

    /**
     * 引擎类型：1Velocity；2FreeMarker
     */
    private Integer engineType;

    /**
     * 描述
     */
    private String description;
	
    /**
     * 描述Like
     */
    private String descriptionLike;

    /**
     * 是否删除
     */
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

	public GeneratorQuery() {

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

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
        if(this.idList != null && !this.idList.isEmpty()){
            this.addWhereExpression(ExpressionBuilder.in("id", this.idList));
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

    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
        if(this.status != null){
            this.addWhereExpression(ExpressionBuilder.equal("status", this.status));
        }
    }

    public Integer getReleaseVersion() {
        return releaseVersion;
    }
    
    public void setReleaseVersion(Integer releaseVersion) {
        this.releaseVersion = releaseVersion;
        if(this.releaseVersion != null){
            this.addWhereExpression(ExpressionBuilder.equal("releaseVersion", this.releaseVersion));
        }
    }

    public Date getReleaseTime() {
        return releaseTime;
    }
    
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
        if(this.releaseTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("releaseTime", this.releaseTime));
        }
    }

    public Date getDevelopTime() {
        return developTime;
    }
    
    public void setDevelopTime(Date developTime) {
        this.developTime = developTime;
        if(this.developTime != null){
            this.addWhereExpression(ExpressionBuilder.equal("developTime", this.developTime));
        }
    }

    public Integer getEngineType() {
        return engineType;
    }
    
    public void setEngineType(Integer engineType) {
        this.engineType = engineType;
        if(this.engineType != null){
            this.addWhereExpression(ExpressionBuilder.equal("engineType", this.engineType));
        }
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
        if(this.description != null){
            this.addWhereExpression(ExpressionBuilder.equal("description", this.description));
        }
    }
    
    public String getDescriptionLike() {
        return descriptionLike;
    }
    
    public void setDescriptionLike(String descriptionLike) {
        if(descriptionLike == null || descriptionLike.isEmpty()){
            return;
        }
        this.descriptionLike = descriptionLike;
        this.addWhereExpression(ExpressionBuilder.like("description", this.descriptionLike));
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        if(this.isDeleted != null){
            this.addWhereExpression(ExpressionBuilder.equal("isDeleted", this.isDeleted));
        }
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
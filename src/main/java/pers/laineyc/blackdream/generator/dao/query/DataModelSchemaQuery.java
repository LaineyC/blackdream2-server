package pers.laineyc.blackdream.generator.dao.query;

import pers.laineyc.blackdream.generator.dao.po.DataModelSchemaPo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;
import java.util.Date;

/**
 * 生成器数据模型模式Query
 * @author LaineyC
 */
public class DataModelSchemaQuery extends Query<DataModelSchemaPo> {

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
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 名称
     */
    private String name;
	
    /**
     * 名称Like
     */
    private String nameLike;

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

	public DataModelSchemaQuery() {

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

    public Long getGeneratorId() {
        return generatorId;
    }
    
    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
        if(this.generatorId != null){
            this.addWhereExpression(ExpressionBuilder.equal("generatorId", this.generatorId));
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
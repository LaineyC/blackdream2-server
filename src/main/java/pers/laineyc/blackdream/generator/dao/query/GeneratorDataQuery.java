package pers.laineyc.blackdream.generator.dao.query;

import pers.laineyc.blackdream.framework.dao.query.Order;
import pers.laineyc.blackdream.generator.dao.po.GeneratorDataPo;
import pers.laineyc.blackdream.framework.dao.query.Query;
import pers.laineyc.blackdream.framework.dao.query.expression.ExpressionBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成器数据Query
 * @author LaineyC
 */
public class GeneratorDataQuery extends Query<GeneratorDataPo> {

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
     * 所属生成器
     */
    private Long generatorId;

    /**
     * 所属生成器实例
     */
    private Long generatorInstanceId;

    /**
     * 所属生成器数据模型
     */
    private Long dataModelId;

    /**
     * 名称
     */
    private String name;
	
    /**
     * 名称Like
     */
    private String nameLike;

    /**
     * 是否展开
     */
    private Boolean isExpanded;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 父节点
     */
    private Long parentId;

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

	public GeneratorDataQuery() {

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

    public Long getGeneratorId() {
        return generatorId;
    }
    
    public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
        if(this.generatorId != null){
            this.addWhereExpression(ExpressionBuilder.equal("generatorId", this.generatorId));
        }
    }

    public Long getGeneratorInstanceId() {
        return generatorInstanceId;
    }
    
    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
        if(this.generatorInstanceId != null){
            this.addWhereExpression(ExpressionBuilder.equal("generatorInstanceId", this.generatorInstanceId));
        }
    }

    public Long getDataModelId() {
        return dataModelId;
    }
    
    public void setDataModelId(Long dataModelId) {
        this.dataModelId = dataModelId;
        if(this.dataModelId != null){
            this.addWhereExpression(ExpressionBuilder.equal("dataModelId", this.dataModelId));
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

    public Boolean getIsExpanded() {
        return isExpanded;
    }
    
    public void setIsExpanded(Boolean isExpanded) {
        this.isExpanded = isExpanded;
        if(this.isExpanded != null){
            this.addWhereExpression(ExpressionBuilder.equal("isExpanded", this.isExpanded));
        }
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }
    
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
        if(this.displayOrder != null){
            this.addWhereExpression(ExpressionBuilder.equal("displayOrder", this.displayOrder));
        }
    }

    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
        if(this.parentId != null){
            this.addWhereExpression(ExpressionBuilder.equal("parentId", this.parentId));
        }
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

    public void orderByDisplayOrder(Order.Direction orderDirection){
        orderBy("displayOrder", orderDirection);
    }

}
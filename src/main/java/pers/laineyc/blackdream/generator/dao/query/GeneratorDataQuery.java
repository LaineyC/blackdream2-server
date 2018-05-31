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
    private String id;

    /**
     * 主键
     */
    private List<String> idList = new ArrayList<>();

    /**
     * 所属用户
     */
    private String userId;

    /**
     * 所属生成器
     */
    private String generatorId;

    /**
     * 所属生成器实例
     */
    private String generatorInstanceId;

    /**
     * 所属生成器数据模型
     */
    private String dataModelId;

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
    private String parentId;

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
	
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
        if(this.id != null){
            this.addWhereExpression(ExpressionBuilder.equal("id", this.id));
        }
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
        if(this.idList != null && !this.idList.isEmpty()){
            this.addWhereExpression(ExpressionBuilder.in("id", this.idList));
        }
    }

    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
        if(this.userId != null){
            this.addWhereExpression(ExpressionBuilder.equal("userId", this.userId));
        }
    }

    public String getGeneratorId() {
        return generatorId;
    }
    
    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
        if(this.generatorId != null){
            this.addWhereExpression(ExpressionBuilder.equal("generatorId", this.generatorId));
        }
    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }
    
    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
        if(this.generatorInstanceId != null){
            this.addWhereExpression(ExpressionBuilder.equal("generatorInstanceId", this.generatorInstanceId));
        }
    }

    public String getDataModelId() {
        return dataModelId;
    }
    
    public void setDataModelId(String dataModelId) {
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

    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
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
package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.support.FetchLazy;

import java.util.*;

/**
 * 生成器数据Po
 * @author LaineyC
 */
@Document(collection = "GeneratorData")
public class GeneratorDataPo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private String id;

	/**
	 *  所属用户
	 */
    @Indexed
	private String userId;

	/**
	 *  所属生成器
	 */
    @Indexed
	private String generatorId;

	/**
	 *  所属生成器实例
	 */
    @Indexed
	private String generatorInstanceId;

	/**
	 *  所属生成器数据模型
	 */
	private String dataModelId;

	/**
	 *  名称
	 */
	private String name;

	/**
	 *  是否展开
	 */
	private Boolean isExpanded;

	/**
	 *  显示顺序
	 */
	private Integer displayOrder;

	/**
	 *  父节点
	 */
	private String parentId;

	/**
	 *  是否删除
	 */
	private Boolean isDeleted;

	/**
	 *  创建时间
	 */
	private Date createTime;

	/**
	 *  修改时间
	 */
	private Date updateTime;

    /**
     * 属性集
     */
    @FetchLazy
    private Map<String, Object> property = new LinkedHashMap<>();

    /**
     * 记录列表
     */
    @FetchLazy
    private List<Map<String, Object>> recordList = new ArrayList<>();

	public GeneratorDataPo() {

	}

    public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

	public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGeneratorId() {
        return generatorId;
    }

	public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

	public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getDataModelId() {
        return dataModelId;
    }

	public void setDataModelId(String dataModelId) {
        this.dataModelId = dataModelId;
    }

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsExpanded() {
        return isExpanded;
    }

	public void setIsExpanded(Boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

	public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getParentId() {
        return parentId;
    }

	public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

	public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public Map<String, Object> getProperty() {
        return property;
    }

    public void setProperty(Map<String, Object> property) {
        this.property = property;
    }

    public List<Map<String, Object>> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Map<String, Object>> recordList) {
        this.recordList = recordList;
    }
}
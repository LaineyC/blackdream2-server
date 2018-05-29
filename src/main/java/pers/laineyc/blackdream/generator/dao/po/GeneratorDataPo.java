package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.support.LazyLoad;

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
	private Long id;

	/**
	 *  所属用户
	 */
    @Indexed
	private Long userId;

	/**
	 *  所属生成器
	 */
    @Indexed
	private Long generatorId;

	/**
	 *  所属生成器实例
	 */
    @Indexed
	private Long generatorInstanceId;

	/**
	 *  所属生成器数据模型
	 */
	private Long dataModelId;

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
	private Long parentId;

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
    @LazyLoad
    private Map<String, Object> property = new LinkedHashMap<>();

    /**
     * 记录列表
     */
    @LazyLoad
    private List<Map<String, Object>> recordList = new ArrayList<>();

	public GeneratorDataPo() {

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

    public Long getGeneratorId() {
        return generatorId;
    }

	public void setGeneratorId(Long generatorId) {
        this.generatorId = generatorId;
    }

    public Long getGeneratorInstanceId() {
        return generatorInstanceId;
    }

	public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public Long getDataModelId() {
        return dataModelId;
    }

	public void setDataModelId(Long dataModelId) {
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

    public Long getParentId() {
        return parentId;
    }

	public void setParentId(Long parentId) {
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
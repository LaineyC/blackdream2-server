package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.generator.service.domain.DataModelField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型Po
 * @author LaineyC
 */
@Document(collection = "DataModel")
public class DataModelPo extends Po {

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
	 *  名称
	 */
	private String name;

	/**
	 *  编号
	 */
	private String code;

	/**
	 *  图标样式
	 */
	private String iconStyle;

	/**
	 *  显示顺序
	 */
	private Integer displayOrder;

	/**
	 *  描述
	 */
	private String description;

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
     * 属性列表
     */
    private List<DataModelField> propertyList = new ArrayList<>();

    /**
     * 字段列表
     */
    private List<DataModelField> fieldList = new ArrayList<>();

    /**
     * 默认记录列表
     */
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

	public DataModelPo() {

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

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

	public void setCode(String code) {
        this.code = code;
    }

    public String getIconStyle() {
        return iconStyle;
    }

	public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

	public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
        this.description = description;
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

    public List<DataModelField> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<DataModelField> propertyList) {
        this.propertyList = propertyList;
    }

    public List<DataModelField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DataModelField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Map<String, Object>> getDefaultRecordList() {
        return defaultRecordList;
    }

    public void setDefaultRecordList(List<Map<String, Object>> defaultRecordList) {
        this.defaultRecordList = defaultRecordList;
    }
}
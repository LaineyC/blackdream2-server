package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器数据模型
 * @author LaineyC
 */
public class DataModel extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 所属用户
     */
    private User user;

    /**
     * 所属生成器
     */
    private Generator generator;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图标样式
     */
    private String iconStyle;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
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

	public DataModel() {

	}

    public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

	public void setUser(User user) {
        this.user = user;
    }

    public Generator getGenerator() {
        return this.generator;
    }

	public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

	public void setCode(String code) {
        this.code = code;
    }

    public String getIconStyle() {
        return this.iconStyle;
    }

	public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

	public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
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
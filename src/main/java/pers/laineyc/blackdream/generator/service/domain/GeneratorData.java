package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;

import java.util.*;

import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器数据
 * @author LaineyC
 */
public class GeneratorData extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 所属用户
     */
    private User user;

    /**
     * 所属生成器
     */
    private Generator generator;

    /**
     * 所属生成器实例
     */
    private GeneratorInstance generatorInstance;

    /**
     * 所属生成器数据模型
     */
    private DataModel dataModel;

    /**
     * 名称
     */
    private String name;

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
    private GeneratorData parent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

     /**
     * 子节点集合
     */
    private List<GeneratorData> children = new ArrayList<>();

    /**
     * 属性集
     */
    private Map<String, Object> property = new LinkedHashMap<>();

    /**
     * 记录列表
     */
    private List<Map<String, Object>> recordList = new ArrayList<>();

	public GeneratorData() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
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

    public GeneratorInstance getGeneratorInstance() {
        return this.generatorInstance;
    }

	public void setGeneratorInstance(GeneratorInstance generatorInstance) {
        this.generatorInstance = generatorInstance;
    }

    public DataModel getDataModel() {
        return this.dataModel;
    }

	public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsExpanded() {
        return this.isExpanded;
    }

	public void setIsExpanded(Boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

	public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public GeneratorData getParent() {
        return this.parent;
    }

	public void setParent(GeneratorData parent) {
        this.parent = parent;
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

    public List<GeneratorData> getChildren() {
        return children;
    }

    public void setChildren(List<GeneratorData> children) {
        this.children = children;
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
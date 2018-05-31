package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器实例设置
 * @author LaineyC
 */
public class GeneratorInstanceConfig extends Domain {

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
     * 名称
     */
    private String name;

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
     * 是否直接添加默认记录
     */
    private Boolean isAddDefaultRecordList;

    /**
     * 默认记录集合数据
     */
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

	public GeneratorInstanceConfig() {

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

    public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
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

    public Boolean getIsAddDefaultRecordList() {
        return isAddDefaultRecordList;
    }

    public void setIsAddDefaultRecordList(Boolean isAddDefaultRecordList) {
        this.isAddDefaultRecordList = isAddDefaultRecordList;
    }

    public List<Map<String, Object>> getDefaultRecordList() {
        return defaultRecordList;
    }

    public void setDefaultRecordList(List<Map<String, Object>> defaultRecordList) {
        this.defaultRecordList = defaultRecordList;
    }
}
package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.support.FetchLazy;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceDataModelConfig;
import java.util.*;

/**
 * 生成器实例设置Po
 * @author LaineyC
 */
@Document(collection = "GeneratorInstanceConfig")
public class GeneratorInstanceConfigPo extends Po {

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
    @Indexed(unique = true)
	private String generatorInstanceId;

	/**
	 *  名称
	 */
	private String name;

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
     * 根据数据模型的设置
     */
    @FetchLazy
    private Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap = new HashMap<>();

	public GeneratorInstanceConfigPo() {

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

    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
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

    public Map<String, GeneratorInstanceDataModelConfig> getDataModelConfigMap() {
        return dataModelConfigMap;
    }

    public void setDataModelConfigMap(Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap) {
        this.dataModelConfigMap = dataModelConfigMap;
    }
}
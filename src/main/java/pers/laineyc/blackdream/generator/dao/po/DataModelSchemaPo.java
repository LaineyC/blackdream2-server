package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.support.FetchLazy;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchemaRule;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成器数据模型模式Po
 * @author LaineyC
 */
@Document(collection = "DataModelSchema")
public class DataModelSchemaPo extends Po {

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
    @Indexed(unique = true)
	private String generatorId;

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
     * 规则集合
     */
    @FetchLazy
    private List<DataModelSchemaRule> ruleList = new ArrayList<>();

	public DataModelSchemaPo() {

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

    public List<DataModelSchemaRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<DataModelSchemaRule> ruleList) {
        this.ruleList = ruleList;
    }

}
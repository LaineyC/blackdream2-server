package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.dao.support.LazyLoad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Indexed(unique = true)
	private Long generatorInstanceId;

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
     * 是否直接添加默认记录
     */
    @LazyLoad
    private Boolean isAddDefaultRecordList;

    /**
     * 默认记录集合数据
     */
    @LazyLoad
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

	public GeneratorInstanceConfigPo() {

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
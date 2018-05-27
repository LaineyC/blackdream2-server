package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 生成器模板文件Po
 * @author LaineyC
 */
@Document(collection = "TemplateFile")
public class TemplateFilePo extends Po {

    private static final long serialVersionUID = 1L;

	/**
	 *  主键
	 */
    @Id
	private Long id;

	/**
	 *  所属用户
	 */
	private Long userId;

	/**
	 *  所属生成器
	 */
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
	 *  引擎类型：1Velocity；2FreeMarker
	 */
	private Integer engineType;

	/**
	 *  显示分组
	 */
	private String displayGroup;

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
     * 脚本
     */
    private String script;

	public TemplateFilePo() {

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

    public Integer getEngineType() {
        return engineType;
    }

	public void setEngineType(Integer engineType) {
        this.engineType = engineType;
    }

    public String getDisplayGroup() {
        return displayGroup;
    }

	public void setDisplayGroup(String displayGroup) {
        this.displayGroup = displayGroup;
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

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
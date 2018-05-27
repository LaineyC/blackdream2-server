package pers.laineyc.blackdream.generator.dao.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.Date;

/**
 * 生成器指南Po
 * @author LaineyC
 */
@Document(collection = "GeneratorGuide")
public class GeneratorGuidePo extends Po {

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
    @Indexed(unique = true)
	private Long generatorId;

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
     * 内容
     */
    private String content;


    public GeneratorGuidePo() {

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
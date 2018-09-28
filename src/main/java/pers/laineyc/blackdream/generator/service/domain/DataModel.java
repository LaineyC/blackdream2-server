package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pers.laineyc.blackdream.usercenter.service.domain.User;

/**
 * 生成器数据模型
 * @author LaineyC
 */
@ApiModel
public class DataModel extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "所属生成器")
    private Generator generator;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "图标")
    private String iconStyle;

    @ApiModelProperty(value = "显示顺序")
    private Integer displayOrder;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "属性列表")
    private List<DataModelAttribute> propertyList = new ArrayList<>();

    @ApiModelProperty(value = "字段列表")
    private List<DataModelAttribute> fieldList = new ArrayList<>();

	public DataModel() {

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

    public List<DataModelAttribute> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<DataModelAttribute> propertyList) {
        this.propertyList = propertyList;
    }

    public List<DataModelAttribute> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DataModelAttribute> fieldList) {
        this.fieldList = fieldList;
    }

}
package pers.laineyc.blackdream.generator.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 生成器数据模型模式
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaGetWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "所属生成器")
    private Generator generator;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "规则集合")
    private List<DataModelSchemaRule> ruleList = new ArrayList<>();

    public DataModelSchemaGetWebVo() {

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

    public List<DataModelSchemaRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<DataModelSchemaRule> ruleList) {
        this.ruleList = ruleList;
    }

    @ApiModel
    public static class User {

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "名称")
        private String name;

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @ApiModel
    public static class Generator {

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "名称")
        private String name;

        public Long getId() {
            return this.id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @ApiModel
    public static class DataModelSchemaRule extends Domain {

        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "生成器数据模型节点code")
        private String nodeCode;

        @ApiModelProperty(value = "子节点集合")
        private List<String> childCodeList = new ArrayList<>();

        public DataModelSchemaRule() {

        }

        public String getNodeCode() {
            return nodeCode;
        }

        public void setNodeCode(String nodeCode) {
            this.nodeCode = nodeCode;
        }

        public List<String> getChildCodeList() {
            return childCodeList;
        }

        public void setChildCodeList(List<String> childCodeList) {
            this.childCodeList = childCodeList;
        }
    }
}
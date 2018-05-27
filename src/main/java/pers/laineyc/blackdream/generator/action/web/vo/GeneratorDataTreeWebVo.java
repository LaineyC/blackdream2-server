package pers.laineyc.blackdream.generator.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataTreeWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "所属用户")
    private User user;

    @ApiModelProperty(value = "所属生成器")
    private Generator generator;

    @ApiModelProperty(value = "所属生成器实例")
    private GeneratorInstance generatorInstance;

    @ApiModelProperty(value = "所属生成器数据模型")
    private DataModel dataModel;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否展开")
    private Boolean isExpanded;

    @ApiModelProperty(value = "显示顺序")
    private Integer displayOrder;

    @ApiModelProperty(value = "父节点")
    private GeneratorDataTreeWebVo parent;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "下级集合")
    private List<GeneratorDataTreeWebVo> children = new ArrayList<>();

	public GeneratorDataTreeWebVo() {

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

    public GeneratorDataTreeWebVo getParent() {
        return this.parent;
    }

	public void setParent(GeneratorDataTreeWebVo parent) {
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

    public List<GeneratorDataTreeWebVo> getChildren() {
        return children;
    }

    public void setChildren(List<GeneratorDataTreeWebVo> children) {
        this.children = children;
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
    public static class GeneratorInstance {

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
    public static class DataModel {

        @ApiModelProperty(value = "主键")
        private Long id;

        @ApiModelProperty(value = "名称")
        private String name;

        public Long getId() {
            return id;
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

}
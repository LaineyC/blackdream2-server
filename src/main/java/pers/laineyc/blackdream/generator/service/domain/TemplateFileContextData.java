package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.*;

/**
 * 生成器数据
 * @author LaineyC
 */
@ApiModel
public class TemplateFileContextData extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "所属生成器数据模型")
    private DataModel dataModel;

    @ApiModelProperty(value = "父节点")
    private TemplateFileContextData parent;

     @ApiModelProperty(value = "子节点集合")
    private List<TemplateFileContextData> children = new ArrayList<>();

    @ApiModelProperty(value = "属性集")
    private Map<String, Object> properties = new LinkedHashMap<>();

    @ApiModelProperty(value = "记录列表")
    private List<Map<String, Object>> tupleList = new ArrayList<>();

	public TemplateFileContextData() {

	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public TemplateFileContextData getParent() {
        return parent;
    }

    public void setParent(TemplateFileContextData parent) {
        this.parent = parent;
    }

    public List<TemplateFileContextData> getChildren() {
        return children;
    }

    public void setChildren(List<TemplateFileContextData> children) {
        this.children = children;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public List<Map<String, Object>> getTupleList() {
        return tupleList;
    }

    public void setTupleList(List<Map<String, Object>> tupleList) {
        this.tupleList = tupleList;
    }

}
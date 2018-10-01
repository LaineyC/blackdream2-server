package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据创建Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "所属生成器数据模型")
    private String dataModelId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "是否展开")
    private Boolean isExpanded;

    @ApiModelProperty(value = "父节点")
    private String parentId;

    @ApiModelProperty(value = "属性集")
    private Map<String, Object> properties = new LinkedHashMap<>();

    @ApiModelProperty(value = "记录列表")
    private List<Map<String, Object>> tupleList = new ArrayList<>();

    public GeneratorDataCreateWebRequest() {

    }

    public String getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getDataModelId() {
        return this.dataModelId;
    }

    public void setDataModelId(String dataModelId) {
        this.dataModelId = dataModelId;
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

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
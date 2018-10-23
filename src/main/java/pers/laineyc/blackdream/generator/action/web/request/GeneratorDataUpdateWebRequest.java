package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.generator.service.domain.GeneratorDataAttributeControl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据修改Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataUpdateWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "是否展开")
    private Boolean isExpanded;

    @ApiModelProperty(value = "父节点")
    private String parentId;

    @ApiModelProperty(value = "属性集")
    private Map<String, GeneratorDataAttributeControl> properties = new LinkedHashMap<>();

    @ApiModelProperty(value = "记录列表")
    private List<Map<String, GeneratorDataAttributeControl>> tupleList = new ArrayList<>();

    public GeneratorDataUpdateWebRequest() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
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

    public Map<String, GeneratorDataAttributeControl> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, GeneratorDataAttributeControl> properties) {
        this.properties = properties;
    }

    public List<Map<String, GeneratorDataAttributeControl>> getTupleList() {
        return tupleList;
    }

    public void setTupleList(List<Map<String, GeneratorDataAttributeControl>> tupleList) {
        this.tupleList = tupleList;
    }
}
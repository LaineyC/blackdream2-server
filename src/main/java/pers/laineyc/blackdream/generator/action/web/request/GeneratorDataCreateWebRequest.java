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
    private Long generatorInstanceId;

    @ApiModelProperty(value = "所属生成器数据模型")
    private Long dataModelId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "是否展开")
    private Boolean isExpanded;

    @ApiModelProperty(value = "父节点")
    private Long parentId;

    @ApiModelProperty(value = "属性集")
    private Map<String, Object> property = new LinkedHashMap<>();

    @ApiModelProperty(value = "记录列表")
    private List<Map<String, Object>> recordList = new ArrayList<>();

    public GeneratorDataCreateWebRequest() {

    }

    public Long getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public Long getDataModelId() {
        return this.dataModelId;
    }

    public void setDataModelId(Long dataModelId) {
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

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Map<String, Object> getProperty() {
        return property;
    }

    public void setProperty(Map<String, Object> property) {
        this.property = property;
    }

    public List<Map<String, Object>> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Map<String, Object>> recordList) {
        this.recordList = recordList;
    }
}
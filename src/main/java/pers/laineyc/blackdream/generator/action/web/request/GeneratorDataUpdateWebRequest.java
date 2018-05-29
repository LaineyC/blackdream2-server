package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

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
    private Long id;

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

    public GeneratorDataUpdateWebRequest() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
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
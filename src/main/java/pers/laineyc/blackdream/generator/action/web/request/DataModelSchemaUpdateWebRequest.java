package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchemaRuleItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型模式修改Request
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaUpdateWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "规则集合")
    private Map<String, DataModelSchemaRuleItem> ruleItemMap = new HashMap<>();

    public DataModelSchemaUpdateWebRequest() {

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, DataModelSchemaRuleItem> getRuleItemMap() {
        return ruleItemMap;
    }

    public void setRuleItemMap(Map<String, DataModelSchemaRuleItem> ruleItemMap) {
        this.ruleItemMap = ruleItemMap;
    }
}
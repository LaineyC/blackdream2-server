package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型模式保存Request
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaSaveWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器", required = true)
    private String generatorId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "规则集合")
    private Map<String, List<String>> ruleMap = new HashMap<>();

    public DataModelSchemaSaveWebRequest() {

    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
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

    public Map<String, List<String>> getRuleMap() {
        return ruleMap;
    }

    public void setRuleMap(Map<String, List<String>> ruleMap) {
        this.ruleMap = ruleMap;
    }
}
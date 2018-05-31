package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

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
    private List<DataModelSchemaRule> ruleList = new ArrayList<>();

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

    public List<DataModelSchemaRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<DataModelSchemaRule> ruleList) {
        this.ruleList = ruleList;
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
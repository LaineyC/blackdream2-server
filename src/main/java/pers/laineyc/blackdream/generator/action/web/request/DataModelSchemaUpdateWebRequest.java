package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型模式修改Request
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaUpdateWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "规则集合")
    private List<DataModelSchemaRule> ruleList = new ArrayList<>();

    public DataModelSchemaUpdateWebRequest() {

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

    public String getDescription() {
        return this.description;
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
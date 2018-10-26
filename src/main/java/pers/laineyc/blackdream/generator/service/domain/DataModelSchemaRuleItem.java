package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.*;

/**
 * 生成器数据模型模式
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaRuleItem extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "子集合")
    private List<String> children = new ArrayList<>();

	public DataModelSchemaRuleItem() {

	}

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }
}
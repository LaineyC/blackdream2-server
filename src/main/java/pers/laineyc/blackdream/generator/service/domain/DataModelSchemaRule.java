package pers.laineyc.blackdream.generator.service.domain;

import pers.laineyc.blackdream.framework.service.domain.Domain;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型模式
 * @author LaineyC
 */
public class DataModelSchemaRule extends Domain {

    private static final long serialVersionUID = 1L;

    /**
     * 数据模型节点code
     */
    private String nodeCode;

    /**
     *  子节点集合
     */
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
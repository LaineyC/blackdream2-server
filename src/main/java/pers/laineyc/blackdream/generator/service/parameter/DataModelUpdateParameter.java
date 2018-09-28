package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import pers.laineyc.blackdream.generator.service.domain.DataModelAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型修改Parameter
 * @author LaineyC
 */
public class DataModelUpdateParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 图标样式
     */
    private String iconStyle;

    /**
     * 描述
     */
    private String description;

    /**
     * 属性列表
     */
    private List<DataModelAttribute> propertyList = new ArrayList<>();

    /**
     * 字段列表
     */
    private List<DataModelAttribute> fieldList = new ArrayList<>();

    public DataModelUpdateParameter() {

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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIconStyle() {
        return this.iconStyle;
    }

    public void setIconStyle(String iconStyle) {
        this.iconStyle = iconStyle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DataModelAttribute> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<DataModelAttribute> propertyList) {
        this.propertyList = propertyList;
    }

    public List<DataModelAttribute> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<DataModelAttribute> fieldList) {
        this.fieldList = fieldList;
    }

}
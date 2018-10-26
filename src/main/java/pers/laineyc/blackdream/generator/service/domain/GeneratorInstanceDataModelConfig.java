package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器数据模型字段
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceDataModelConfig extends Domain {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "属性列表")
    private List<GeneratorInstanceDataModelAttributeConfig> propertyList = new ArrayList<>();

    @ApiModelProperty(value = "字段列表")
    private List<GeneratorInstanceDataModelAttributeConfig> fieldList = new ArrayList<>();

    @ApiModelProperty(value = "默认记录集合数据")
    private List<Map<String, GeneratorDataAttributeControl>> defaultTupleList = new ArrayList<>();

    public GeneratorInstanceDataModelConfig() {

    }

    public List<GeneratorInstanceDataModelAttributeConfig> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<GeneratorInstanceDataModelAttributeConfig> propertyList) {
        this.propertyList = propertyList;
    }

    public List<GeneratorInstanceDataModelAttributeConfig> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<GeneratorInstanceDataModelAttributeConfig> fieldList) {
        this.fieldList = fieldList;
    }

    public List<Map<String, GeneratorDataAttributeControl>> getDefaultTupleList() {
        return defaultTupleList;
    }

    public void setDefaultTupleList(List<Map<String, GeneratorDataAttributeControl>> defaultTupleList) {
        this.defaultTupleList = defaultTupleList;
    }
}
package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OptionValue
 *
 * @author LaineyC
 */
@ApiModel
public class DataModelAttributeEnumItem {

    @ApiModelProperty(value = "选项")
    private String label;

    @ApiModelProperty(value = "选项值")
    private Object value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

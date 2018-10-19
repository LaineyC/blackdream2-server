package pers.laineyc.blackdream.generator.service.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.service.domain.Domain;
import pers.laineyc.blackdream.usercenter.service.domain.User;

import java.util.*;

/**
 * 生成器数据
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataAttributeControl extends Domain {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据类型：1NONE；2BOOLEAN；3INTEGER；4FLOAT；5STRING；6DATE；7TIME；8DATETIME；15MODEL_REF")
    private Integer dataType;

    @ApiModelProperty(value = "控件值")
    private Object value;

	public GeneratorDataAttributeControl() {

	}

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
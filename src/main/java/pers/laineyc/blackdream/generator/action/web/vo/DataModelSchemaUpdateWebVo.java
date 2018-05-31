package pers.laineyc.blackdream.generator.action.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.response.Vo;
import java.util.Date;

/**
 * 生成器数据模型模式
 * @author LaineyC
 */
@ApiModel
public class DataModelSchemaUpdateWebVo extends Vo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private String id;

	public DataModelSchemaUpdateWebVo() {

	}

    public String getId() {
        return this.id;
    }

	public void setId(String id) {
        this.id = id;
    }

}
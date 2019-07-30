package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器top查询Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorQueryTopWebRequest extends Request {

    @ApiModelProperty(value = "top数量")
    private Integer topNumber;

    public GeneratorQueryTopWebRequest() {

    }

    public Integer getTopNumber() {
        return topNumber;
    }

    public void setTopNumber(Integer topNumber) {
        this.topNumber = topNumber;
    }

}
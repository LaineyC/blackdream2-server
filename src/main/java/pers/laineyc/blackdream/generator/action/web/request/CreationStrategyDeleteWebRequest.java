package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器生成策略删除Request
 * @author LaineyC
 */
@ApiModel
public class CreationStrategyDeleteWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private Long id;

    public CreationStrategyDeleteWebRequest() {

    }
    
    public Long getId() {
        return this.id;
    }

    public void setId (Long id) {
        this.id = id;
    }
    
}
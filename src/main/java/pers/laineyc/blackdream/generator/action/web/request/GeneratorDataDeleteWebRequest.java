package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器数据删除Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorDataDeleteWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    public GeneratorDataDeleteWebRequest() {

    }
    
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }
    
}
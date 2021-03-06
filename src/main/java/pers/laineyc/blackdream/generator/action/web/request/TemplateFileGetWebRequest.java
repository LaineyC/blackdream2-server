package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

/**
 * 生成器模板文件单个查询Request
 * @author LaineyC
 */
@ApiModel
public class TemplateFileGetWebRequest extends Request {

    @ApiModelProperty(value = "主键", required = true)
    private String id;

    public TemplateFileGetWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
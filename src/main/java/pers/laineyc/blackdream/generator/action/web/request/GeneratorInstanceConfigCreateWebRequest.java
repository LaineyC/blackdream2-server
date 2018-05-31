package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置创建Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceConfigCreateWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否直接添加默认记录")
    private Boolean isAddDefaultRecordList;

    @ApiModelProperty(value = "默认记录集合数据")
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public GeneratorInstanceConfigCreateWebRequest() {

    }

    public String getGeneratorInstanceId() {
        return this.generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsAddDefaultRecordList() {
        return isAddDefaultRecordList;
    }

    public void setIsAddDefaultRecordList(Boolean isAddDefaultRecordList) {
        this.isAddDefaultRecordList = isAddDefaultRecordList;
    }

    public List<Map<String, Object>> getDefaultRecordList() {
        return defaultRecordList;
    }

    public void setDefaultRecordList(List<Map<String, Object>> defaultRecordList) {
        this.defaultRecordList = defaultRecordList;
    }
}
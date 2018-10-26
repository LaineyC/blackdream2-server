package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceDataModelConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置保存Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceConfigSaveWebRequest extends Request {

    @ApiModelProperty(value = "所属生成器实例")
    private String generatorInstanceId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "根据数据模型的设置")
    private Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap = new HashMap<>();

    public GeneratorInstanceConfigSaveWebRequest() {

    }

    public String getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(String generatorInstanceId) {
        this.generatorInstanceId = generatorInstanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, GeneratorInstanceDataModelConfig> getDataModelConfigMap() {
        return dataModelConfigMap;
    }

    public void setDataModelConfigMap(Map<String, GeneratorInstanceDataModelConfig> dataModelConfigMap) {
        this.dataModelConfigMap = dataModelConfigMap;
    }
}
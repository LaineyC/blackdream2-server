package pers.laineyc.blackdream.generator.action.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pers.laineyc.blackdream.framework.controller.request.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成器实例生成Request
 * @author LaineyC
 */
@ApiModel
public class GeneratorInstanceMakeTestWebRequest extends Request {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "生成器生成策略主键")
    private String creationStrategyId;

    @ApiModelProperty(value = "包括的生成器数据主键")
    private List<String> generatorDataIdList = new ArrayList<>();

    public GeneratorInstanceMakeTestWebRequest() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationStrategyId() {
        return creationStrategyId;
    }

    public void setCreationStrategyId(String creationStrategyId) {
        this.creationStrategyId = creationStrategyId;
    }

    public List<String> getGeneratorDataIdList() {
        return generatorDataIdList;
    }

    public void setGeneratorDataIdList(List<String> generatorDataIdList) {
        this.generatorDataIdList = generatorDataIdList;
    }
}
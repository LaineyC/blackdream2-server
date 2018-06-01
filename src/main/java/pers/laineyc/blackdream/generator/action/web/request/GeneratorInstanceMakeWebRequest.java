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
public class GeneratorInstanceMakeWebRequest extends Request {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "生成器生成策略主键")
    private String creationStrategyId;

    @ApiModelProperty(value = "不包括的生成器数据模型主键")
    private List<String> excludeDataModelIdList = new ArrayList<>();

    public GeneratorInstanceMakeWebRequest() {

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

    public List<String> getExcludeDataModelIdList() {
        return excludeDataModelIdList;
    }

    public void setExcludeDataModelIdList(List<String> excludeDataModelIdList) {
        this.excludeDataModelIdList = excludeDataModelIdList;
    }
}
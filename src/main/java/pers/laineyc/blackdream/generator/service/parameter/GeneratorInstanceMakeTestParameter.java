package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器实例生成Parameter
 * @author LaineyC
 */
public class GeneratorInstanceMakeTestParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 生成器生成策略主键
     */
    private String creationStrategyId;

    /**
     * 包括的生成器数据主键
     */
    private List<String> generatorDataIdList = new ArrayList<>();

    public GeneratorInstanceMakeTestParameter() {

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
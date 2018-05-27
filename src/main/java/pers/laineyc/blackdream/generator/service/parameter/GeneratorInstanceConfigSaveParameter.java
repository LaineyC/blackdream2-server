package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 生成器实例设置保存Parameter
 * @author LaineyC
 */
public class GeneratorInstanceConfigSaveParameter extends Parameter {

    /**
     * 所属生成器实例
     */
    private Long generatorInstanceId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否直接添加默认记录
     */
    private Boolean isAddDefaultRecordList;

    /**
     * 默认记录集合数据
     */
    private List<Map<String, Object>> defaultRecordList = new ArrayList<>();

    public GeneratorInstanceConfigSaveParameter() {

    }

    public Long getGeneratorInstanceId() {
        return generatorInstanceId;
    }

    public void setGeneratorInstanceId(Long generatorInstanceId) {
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
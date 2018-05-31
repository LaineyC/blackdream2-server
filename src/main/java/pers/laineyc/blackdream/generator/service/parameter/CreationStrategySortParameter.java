package pers.laineyc.blackdream.generator.service.parameter;

import pers.laineyc.blackdream.framework.service.parameter.Parameter;

/**
 * 生成器生成策略排序Parameter
 * @author LaineyC
 */
public class CreationStrategySortParameter extends Parameter {

    /**
     * 主键
     */
    private String id;

    /**
     * 移动前的位置
     */
    private Integer fromIndex;

    /**
     * 移动后的位置
     */
    private Integer toIndex;

    public CreationStrategySortParameter() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(Integer fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Integer getToIndex() {
        return toIndex;
    }

    public void setToIndex(Integer toIndex) {
        this.toIndex = toIndex;
    }
}
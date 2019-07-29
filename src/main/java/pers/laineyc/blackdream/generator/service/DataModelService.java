package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import java.util.List; 

/**
 * 生成器数据模型Service
 * @author LaineyC
 */
public interface DataModelService extends Service{

    /**
     * 生成器数据模型创建
     */
    DataModel create(DataModelCreateParameter parameter);

    /**
     * 生成器数据模型删除
     */
    DataModel delete(DataModelDeleteParameter parameter);
    
    /**
     * 生成器数据模型修改
     */
    DataModel update(DataModelUpdateParameter parameter);
    
    /**
     * 生成器数据模型单个查询
     */
    DataModel get(DataModelGetParameter parameter);

    /**
     * 生成器数据模型多个查询
     */
    List<DataModel> query(DataModelQueryParameter parameter);

    /**
     * 生成器数据模型分页查询
     */
    PageResult<DataModel> search(DataModelSearchParameter parameter);

    /**
     * 生成器数据模型排序
     */
    DataModel sort(DataModelSortParameter parameter);

    /**
     * 生成器数据模型多个查询
     */
    List<DataModel> infoQuery(DataModelInfoQueryParameter parameter);

    /**
     * 创建
     */
    List<DataModel> createFrom(DataModelCreateFromParameter parameter);

}
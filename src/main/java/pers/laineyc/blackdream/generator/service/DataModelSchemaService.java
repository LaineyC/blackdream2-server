package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchema;
import java.util.List; 

/**
 * 生成器数据模型模式Service
 * @author LaineyC
 */
public interface DataModelSchemaService extends Service{

    /**
     * 生成器数据模型模式创建
     */
    DataModelSchema create(DataModelSchemaCreateParameter parameter);

    /**
     * 生成器数据模型模式删除
     */
    DataModelSchema delete(DataModelSchemaDeleteParameter parameter);
    
    /**
     * 生成器数据模型模式修改
     */
    DataModelSchema update(DataModelSchemaUpdateParameter parameter);
    
    /**
     * 生成器数据模型模式单个查询
     */
    DataModelSchema get(DataModelSchemaGetParameter parameter);

    /**
     * 生成器数据模型模式多个查询
     */
    List<DataModelSchema> query(DataModelSchemaQueryParameter parameter);

    /**
     * 生成器数据模型模式分页查询
     */
    PageResult<DataModelSchema> search(DataModelSchemaSearchParameter parameter);

}
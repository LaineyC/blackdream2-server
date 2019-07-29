package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.CreationStrategy;
import java.util.List; 

/**
 * 生成器生成策略Service
 * @author LaineyC
 */
public interface CreationStrategyService extends Service{

    /**
     * 生成器生成策略创建
     */
    CreationStrategy create(CreationStrategyCreateParameter parameter);

    /**
     * 生成器生成策略删除
     */
    CreationStrategy delete(CreationStrategyDeleteParameter parameter);
    
    /**
     * 生成器生成策略修改
     */
    CreationStrategy update(CreationStrategyUpdateParameter parameter);
    
    /**
     * 生成器生成策略单个查询
     */
    CreationStrategy get(CreationStrategyGetParameter parameter);

    /**
     * 生成器生成策略多个查询
     */
    List<CreationStrategy> query(CreationStrategyQueryParameter parameter);

    /**
     * 生成器生成策略分页查询
     */
    PageResult<CreationStrategy> search(CreationStrategySearchParameter parameter);

    /**
     * 生成器生成策略排序
     */
    CreationStrategy sort(CreationStrategySortParameter parameter);

    /**
     * 生成器生成策略多个查询
     */
    List<CreationStrategy> infoQuery(CreationStrategyInfoQueryParameter parameter);

    /**
     * 创建
     */
    List<CreationStrategy> createFrom(CreationStrategyCreateFromParameter parameter);

}
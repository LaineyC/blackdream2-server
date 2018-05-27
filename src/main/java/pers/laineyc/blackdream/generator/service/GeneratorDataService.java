package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorData;
import java.util.List; 

/**
 * 生成器数据Service
 * @author LaineyC
 */
public interface GeneratorDataService extends Service{

    /**
     * 生成器数据创建
     */
    GeneratorData create(GeneratorDataCreateParameter parameter);

    /**
     * 生成器数据删除
     */
    GeneratorData delete(GeneratorDataDeleteParameter parameter);
    
    /**
     * 生成器数据修改
     */
    GeneratorData update(GeneratorDataUpdateParameter parameter);
    
    /**
     * 生成器数据单个查询
     */
    GeneratorData get(GeneratorDataGetParameter parameter);

    /**
     * 生成器数据多个查询
     */
    List<GeneratorData> query(GeneratorDataQueryParameter parameter);

    /**
     * 生成器数据分页查询
     */
    PageResult<GeneratorData> search(GeneratorDataSearchParameter parameter);

    /**
     * 生成器数据树形查询
     */
    List<GeneratorData> tree(GeneratorDataTreeParameter parameter);
    
    /**
     * 生成器数据排序
     */
    GeneratorData sort(GeneratorDataSortParameter parameter);
    
}
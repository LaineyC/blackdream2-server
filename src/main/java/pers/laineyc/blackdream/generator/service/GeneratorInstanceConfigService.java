package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import java.util.List; 

/**
 * 生成器实例设置Service
 * @author LaineyC
 */
public interface GeneratorInstanceConfigService extends Service{

    /**
     * 生成器实例设置创建
     */
    GeneratorInstanceConfig create(GeneratorInstanceConfigCreateParameter parameter);

    /**
     * 生成器实例设置删除
     */
    GeneratorInstanceConfig delete(GeneratorInstanceConfigDeleteParameter parameter);
    
    /**
     * 生成器实例设置修改
     */
    GeneratorInstanceConfig update(GeneratorInstanceConfigUpdateParameter parameter);
    
    /**
     * 生成器实例设置单个查询
     */
    GeneratorInstanceConfig get(GeneratorInstanceConfigGetParameter parameter);

    /**
     * 生成器实例设置多个查询
     */
    List<GeneratorInstanceConfig> query(GeneratorInstanceConfigQueryParameter parameter);

    /**
     * 生成器实例设置分页查询
     */
    PageResult<GeneratorInstanceConfig> search(GeneratorInstanceConfigSearchParameter parameter);

}
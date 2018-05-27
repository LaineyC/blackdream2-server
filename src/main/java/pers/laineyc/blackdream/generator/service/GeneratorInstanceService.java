package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceInfoSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceMakeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceVersionSyncParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import java.util.List; 

/**
 * 生成器实例Service
 * @author LaineyC
 */
public interface GeneratorInstanceService extends Service{

    /**
     * 生成器实例创建
     */
    GeneratorInstance create(GeneratorInstanceCreateParameter parameter);

    /**
     * 生成器实例删除
     */
    GeneratorInstance delete(GeneratorInstanceDeleteParameter parameter);
    
    /**
     * 生成器实例修改
     */
    GeneratorInstance update(GeneratorInstanceUpdateParameter parameter);
    
    /**
     * 生成器实例单个查询
     */
    GeneratorInstance get(GeneratorInstanceGetParameter parameter);

    /**
     * 生成器实例多个查询
     */
    List<GeneratorInstance> query(GeneratorInstanceQueryParameter parameter);

    /**
     * 生成器实例分页查询
     */
    PageResult<GeneratorInstance> search(GeneratorInstanceSearchParameter parameter);

    /**
     * 生成器实例分页查询
     */
    PageResult<GeneratorInstance> infoSearch(GeneratorInstanceInfoSearchParameter parameter);
    
    /**
     * 生成器实例生成
     */
    GeneratorInstance make(GeneratorInstanceMakeParameter parameter);
    
    /**
     * 生成器实例版本同步
     */
    GeneratorInstance versionSync(GeneratorInstanceVersionSyncParameter parameter);
    
}
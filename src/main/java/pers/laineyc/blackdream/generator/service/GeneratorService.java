package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorExportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorImportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInfoSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorReleaseParameter;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import java.util.List; 

/**
 * 生成器Service
 * @author LaineyC
 */
public interface GeneratorService extends Service{

    /**
     * 生成器创建
     */
    Generator create(GeneratorCreateParameter parameter);

    /**
     * 生成器删除
     */
    Generator delete(GeneratorDeleteParameter parameter);
    
    /**
     * 生成器修改
     */
    Generator update(GeneratorUpdateParameter parameter);
    
    /**
     * 生成器单个查询
     */
    Generator get(GeneratorGetParameter parameter);

    /**
     * 生成器多个查询
     */
    List<Generator> query(GeneratorQueryParameter parameter);

    /**
     * 生成器分页查询
     */
    PageResult<Generator> search(GeneratorSearchParameter parameter);

    /**
     * 生成器导出
     */
    Generator export(GeneratorExportParameter parameter);
    
    /**
     * 生成器导入
     */
    Generator import_(GeneratorImportParameter parameter);
    
    /**
     * 生成器分页查询
     */
    PageResult<Generator> infoSearch(GeneratorInfoSearchParameter parameter);
    
    /**
     * 生成器发布
     */
    Generator release(GeneratorReleaseParameter parameter);
    
}
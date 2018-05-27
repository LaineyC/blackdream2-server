package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorGuide;
import java.util.List; 

/**
 * 生成器指南Service
 * @author LaineyC
 */
public interface GeneratorGuideService extends Service{

    /**
     * 生成器指南创建
     */
    GeneratorGuide create(GeneratorGuideCreateParameter parameter);

    /**
     * 生成器指南删除
     */
    GeneratorGuide delete(GeneratorGuideDeleteParameter parameter);
    
    /**
     * 生成器指南修改
     */
    GeneratorGuide update(GeneratorGuideUpdateParameter parameter);
    
    /**
     * 生成器指南单个查询
     */
    GeneratorGuide get(GeneratorGuideGetParameter parameter);

    /**
     * 生成器指南多个查询
     */
    List<GeneratorGuide> query(GeneratorGuideQueryParameter parameter);

    /**
     * 生成器指南分页查询
     */
    PageResult<GeneratorGuide> search(GeneratorGuideSearchParameter parameter);

}
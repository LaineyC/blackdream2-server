package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.configuration.tool.PathTool;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.constant.TemplateEngineTypeEnum;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorUpdateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorExportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorImportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInfoSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorReleaseParameter;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import java.io.File;
import java.util.Date;

/**
 * 生成器ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorServiceTool{

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PathTool pathTool;

    public GeneratorServiceTool() {

	}

    public String getGeneratorPath(Long generatorId){
        return pathTool.getRootPath() + File.separator + SystemConstant.GENERATOR_PATH_NAME + pathTool.splitIdAsPath(generatorId) + generatorId.toString();
    }

    /**
     * 生成器创建Validate
     */
    public void createValidate(GeneratorCreateParameter parameter) {
        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        Integer engineType = parameter.getEngineType();
        if(engineType == null){
            throw new BusinessException("缺少引擎类型");
        }
        if(!TemplateEngineTypeEnum.hasCode(engineType)){
            throw new BusinessException("引擎类型值不合法");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }

    /**
     * 生成器删除Validate
     */
    public void deleteValidate(GeneratorDeleteParameter parameter) {
        Long id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器修改Validate
     */
    public void updateValidate(GeneratorUpdateParameter parameter) {
        Long id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        Integer engineType = parameter.getEngineType();
        if(engineType == null){
            throw new BusinessException("缺少引擎类型");
        }
        if(!TemplateEngineTypeEnum.hasCode(engineType)){
            throw new BusinessException("引擎类型值不合法");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }
    
    /**
     * 生成器单个查询Validate
     */
    public void getValidate(GeneratorGetParameter parameter) {
        Long id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器多个查询Validate
     */
    public void queryValidate(GeneratorQueryParameter parameter) {

    }

    /**
     * 生成器分页查询Validate
     */
    public void searchValidate(GeneratorSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }

    /**
     * 生成器导出Validate
     */
    public void exportValidate(GeneratorExportParameter parameter) {
       
    }
    
    /**
     * 生成器导入Validate
     */
    public void importValidate(GeneratorImportParameter parameter) {
       
    }
    
    /**
     * 生成器分页查询Validate
     */
    public void infoSearchValidate(GeneratorInfoSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }
    
    /**
     * 生成器发布Validate
     */
    public void releaseValidate(GeneratorReleaseParameter parameter) {
        Long id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
}
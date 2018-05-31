package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.constant.GeneratorGuideDocTypeEnum;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.service.domain.GeneratorGuide;
import pers.laineyc.blackdream.generator.dao.po.GeneratorGuidePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorGuideQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorGuideDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;

import java.io.File;
import java.util.Date;

/**
 * 生成器指南ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorGuideServiceTool{

    @Autowired
    private GeneratorGuideDao generatorGuideDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorServiceTool generatorServiceTool;

    public GeneratorGuideServiceTool() {

	}

    public String getContentPath(String generatorId, String id){
        return generatorServiceTool.getGeneratorPath(generatorId) + File.separator + SystemConstant.GENERATOR_GUIDE_PATH_NAME + File.separator + id + ".data";
    }

    /**
     * 生成器指南创建Validate
     */
    public void createValidate(GeneratorGuideCreateParameter parameter) {
        String generatorId = parameter.getGeneratorId();
        if(generatorId == null){
            throw new BusinessException("缺少所属生成器参数");
        }
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null){
            throw new BusinessException("所属生成器不存在");
        }

        String name = parameter.getName();
        if(StringUtils.hasText(name)){
            if(name.length() > 255){
                throw new BusinessException("名称长度不能大于255");
            }
        }

        Integer docType = parameter.getDocType();
        if(docType == null){
            throw new BusinessException("缺少文档类型");
        }
        if(GeneratorGuideDocTypeEnum.hasCode(docType)){
            throw new BusinessException("文档类型值不合法");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

    }

    /**
     * 生成器指南删除Validate
     */
    public void deleteValidate(GeneratorGuideDeleteParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器指南修改Validate
     */
    public void updateValidate(GeneratorGuideUpdateParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }

        String name = parameter.getName();
        if(StringUtils.hasText(name)){
            if(name.length() > 255){
                throw new BusinessException("名称长度不能大于255");
            }
        }

        Integer docType = parameter.getDocType();
        if(docType == null){
            throw new BusinessException("缺少文档类型");
        }
        if(GeneratorGuideDocTypeEnum.hasCode(docType)){
            throw new BusinessException("文档类型值不合法");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

    }
    
    /**
     * 生成器指南单个查询Validate
     */
    public void getValidate(GeneratorGuideGetParameter parameter) {
        String id = parameter.getId();
        String generatorId = parameter.getGeneratorId();
        if(id == null && generatorId == null) {
            throw new BusinessException("主键参数");
        }
    }

    /**
     * 生成器指南多个查询Validate
     */
    public void queryValidate(GeneratorGuideQueryParameter parameter) {

    }

    /**
     * 生成器指南分页查询Validate
     */
    public void searchValidate(GeneratorGuideSearchParameter parameter) {
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
     * 生成器指南保存Validate
     */
    public void saveValidate(GeneratorGuideSaveParameter parameter) {
        String generatorId = parameter.getGeneratorId();
        if(generatorId == null) {
            throw new BusinessException("缺少所属生成器");
        }

        String name = parameter.getName();
        if(StringUtils.hasText(name)){
            if(name.length() > 255){
                throw new BusinessException("名称长度不能大于255");
            }
        }

        Integer docType = parameter.getDocType();
        if(docType == null){
            throw new BusinessException("缺少文档类型");
        }
        if(GeneratorGuideDocTypeEnum.hasCode(docType)){
            throw new BusinessException("文档类型值不合法");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

    }

}
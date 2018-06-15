package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstanceConfigPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceConfigQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceConfigDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstancePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import java.io.File;
import java.util.Date;

/**
 * 生成器实例设置ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorInstanceConfigServiceTool{

    @Autowired
    private GeneratorInstanceConfigDao generatorInstanceConfigDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private GeneratorInstanceServiceTool generatorInstanceServiceTool;

    public GeneratorInstanceConfigServiceTool() {

	}

    public String getBodyPath(String generatorInstanceId, String id){
        return generatorInstanceServiceTool.getGeneratorInstancePath(generatorInstanceId) + File.separator + SystemConstant.GENERATOR_INSTANCE_CONFIG_PATH_NAME + File.separator + id + ".data";
    }

    /**
     * 生成器实例设置创建Validate
     */
    public void createValidate(GeneratorInstanceConfigCreateParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null){
            throw new BusinessException("缺少所属生成器实例");
        }
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted()){
            throw new BusinessException("所属生成器实例不存在");
        }

        String name = parameter.getName();
        if(StringUtils.hasText(name)){
            if(name.length() > 255){
                throw new BusinessException("名称长度不能大于255");
            }
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }

    /**
     * 生成器实例设置删除Validate
     */
    public void deleteValidate(GeneratorInstanceConfigDeleteParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器实例设置修改Validate
     */
    public void updateValidate(GeneratorInstanceConfigUpdateParameter parameter) {
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

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }
    
    /**
     * 生成器实例设置单个查询Validate
     */
    public void getValidate(GeneratorInstanceConfigGetParameter parameter) {
        String id = parameter.getId();
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(id == null && generatorInstanceId == null) {
            throw new BusinessException("主键参数");
        }
    }

    /**
     * 生成器实例设置多个查询Validate
     */
    public void queryValidate(GeneratorInstanceConfigQueryParameter parameter) {

    }

    /**
     * 生成器实例设置分页查询Validate
     */
    public void searchValidate(GeneratorInstanceConfigSearchParameter parameter) {
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
    public void saveValidate(GeneratorInstanceConfigSaveParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null) {
            throw new BusinessException("缺少所属生成器实例");
        }

        String name = parameter.getName();
        if(StringUtils.hasText(name)){
            if(name.length() > 255){
                throw new BusinessException("名称长度不能大于255");
            }
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

    }

}
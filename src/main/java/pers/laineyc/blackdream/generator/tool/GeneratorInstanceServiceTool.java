package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.configuration.tool.PathTool;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.io.File;

/**
 * 生成器实例ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorInstanceServiceTool{

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private PathTool pathTool;

    public GeneratorInstanceServiceTool() {

	}

    public String getGeneratorInstancePath(String generatorInstanceId){
        return pathTool.getRootPath() + File.separator + SystemConstant.GENERATOR_PATH_NAME + pathTool.splitIdAsPath(generatorInstanceId) + generatorInstanceId.toString();
    }

    public String getOutputRootPath(){
        return pathTool.getRootPath() + File.separator + SystemConstant.TEMPORARY_PATH_NAME;
    }

    /**
     * 生成器实例创建Validate
     */
    public void createValidate(GeneratorInstanceCreateParameter parameter) {
        String generatorId = parameter.getGeneratorId();
        if(generatorId == null){
            throw new BusinessException("缺少所属生成器");
        }
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }

    /**
     * 生成器实例删除Validate
     */
    public void deleteValidate(GeneratorInstanceDeleteParameter parameter) {
        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器实例修改Validate
     */
    public void updateValidate(GeneratorInstanceUpdateParameter parameter) {
        String id = parameter.getId();
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

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }
    }
    
    /**
     * 生成器实例单个查询Validate
     */
    public void getValidate(GeneratorInstanceGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器实例多个查询Validate
     */
    public void queryValidate(GeneratorInstanceQueryParameter parameter) {

    }

    /**
     * 生成器实例分页查询Validate
     */
    public void searchValidate(GeneratorInstanceSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            parameter.setName(null);
        }
    }

    /**
     * 生成器实例分页查询Validate
     */
    public void infoSearchValidate(GeneratorInstanceInfoSearchParameter parameter) {
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
     * 生成器实例生成Validate
     */
    public void makeValidate(GeneratorInstanceMakeParameter parameter) {
       
    }

    /**
     * 生成器实例生成测试Validate
     */
    public void makeTestValidate(GeneratorInstanceMakeTestParameter parameter) {

    }


    /**
     * 生成器实例版本同步Validate
     */
    public void versionSyncValidate(GeneratorInstanceVersionSyncParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }
    
}
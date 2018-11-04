package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.constant.TemplateEngineTypeEnum;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.dao.TemplateFileDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;

import java.io.File;
import java.util.List;

/**
 * 生成器模板文件ServiceTool
 * @author LaineyC
 */
@Component
public class TemplateFileServiceTool{

    @Autowired
    private TemplateFileDao templateFileDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorServiceTool generatorServiceTool;

    public TemplateFileServiceTool() {

	}
/*
    public String getScriptPath(String generatorId, String code){
        return generatorServiceTool.getGeneratorPath(generatorId) + File.separator + SystemConstant.TEMPLATE_FILE_PATH_NAME + File.separator + code;
    }
*/
    public String getTemplatePath(String generatorId, String code, Integer engineType){
        TemplateEngineTypeEnum templateEngineTypeEnum = TemplateEngineTypeEnum.value(engineType);
        return generatorServiceTool.getGeneratorPath(generatorId) + File.separator + SystemConstant.TEMPLATE_FILE_PATH_NAME + File.separator + code + "." + templateEngineTypeEnum.getSuffix();
    }

    public String getTemplateRootPath(String generatorId){
        return generatorServiceTool.getGeneratorPath(generatorId) + File.separator + SystemConstant.TEMPLATE_FILE_PATH_NAME;
    }

    /**
     * 生成器模板文件创建Validate
     */
    public void createValidate(TemplateFileCreateParameter parameter) {
        String generatorId = parameter.getGeneratorId();
        if(generatorId == null){
            throw new BusinessException("缺少所属生成器参数");
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

        String code = parameter.getCode();
        if(code != null){
            if(code.length() > 255){
                throw new BusinessException("编号长度不能大于255");
            }
        }

        Integer engineType = parameter.getEngineType();
        if(engineType == null){
            throw new BusinessException("缺少引擎类型");
        }
        if(!TemplateEngineTypeEnum.hasCode(engineType)){
            throw new BusinessException("引擎类型值不合法");
        }

        String displayGroup = parameter.getDisplayGroup();
        if(StringUtils.hasText(displayGroup)){
            if(displayGroup.length() > 255){
                throw new BusinessException("显示分组不能大于255");
            }
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

        String script = parameter.getScript();
        if(!StringUtils.hasText(script)){
            throw new BusinessException("缺少脚本");
        }
/*
        if(script.length() > 255){
            throw new BusinessException("脚本长度不能大于255");
        }
*/
    }

    /**
     * 生成器模板文件删除Validate
     */
    public void deleteValidate(TemplateFileDeleteParameter parameter) {
        String id = parameter.getId();
        List<String> idList = parameter.getIdList();
        if(id == null && idList.isEmpty()){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器模板文件修改Validate
     */
    public void updateValidate(TemplateFileUpdateParameter parameter) {
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

        String code = parameter.getCode();
        if(StringUtils.hasText(code)){
            if(code.length() > 255){
                throw new BusinessException("编号长度不能大于255");
            }
        }

        Integer engineType = parameter.getEngineType();
        if(engineType == null){
            throw new BusinessException("缺少引擎类型");
        }
        if(!TemplateEngineTypeEnum.hasCode(engineType)){
            throw new BusinessException("引擎类型值不合法");
        }

        String displayGroup = parameter.getDisplayGroup();
        if(StringUtils.hasText(displayGroup)){
            if(displayGroup.length() > 255){
                throw new BusinessException("显示分组不能大于255");
            }
        }

        String description = parameter.getDescription();
        if(StringUtils.hasText(description)){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }

        String script = parameter.getScript();
        if(!StringUtils.hasText(script)){
            throw new BusinessException("缺少脚本");
        }
/*
        if(script.length() > 255){
            throw new BusinessException("脚本长度不能大于255");
        }
*/
    }
    
    /**
     * 生成器模板文件单个查询Validate
     */
    public void getValidate(TemplateFileGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器模板文件多个查询Validate
     */
    public void queryValidate(TemplateFileQueryParameter parameter) {

    }

    /**
     * 生成器模板文件分页查询Validate
     */
    public void searchValidate(TemplateFileSearchParameter parameter) {
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
     * 生成器模板文件排序Validate
     */
    public void sortValidate(TemplateFileSortParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }

        Integer fromIndex = parameter.getFromIndex();
        if(fromIndex == null) {
            throw new BusinessException("缺少移动前的位置");
        }

        Integer toIndex = parameter.getToIndex();
        if(toIndex == null) {
            throw new BusinessException("缺少移动后的位置");
        }
    }

    /**
     * 生成器模板文件多个查询Validate
     */
    public void infoQueryValidate(TemplateFileInfoQueryParameter parameter) {

    }

    /**
     * 构建资源到OS文件系统Validate
     */
    public void buildResourceValidate(TemplateFileBuildResourceParameter parameter) {
        String generatorId = parameter.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo == null){
                throw new BusinessException("所属生成器不存在");
            }
        }
    }

}
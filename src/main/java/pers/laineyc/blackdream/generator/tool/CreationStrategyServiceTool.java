package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.constant.CreationStrategyLanguageEnum;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.dao.CreationStrategyDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.io.File;
import java.util.List;

/**
 * 生成器生成策略ServiceTool
 * @author LaineyC
 */
@Component
public class CreationStrategyServiceTool{

    @Autowired
    private CreationStrategyDao creationStrategyDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorServiceTool generatorServiceTool;

    public CreationStrategyServiceTool() {

	}

    public String getScriptPath(String generatorId, String id){
        return generatorServiceTool.getGeneratorPath(generatorId) + File.separator + SystemConstant.CREATION_STRATEGY_PATH_NAME + File.separator + id + ".data";
    }

    /**
     * 生成器生成策略创建Validate
     */
    public void createValidate(CreationStrategyCreateParameter parameter) {
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

        Integer scriptLanguage = parameter.getScriptLanguage();
        if(scriptLanguage == null){
            throw new BusinessException("缺少脚本类型参数");
        }
        if(!CreationStrategyLanguageEnum.hasCode(scriptLanguage)){
            throw new BusinessException("脚本类型参数值不合法");
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
     * 生成器生成策略删除Validate
     */
    public void deleteValidate(CreationStrategyDeleteParameter parameter) {
        String id = parameter.getId();
        List<String> idList = parameter.getIdList();
        if(id == null && idList.isEmpty()){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器生成策略修改Validate
     */
    public void updateValidate(CreationStrategyUpdateParameter parameter) {
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

        Integer scriptLanguage = parameter.getScriptLanguage();
        if(scriptLanguage == null){
            throw new BusinessException("缺少脚本类型参数");
        }
        if(!CreationStrategyLanguageEnum.hasCode(scriptLanguage)){
            throw new BusinessException("脚本类型参数值不合法");
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
     * 生成器生成策略单个查询Validate
     */
    public void getValidate(CreationStrategyGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器生成策略多个查询Validate
     */
    public void queryValidate(CreationStrategyQueryParameter parameter) {

    }

    /**
     * 生成器生成策略分页查询Validate
     */
    public void searchValidate(CreationStrategySearchParameter parameter) {
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
     * 生成器生成策略排序Validate
     */
    public void sortValidate(CreationStrategySortParameter parameter) {
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
     * 生成器生成策略分多个询Validate
     */
    public void infoQueryValidate(CreationStrategyInfoQueryParameter parameter) {

    }
    
}
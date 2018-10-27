package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.dao.po.GeneratorDataPo;
import pers.laineyc.blackdream.generator.dao.GeneratorDataDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;
import pers.laineyc.blackdream.generator.dao.DataModelDao;
import java.io.File;
import java.util.List;

/**
 * 生成器数据ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorDataServiceTool{

    @Autowired
    private GeneratorDataDao generatorDataDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private DataModelDao dataModelDao;

    @Autowired
    private GeneratorInstanceServiceTool generatorInstanceServiceTool;

    public GeneratorDataServiceTool() {

    }

    public String getBodyPath(String generatorInstanceId, String id){
        return generatorInstanceServiceTool.getGeneratorInstancePath(generatorInstanceId) + File.separator + SystemConstant.GENERATOR_INSTANCE_CONFIG_PATH_NAME + File.separator + id + ".data";
    }

    /**
     * 生成器数据创建Validate
     */
    public void createValidate(GeneratorDataCreateParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null){
            throw new BusinessException("缺少所属生成器实例");
        }

        String dataModelId = parameter.getDataModelId();
        if(dataModelId == null){
            throw new BusinessException("缺少所属生成器数据模型");
        }
        DataModelPo dataModelPo = dataModelDao.selectById(dataModelId);
        if(dataModelPo == null || dataModelPo.getIsDeleted()){
            throw new BusinessException("所属生成器数据模型不存在");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        String parentId = parameter.getParentId();
        if(parentId != null){
            GeneratorDataPo parentPo = generatorDataDao.selectById(parentId);
            if(parentPo == null){
                throw new BusinessException("父节点不存在");
            }
        }
    }

    /**
     * 生成器数据删除Validate
     */
    public void deleteValidate(GeneratorDataDeleteParameter parameter) {
        String id = parameter.getId();
        List<String> idList = parameter.getIdList();
        if(id == null && idList.isEmpty()){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器数据修改Validate
     */
    public void updateValidate(GeneratorDataUpdateParameter parameter) {
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

        Boolean isExpanded = parameter.getIsExpanded();
        if(isExpanded == null){
            parameter.setIsExpanded(false);
        }

        String parentId = parameter.getParentId();
        if(parentId != null){
            GeneratorDataPo parentPo = generatorDataDao.selectById(parentId);
            if(parentPo == null || parentPo.getIsDeleted()){
                throw new BusinessException("父节点不存在");
            }
        }
    }
    
    /**
     * 生成器数据单个查询Validate
     */
    public void getValidate(GeneratorDataGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器数据多个查询Validate
     */
    public void queryValidate(GeneratorDataQueryParameter parameter) {

    }

    /**
     * 生成器数据分页查询Validate
     */
    public void searchValidate(GeneratorDataSearchParameter parameter) {
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
     * 生成器数据树形查询Validate
     */
    public void treeValidate(GeneratorDataTreeParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null) {
            throw new BusinessException("缺少所属生成器实例");
        }
    }
    
    /**
     * 生成器数据排序Validate
     */
    public void sortValidate(GeneratorDataSortParameter parameter) {
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
    
}
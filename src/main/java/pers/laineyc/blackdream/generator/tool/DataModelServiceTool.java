package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;
import pers.laineyc.blackdream.generator.dao.query.DataModelQuery;
import pers.laineyc.blackdream.generator.dao.DataModelDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.util.Date; 

/**
 * 生成器数据模型ServiceTool
 * @author LaineyC
 */
@Component
public class DataModelServiceTool{

    @Autowired
    private DataModelDao dataModelDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    public DataModelServiceTool() {

	}

    /**
     * 生成器数据模型创建Validate
     */
    public void createValidate(DataModelCreateParameter parameter) {

        Long generatorId = parameter.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo == null){
                throw new BusinessException("所属生成器不存在");
            }
        }

        String name = parameter.getName();
        if(name == null){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        String code = parameter.getCode();
        if(code == null){
            parameter.setCode("code");
        }
        else{
            if(code.length() > 255){
                throw new BusinessException("编号长度不能大于255");
            }
        }

        String iconStyle = parameter.getIconStyle();
        if(iconStyle == null){
            throw new BusinessException("缺少图标样式");
        }
        if(iconStyle.length() > 255){
            throw new BusinessException("图标样式长度不能大于255");
        }


        String description = parameter.getDescription();
        if(description != null){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }




    }

    /**
     * 生成器数据模型删除Validate
     */
    public void deleteValidate(DataModelDeleteParameter parameter) {
        Long id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器数据模型修改Validate
     */
    public void updateValidate(DataModelUpdateParameter parameter) {
        Long id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }
        


        String name = parameter.getName();
        if(name == null){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        String code = parameter.getCode();
        if(code == null){
            parameter.setCode("code");
        }
        else{
            if(code.length() > 255){
                throw new BusinessException("编号长度不能大于255");
            }
        }

        String iconStyle = parameter.getIconStyle();
        if(iconStyle == null){
            throw new BusinessException("缺少图标样式");
        }
        if(iconStyle.length() > 255){
            throw new BusinessException("图标样式长度不能大于255");
        }


        String description = parameter.getDescription();
        if(description != null){
            if(description.length() > 255){
                throw new BusinessException("描述长度不能大于255");
            }
        }




    }
    
    /**
     * 生成器数据模型单个查询Validate
     */
    public void getValidate(DataModelGetParameter parameter) {
        Long id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器数据模型多个查询Validate
     */
    public void queryValidate(DataModelQueryParameter parameter) {

    }

    /**
     * 生成器数据模型分页查询Validate
     */
    public void searchValidate(DataModelSearchParameter parameter) {
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
     * 生成器数据模型排序Validate
     */
    public void sortValidate(DataModelSortParameter parameter) {
       
    }

    /**
     * 生成器数据模型分页查询Validate
     */
    public void infoSearchValidate(DataModelInfoSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }
    
}
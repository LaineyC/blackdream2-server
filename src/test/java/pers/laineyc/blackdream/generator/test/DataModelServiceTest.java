package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.DataModelService;
import pers.laineyc.blackdream.generator.service.parameter.DataModelCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.DataModelGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSortParameter;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器数据模型ServiceTest
 * @author LaineyC
 */
public class DataModelServiceTest extends BaseServiceTest {

    @Autowired
    private DataModelService dataModelService;
    
    public DataModelServiceTest(){

    }

    /**
     * 生成器数据模型创建Test
     */
    @Test
    public void create() {
        DataModelCreateParameter parameter = new DataModelCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId(0L);
        parameter.setName("");
        parameter.setCode("");
        parameter.setIconStyle("");
        parameter.setDescription("");
        DataModel dataModel = dataModelService.create(parameter);
        Assert.assertNotNull(dataModel);
    }
    
    /**
     * 生成器数据模型删除Test
     */
    @Test
    public void delete() {
        DataModelDeleteParameter parameter = new DataModelDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        DataModel dataModel = dataModelService.delete(parameter);
        Assert.assertNotNull(dataModel);
    }

    /**
     * 生成器数据模型修改Test
     */
    @Test
    public void update() {
        DataModelUpdateParameter parameter = new DataModelUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setName("");
        parameter.setCode("");
        parameter.setIconStyle("");
        parameter.setDescription("");
        DataModel dataModel = dataModelService.update(parameter);
        Assert.assertNotNull(dataModel);
    }
    
    /**
     * 生成器数据模型单个查询Test
     */
    @Test
    public void get(){
        DataModelGetParameter parameter = new DataModelGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        DataModel dataModel = dataModelService.get(parameter);
        Assert.assertNotNull(dataModel);
    }

    /**
     * 生成器数据模型多个查询Test
     */
    @Test
    public void query() {
        DataModelQueryParameter parameter = new DataModelQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setName("");
        parameter.setCode("");
        parameter.setIconStyle("");
        List<DataModel> list = dataModelService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器数据模型分页查询Test
     */
    @Test
    public void search() {
        DataModelSearchParameter parameter = new DataModelSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setName("");
        parameter.setCode("");
        parameter.setIconStyle("");
        PageResult<DataModel> pageResult = dataModelService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器数据模型排序Test
     */
    @Test
    public void sort() {
        DataModelSortParameter parameter = new DataModelSortParameter();
        parameter.setAuth(getAuth());
        DataModel dataModel = dataModelService.sort(parameter);
        Assert.assertNotNull(dataModel);
    }

}
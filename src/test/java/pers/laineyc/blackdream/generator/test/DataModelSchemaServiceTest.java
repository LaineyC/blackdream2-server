package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.DataModelSchemaService;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.DataModelSchemaSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchema;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器数据模型模式ServiceTest
 * @author LaineyC
 */
public class DataModelSchemaServiceTest extends BaseServiceTest {

    @Autowired
    private DataModelSchemaService dataModelSchemaService;
    
    public DataModelSchemaServiceTest(){

    }

    /**
     * 生成器数据模型模式创建Test
     */
    @Test
    public void create() {
        DataModelSchemaCreateParameter parameter = new DataModelSchemaCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId(0L);
        parameter.setName("");
        parameter.setDescription("");
        DataModelSchema dataModelSchema = dataModelSchemaService.create(parameter);
        Assert.assertNotNull(dataModelSchema);
    }
    
    /**
     * 生成器数据模型模式删除Test
     */
    @Test
    public void delete() {
        DataModelSchemaDeleteParameter parameter = new DataModelSchemaDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        DataModelSchema dataModelSchema = dataModelSchemaService.delete(parameter);
        Assert.assertNotNull(dataModelSchema);
    }

    /**
     * 生成器数据模型模式修改Test
     */
    @Test
    public void update() {
        DataModelSchemaUpdateParameter parameter = new DataModelSchemaUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setName("");
        parameter.setDescription("");
        DataModelSchema dataModelSchema = dataModelSchemaService.update(parameter);
        Assert.assertNotNull(dataModelSchema);
    }
    
    /**
     * 生成器数据模型模式单个查询Test
     */
    @Test
    public void get(){
        DataModelSchemaGetParameter parameter = new DataModelSchemaGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        DataModelSchema dataModelSchema = dataModelSchemaService.get(parameter);
        Assert.assertNotNull(dataModelSchema);
    }

    /**
     * 生成器数据模型模式多个查询Test
     */
    @Test
    public void query() {
        DataModelSchemaQueryParameter parameter = new DataModelSchemaQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setName("");
        List<DataModelSchema> list = dataModelSchemaService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器数据模型模式分页查询Test
     */
    @Test
    public void search() {
        DataModelSchemaSearchParameter parameter = new DataModelSchemaSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setName("");
        PageResult<DataModelSchema> pageResult = dataModelSchemaService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

}
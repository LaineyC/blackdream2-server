package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceService;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceMakeResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceInfoSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceMakeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceVersionSyncParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器实例ServiceTest
 * @author LaineyC
 */
public class GeneratorInstanceServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorInstanceService generatorInstanceService;
    
    public GeneratorInstanceServiceTest(){

    }

    /**
     * 生成器实例创建Test
     */
    @Test
    public void create() {
        GeneratorInstanceCreateParameter parameter = new GeneratorInstanceCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setDescription("");
        GeneratorInstance generatorInstance = generatorInstanceService.create(parameter);
        Assert.assertNotNull(generatorInstance);
    }
    
    /**
     * 生成器实例删除Test
     */
    @Test
    public void delete() {
        GeneratorInstanceDeleteParameter parameter = new GeneratorInstanceDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        GeneratorInstance generatorInstance = generatorInstanceService.delete(parameter);
        Assert.assertNotNull(generatorInstance);
    }

    /**
     * 生成器实例修改Test
     */
    @Test
    public void update() {
        GeneratorInstanceUpdateParameter parameter = new GeneratorInstanceUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        parameter.setName("");
        parameter.setDescription("");
        GeneratorInstance generatorInstance = generatorInstanceService.update(parameter);
        Assert.assertNotNull(generatorInstance);
    }
    
    /**
     * 生成器实例单个查询Test
     */
    @Test
    public void get(){
        GeneratorInstanceGetParameter parameter = new GeneratorInstanceGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        GeneratorInstance generatorInstance = generatorInstanceService.get(parameter);
        Assert.assertNotNull(generatorInstance);
    }

    /**
     * 生成器实例多个查询Test
     */
    @Test
    public void query() {
        GeneratorInstanceQueryParameter parameter = new GeneratorInstanceQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        List<GeneratorInstance> list = generatorInstanceService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器实例分页查询Test
     */
    @Test
    public void search() {
        GeneratorInstanceSearchParameter parameter = new GeneratorInstanceSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        PageResult<GeneratorInstance> pageResult = generatorInstanceService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器实例分页查询Test
     */
    @Test
    public void infoSearch() {
        GeneratorInstanceInfoSearchParameter parameter = new GeneratorInstanceInfoSearchParameter();
        parameter.setAuth(getAuth());
        PageResult<GeneratorInstance> generatorInstance = generatorInstanceService.infoSearch(parameter);
        Assert.assertNotNull(generatorInstance);
    }

    /**
     * 生成器实例生成Test
     */
    @Test
    public void make() {
        GeneratorInstanceMakeParameter parameter = new GeneratorInstanceMakeParameter();
        parameter.setAuth(getAuth());
        GeneratorInstanceMakeResult generatorInstanceMakeResult = generatorInstanceService.make(parameter);
        Assert.assertNotNull(generatorInstanceMakeResult);
    }

    /**
     * 生成器实例版本同步Test
     */
    @Test
    public void versionSync() {
        GeneratorInstanceVersionSyncParameter parameter = new GeneratorInstanceVersionSyncParameter();
        parameter.setAuth(getAuth());
        GeneratorInstance generatorInstance = generatorInstanceService.versionSync(parameter);
        Assert.assertNotNull(generatorInstance);
    }

}
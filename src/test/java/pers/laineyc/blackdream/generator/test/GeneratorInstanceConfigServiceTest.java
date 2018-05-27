package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceConfigService;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器实例设置ServiceTest
 * @author LaineyC
 */
public class GeneratorInstanceConfigServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorInstanceConfigService generatorInstanceConfigService;
    
    public GeneratorInstanceConfigServiceTest(){

    }

    /**
     * 生成器实例设置创建Test
     */
    @Test
    public void create() {
        GeneratorInstanceConfigCreateParameter parameter = new GeneratorInstanceConfigCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorInstanceId(0L);
        parameter.setName("");
        parameter.setDescription("");
        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.create(parameter);
        Assert.assertNotNull(generatorInstanceConfig);
    }
    
    /**
     * 生成器实例设置删除Test
     */
    @Test
    public void delete() {
        GeneratorInstanceConfigDeleteParameter parameter = new GeneratorInstanceConfigDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.delete(parameter);
        Assert.assertNotNull(generatorInstanceConfig);
    }

    /**
     * 生成器实例设置修改Test
     */
    @Test
    public void update() {
        GeneratorInstanceConfigUpdateParameter parameter = new GeneratorInstanceConfigUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setName("");
        parameter.setDescription("");
        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.update(parameter);
        Assert.assertNotNull(generatorInstanceConfig);
    }
    
    /**
     * 生成器实例设置单个查询Test
     */
    @Test
    public void get(){
        GeneratorInstanceConfigGetParameter parameter = new GeneratorInstanceConfigGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.get(parameter);
        Assert.assertNotNull(generatorInstanceConfig);
    }

    /**
     * 生成器实例设置多个查询Test
     */
    @Test
    public void query() {
        GeneratorInstanceConfigQueryParameter parameter = new GeneratorInstanceConfigQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setGeneratorInstanceId(0L);
        parameter.setName("");
        parameter.setDescription("");
        List<GeneratorInstanceConfig> list = generatorInstanceConfigService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器实例设置分页查询Test
     */
    @Test
    public void search() {
        GeneratorInstanceConfigSearchParameter parameter = new GeneratorInstanceConfigSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setGeneratorInstanceId(0L);
        parameter.setName("");
        parameter.setDescription("");
        PageResult<GeneratorInstanceConfig> pageResult = generatorInstanceConfigService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

}
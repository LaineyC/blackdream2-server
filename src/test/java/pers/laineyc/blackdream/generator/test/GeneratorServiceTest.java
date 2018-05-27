package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.GeneratorService;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorExportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorImportParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInfoSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorReleaseParameter;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器ServiceTest
 * @author LaineyC
 */
public class GeneratorServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorService generatorService;
    
    public GeneratorServiceTest(){

    }

    /**
     * 生成器创建Test
     */
    @Test
    public void create() {
        GeneratorCreateParameter parameter = new GeneratorCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setName("");
        parameter.setEngineType(0);
        parameter.setDescription("");
        Generator generator = generatorService.create(parameter);
        Assert.assertNotNull(generator);
    }
    
    /**
     * 生成器删除Test
     */
    @Test
    public void delete() {
        GeneratorDeleteParameter parameter = new GeneratorDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        Generator generator = generatorService.delete(parameter);
        Assert.assertNotNull(generator);
    }

    /**
     * 生成器修改Test
     */
    @Test
    public void update() {
        GeneratorUpdateParameter parameter = new GeneratorUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setName("");
        parameter.setEngineType(0);
        parameter.setDescription("");
        Generator generator = generatorService.update(parameter);
        Assert.assertNotNull(generator);
    }
    
    /**
     * 生成器单个查询Test
     */
    @Test
    public void get(){
        GeneratorGetParameter parameter = new GeneratorGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        Generator generator = generatorService.get(parameter);
        Assert.assertNotNull(generator);
    }

    /**
     * 生成器多个查询Test
     */
    @Test
    public void query() {
        GeneratorQueryParameter parameter = new GeneratorQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setName("");
        parameter.setStatus(0);
        parameter.setEngineType(0);
        List<Generator> list = generatorService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器分页查询Test
     */
    @Test
    public void search() {
        GeneratorSearchParameter parameter = new GeneratorSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setName("");
        parameter.setStatus(0);
        parameter.setEngineType(0);
        PageResult<Generator> pageResult = generatorService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器导出Test
     */
    @Test
    public void export() {
        GeneratorExportParameter parameter = new GeneratorExportParameter();
        parameter.setAuth(getAuth());
        Generator generator = generatorService.export(parameter);
        Assert.assertNotNull(generator);
    }

    /**
     * 生成器导入Test
     */
    @Test
    public void import_() {
        GeneratorImportParameter parameter = new GeneratorImportParameter();
        parameter.setAuth(getAuth());
        Generator generator = generatorService.import_(parameter);
        Assert.assertNotNull(generator);
    }

    /**
     * 生成器分页查询Test
     */
    @Test
    public void infoSearch() {
        GeneratorInfoSearchParameter parameter = new GeneratorInfoSearchParameter();
        parameter.setAuth(getAuth());
        PageResult<Generator> pageResult = generatorService.infoSearch(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器发布Test
     */
    @Test
    public void release() {
        GeneratorReleaseParameter parameter = new GeneratorReleaseParameter();
        parameter.setAuth(getAuth());
        Generator generator = generatorService.release(parameter);
        Assert.assertNotNull(generator);
    }

}
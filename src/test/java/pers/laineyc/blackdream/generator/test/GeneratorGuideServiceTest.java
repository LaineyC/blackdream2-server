package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.GeneratorGuideService;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGuideSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorGuide;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器指南ServiceTest
 * @author LaineyC
 */
public class GeneratorGuideServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorGuideService generatorGuideService;
    
    public GeneratorGuideServiceTest(){

    }

    /**
     * 生成器指南创建Test
     */
    @Test
    public void create() {
        GeneratorGuideCreateParameter parameter = new GeneratorGuideCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setDescription("");
        GeneratorGuide generatorGuide = generatorGuideService.create(parameter);
        Assert.assertNotNull(generatorGuide);
    }
    
    /**
     * 生成器指南删除Test
     */
    @Test
    public void delete() {
        GeneratorGuideDeleteParameter parameter = new GeneratorGuideDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        GeneratorGuide generatorGuide = generatorGuideService.delete(parameter);
        Assert.assertNotNull(generatorGuide);
    }

    /**
     * 生成器指南修改Test
     */
    @Test
    public void update() {
        GeneratorGuideUpdateParameter parameter = new GeneratorGuideUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        parameter.setName("");
        parameter.setDescription("");
        GeneratorGuide generatorGuide = generatorGuideService.update(parameter);
        Assert.assertNotNull(generatorGuide);
    }
    
    /**
     * 生成器指南单个查询Test
     */
    @Test
    public void get(){
        GeneratorGuideGetParameter parameter = new GeneratorGuideGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        GeneratorGuide generatorGuide = generatorGuideService.get(parameter);
        Assert.assertNotNull(generatorGuide);
    }

    /**
     * 生成器指南多个查询Test
     */
    @Test
    public void query() {
        GeneratorGuideQueryParameter parameter = new GeneratorGuideQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        List<GeneratorGuide> list = generatorGuideService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器指南分页查询Test
     */
    @Test
    public void search() {
        GeneratorGuideSearchParameter parameter = new GeneratorGuideSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        PageResult<GeneratorGuide> pageResult = generatorGuideService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

}
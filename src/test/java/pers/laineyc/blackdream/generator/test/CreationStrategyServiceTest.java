package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.CreationStrategyService;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategyCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategyDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategyUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategyGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategyQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategySearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.CreationStrategySortParameter;
import pers.laineyc.blackdream.generator.service.domain.CreationStrategy;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器生成策略ServiceTest
 * @author LaineyC
 */
public class CreationStrategyServiceTest extends BaseServiceTest {

    @Autowired
    private CreationStrategyService creationStrategyService;
    
    public CreationStrategyServiceTest(){

    }

    /**
     * 生成器生成策略创建Test
     */
    @Test
    public void create() {
        CreationStrategyCreateParameter parameter = new CreationStrategyCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setDescription("");
        CreationStrategy creationStrategy = creationStrategyService.create(parameter);
        Assert.assertNotNull(creationStrategy);
    }
    
    /**
     * 生成器生成策略删除Test
     */
    @Test
    public void delete() {
        CreationStrategyDeleteParameter parameter = new CreationStrategyDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        CreationStrategy creationStrategy = creationStrategyService.delete(parameter);
        Assert.assertNotNull(creationStrategy);
    }

    /**
     * 生成器生成策略修改Test
     */
    @Test
    public void update() {
        CreationStrategyUpdateParameter parameter = new CreationStrategyUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        parameter.setName("");
        parameter.setDescription("");
        CreationStrategy creationStrategy = creationStrategyService.update(parameter);
        Assert.assertNotNull(creationStrategy);
    }
    
    /**
     * 生成器生成策略单个查询Test
     */
    @Test
    public void get(){
        CreationStrategyGetParameter parameter = new CreationStrategyGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        CreationStrategy creationStrategy = creationStrategyService.get(parameter);
        Assert.assertNotNull(creationStrategy);
    }

    /**
     * 生成器生成策略多个查询Test
     */
    @Test
    public void query() {
        CreationStrategyQueryParameter parameter = new CreationStrategyQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        List<CreationStrategy> list = creationStrategyService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器生成策略分页查询Test
     */
    @Test
    public void search() {
        CreationStrategySearchParameter parameter = new CreationStrategySearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        PageResult<CreationStrategy> pageResult = creationStrategyService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器生成策略排序Test
     */
    @Test
    public void sort() {
        CreationStrategySortParameter parameter = new CreationStrategySortParameter();
        parameter.setAuth(getAuth());
        CreationStrategy creationStrategy = creationStrategyService.sort(parameter);
        Assert.assertNotNull(creationStrategy);
    }

}
package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.GeneratorDataService;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorData;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器数据ServiceTest
 * @author LaineyC
 */
public class GeneratorDataServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorDataService generatorDataService;
    
    public GeneratorDataServiceTest(){

    }

    /**
     * 生成器数据创建Test
     */
    @Test
    public void create() {
        GeneratorDataCreateParameter parameter = new GeneratorDataCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorInstanceId(0L);
        parameter.setDataModelId(0L);
        parameter.setName("");
        parameter.setIsExpanded(false);
        parameter.setParentId(0L);
        GeneratorData generatorData = generatorDataService.create(parameter);
        Assert.assertNotNull(generatorData);
    }
    
    /**
     * 生成器数据删除Test
     */
    @Test
    public void delete() {
        GeneratorDataDeleteParameter parameter = new GeneratorDataDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        GeneratorData generatorData = generatorDataService.delete(parameter);
        Assert.assertNotNull(generatorData);
    }

    /**
     * 生成器数据修改Test
     */
    @Test
    public void update() {
        GeneratorDataUpdateParameter parameter = new GeneratorDataUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        parameter.setName("");
        parameter.setIsExpanded(false);
        parameter.setParentId(0L);
        GeneratorData generatorData = generatorDataService.update(parameter);
        Assert.assertNotNull(generatorData);
    }
    
    /**
     * 生成器数据单个查询Test
     */
    @Test
    public void get(){
        GeneratorDataGetParameter parameter = new GeneratorDataGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        GeneratorData generatorData = generatorDataService.get(parameter);
        Assert.assertNotNull(generatorData);
    }

    /**
     * 生成器数据多个查询Test
     */
    @Test
    public void query() {
        GeneratorDataQueryParameter parameter = new GeneratorDataQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setGeneratorInstanceId(0L);
        parameter.setDataModelId(0L);
        parameter.setName("");
        parameter.setParentId(0L);
        List<GeneratorData> list = generatorDataService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器数据分页查询Test
     */
    @Test
    public void search() {
        GeneratorDataSearchParameter parameter = new GeneratorDataSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setGeneratorId(0L);
        parameter.setGeneratorInstanceId(0L);
        parameter.setDataModelId(0L);
        parameter.setName("");
        parameter.setParentId(0L);
        PageResult<GeneratorData> pageResult = generatorDataService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器数据树形查询Test
     */
    @Test
    public void tree() {
        GeneratorDataTreeParameter parameter = new GeneratorDataTreeParameter();
        parameter.setAuth(getAuth());
        List<GeneratorData> generatorDataList = generatorDataService.tree(parameter);
        Assert.assertNotNull(generatorDataList);
    }

    /**
     * 生成器数据排序Test
     */
    @Test
    public void sort() {
        GeneratorDataSortParameter parameter = new GeneratorDataSortParameter();
        parameter.setAuth(getAuth());
        GeneratorData generatorData = generatorDataService.sort(parameter);
        Assert.assertNotNull(generatorData);
    }

}
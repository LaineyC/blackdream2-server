package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategyCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategyDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategyUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategyGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategyQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategySearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategySearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategySortWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.CreationStrategySortWebResponse;
import java.util.Date; 

/**
 * 生成器生成策略ControllerTest
 * @author LaineyC
 */
public class CreationStrategyWebControllerTest extends BaseWebControllerTest {

    public CreationStrategyWebControllerTest(){

    }

    /**
     * 生成器生成策略创建Test
     */
    @Test
    public void create() throws Exception {
        CreationStrategyCreateWebRequest request = new CreationStrategyCreateWebRequest();
        request.setGeneratorId(0L);
        request.setName("");
        request.setDescription("");
        CreationStrategyCreateWebResponse response = execute(request, CreationStrategyCreateWebResponse.class, "/creationStrategy/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器生成策略删除Test
     */
    @Test
    public void delete() throws Exception {
        CreationStrategyDeleteWebRequest request = new CreationStrategyDeleteWebRequest();
        request.setId(0L);
        CreationStrategyDeleteWebResponse response = execute(request, CreationStrategyDeleteWebResponse.class, "/creationStrategy/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略修改Test
     */
    @Test
    public void update() throws Exception {
        CreationStrategyUpdateWebRequest request = new CreationStrategyUpdateWebRequest();
        request.setId(0L);
        request.setName("");
        request.setDescription("");
        CreationStrategyUpdateWebResponse response = execute(request, CreationStrategyUpdateWebResponse.class, "/creationStrategy/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器生成策略单个查询Test
     */
    @Test
    public void get() throws Exception {
        CreationStrategyGetWebRequest request = new CreationStrategyGetWebRequest();
        request.setId(0L);
        CreationStrategyGetWebResponse response = execute(request, CreationStrategyGetWebResponse.class, "/creationStrategy/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略多个查询Test
     */
    @Test
    public void query() throws Exception {
        CreationStrategyQueryWebRequest request = new CreationStrategyQueryWebRequest();
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        CreationStrategyQueryWebResponse response = execute(request, CreationStrategyQueryWebResponse.class, "/creationStrategy/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略分页查询Test
     */
    @Test
    public void search() throws Exception {
        CreationStrategySearchWebRequest request = new CreationStrategySearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        CreationStrategySearchWebResponse response = execute(request, CreationStrategySearchWebResponse.class, "/creationStrategy/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略排序Test
     */
    @Test
    public void sort() throws Exception {
        CreationStrategySortWebRequest request = new CreationStrategySortWebRequest();
        CreationStrategySortWebResponse response = execute(request, CreationStrategySortWebResponse.class, "/creationStrategy/sort");
        Assert.assertNotNull(response.getBody());
    }

}
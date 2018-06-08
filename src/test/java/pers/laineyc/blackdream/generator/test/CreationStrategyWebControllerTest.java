package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategyQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategySearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.CreationStrategySortWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.*;

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
        request.setGeneratorId("");
        request.setName("");
        request.setDescription("");
        Response<CreationStrategyCreateWebVo> response = execute(request, CreationStrategyCreateWebVo.class, "/creationStrategy/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器生成策略删除Test
     */
    @Test
    public void delete() throws Exception {
        CreationStrategyDeleteWebRequest request = new CreationStrategyDeleteWebRequest();
        request.setId("");
        Response<CreationStrategyDeleteWebVo> response = execute(request, CreationStrategyDeleteWebVo.class, "/creationStrategy/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略修改Test
     */
    @Test
    public void update() throws Exception {
        CreationStrategyUpdateWebRequest request = new CreationStrategyUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setDescription("");
        Response<CreationStrategyUpdateWebVo> response = execute(request, CreationStrategyUpdateWebVo.class, "/creationStrategy/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器生成策略单个查询Test
     */
    @Test
    public void get() throws Exception {
        CreationStrategyGetWebRequest request = new CreationStrategyGetWebRequest();
        request.setId("");
        Response<CreationStrategyGetWebVo> response = execute(request, CreationStrategyGetWebVo.class, "/creationStrategy/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略多个查询Test
     */
    @Test
    public void query() throws Exception {
        CreationStrategyQueryWebRequest request = new CreationStrategyQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<CreationStrategyQueryWebVo> response = execute(request, CreationStrategyQueryWebVo.class, "/creationStrategy/query");
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
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<CreationStrategySearchWebVo> response = execute(request, CreationStrategySearchWebVo.class, "/creationStrategy/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器生成策略排序Test
     */
    @Test
    public void sort() throws Exception {
        CreationStrategySortWebRequest request = new CreationStrategySortWebRequest();
        Response<CreationStrategySortWebVo> response = execute(request, CreationStrategySortWebVo.class, "/creationStrategy/sort");
        Assert.assertNotNull(response.getBody());
    }

}
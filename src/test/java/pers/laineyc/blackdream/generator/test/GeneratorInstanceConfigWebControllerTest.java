package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigSearchWebResponse;
import java.util.Date; 

/**
 * 生成器实例设置ControllerTest
 * @author LaineyC
 */
public class GeneratorInstanceConfigWebControllerTest extends BaseWebControllerTest {

    public GeneratorInstanceConfigWebControllerTest(){

    }

    /**
     * 生成器实例设置创建Test
     */
    @Test
    public void create() throws Exception {
        GeneratorInstanceConfigCreateWebRequest request = new GeneratorInstanceConfigCreateWebRequest();
        request.setGeneratorInstanceId(0L);
        request.setName("");
        request.setDescription("");
        GeneratorInstanceConfigCreateWebResponse response = execute(request, GeneratorInstanceConfigCreateWebResponse.class, "/generatorInstanceConfig/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例设置删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorInstanceConfigDeleteWebRequest request = new GeneratorInstanceConfigDeleteWebRequest();
        request.setId(0L);
        GeneratorInstanceConfigDeleteWebResponse response = execute(request, GeneratorInstanceConfigDeleteWebResponse.class, "/generatorInstanceConfig/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例设置修改Test
     */
    @Test
    public void update() throws Exception {
        GeneratorInstanceConfigUpdateWebRequest request = new GeneratorInstanceConfigUpdateWebRequest();
        request.setId(0L);
        request.setName("");
        request.setDescription("");
        GeneratorInstanceConfigUpdateWebResponse response = execute(request, GeneratorInstanceConfigUpdateWebResponse.class, "/generatorInstanceConfig/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例设置单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorInstanceConfigGetWebRequest request = new GeneratorInstanceConfigGetWebRequest();
        request.setId(0L);
        GeneratorInstanceConfigGetWebResponse response = execute(request, GeneratorInstanceConfigGetWebResponse.class, "/generatorInstanceConfig/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例设置多个查询Test
     */
    @Test
    public void query() throws Exception {
        GeneratorInstanceConfigQueryWebRequest request = new GeneratorInstanceConfigQueryWebRequest();
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setGeneratorInstanceId(0L);
        request.setName("");
        request.setDescription("");
        GeneratorInstanceConfigQueryWebResponse response = execute(request, GeneratorInstanceConfigQueryWebResponse.class, "/generatorInstanceConfig/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例设置分页查询Test
     */
    @Test
    public void search() throws Exception {
        GeneratorInstanceConfigSearchWebRequest request = new GeneratorInstanceConfigSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setGeneratorInstanceId(0L);
        request.setName("");
        request.setDescription("");
        GeneratorInstanceConfigSearchWebResponse response = execute(request, GeneratorInstanceConfigSearchWebResponse.class, "/generatorInstanceConfig/search");
        Assert.assertNotNull(response.getBody());
    }

}
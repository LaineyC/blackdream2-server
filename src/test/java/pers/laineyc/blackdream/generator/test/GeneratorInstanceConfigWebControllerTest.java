package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.*;

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
        request.setGeneratorInstanceId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceConfigCreateWebVo> response = execute(request, GeneratorInstanceConfigCreateWebVo.class, "/generatorInstanceConfig/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例设置删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorInstanceConfigDeleteWebRequest request = new GeneratorInstanceConfigDeleteWebRequest();
        request.setId("");
        Response<GeneratorInstanceConfigCreateWebVo> response = execute(request, GeneratorInstanceConfigCreateWebVo.class, "/generatorInstanceConfig/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例设置修改Test
     */
    @Test
    public void update() throws Exception {
        GeneratorInstanceConfigUpdateWebRequest request = new GeneratorInstanceConfigUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceConfigUpdateWebVo> response = execute(request, GeneratorInstanceConfigUpdateWebVo.class, "/generatorInstanceConfig/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例设置单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorInstanceConfigGetWebRequest request = new GeneratorInstanceConfigGetWebRequest();
        request.setId("");
        Response<GeneratorInstanceConfigGetWebVo> response = execute(request, GeneratorInstanceConfigGetWebVo.class, "/generatorInstanceConfig/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例设置多个查询Test
     */
    @Test
    public void query() throws Exception {
        GeneratorInstanceConfigQueryWebRequest request = new GeneratorInstanceConfigQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setGeneratorInstanceId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceConfigQueryWebVo> response = execute(request, GeneratorInstanceConfigQueryWebVo.class, "/generatorInstanceConfig/query");
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
        request.setUserId("");
        request.setGeneratorId("");
        request.setGeneratorInstanceId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceConfigSearchWebVo> response = execute(request, GeneratorInstanceConfigSearchWebVo.class, "/generatorInstanceConfig/search");
        Assert.assertNotNull(response.getBody());
    }

}
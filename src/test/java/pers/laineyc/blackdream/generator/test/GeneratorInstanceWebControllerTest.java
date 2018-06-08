package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.action.web.vo.*;

/**
 * 生成器实例ControllerTest
 * @author LaineyC
 */
public class GeneratorInstanceWebControllerTest extends BaseWebControllerTest {

    public GeneratorInstanceWebControllerTest(){

    }

    /**
     * 生成器实例创建Test
     */
    @Test
    public void create() throws Exception {
        GeneratorInstanceCreateWebRequest request = new GeneratorInstanceCreateWebRequest();
        request.setGeneratorId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceCreateWebVo> response = execute(request, GeneratorInstanceCreateWebVo.class, "/generatorInstance/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorInstanceDeleteWebRequest request = new GeneratorInstanceDeleteWebRequest();
        request.setId("");
        Response<GeneratorInstanceDeleteWebVo> response = execute(request, GeneratorInstanceDeleteWebVo.class, "/generatorInstance/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例修改Test
     */
    @Test
    public void update() throws Exception {
        GeneratorInstanceUpdateWebRequest request = new GeneratorInstanceUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setDescription("");
        Response<GeneratorInstanceUpdateWebVo> response = execute(request, GeneratorInstanceUpdateWebVo.class, "/generatorInstance/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorInstanceGetWebRequest request = new GeneratorInstanceGetWebRequest();
        request.setId("");
        Response<GeneratorInstanceGetWebVo> response = execute(request, GeneratorInstanceGetWebVo.class, "/generatorInstance/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例多个查询Test
     */
    @Test
    public void query() throws Exception {
        GeneratorInstanceQueryWebRequest request = new GeneratorInstanceQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<GeneratorInstanceQueryWebVo> response = execute(request, GeneratorInstanceQueryWebVo.class, "/generatorInstance/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例分页查询Test
     */
    @Test
    public void search() throws Exception {
        GeneratorInstanceSearchWebRequest request = new GeneratorInstanceSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<GeneratorInstanceSearchWebVo> response = execute(request, GeneratorInstanceSearchWebVo.class, "/generatorInstance/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例分页查询Test
     */
    @Test
    public void infoSearch() throws Exception {
        GeneratorInstanceInfoSearchWebRequest request = new GeneratorInstanceInfoSearchWebRequest();
        Response<GeneratorInstanceInfoSearchWebVo> response = execute(request, GeneratorInstanceInfoSearchWebVo.class, "/generatorInstance/infoSearch");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例生成Test
     */
    @Test
    public void make() throws Exception {
        GeneratorInstanceMakeWebRequest request = new GeneratorInstanceMakeWebRequest();
        Response<GeneratorInstanceMakeWebVo> response = execute(request, GeneratorInstanceMakeWebVo.class, "/generatorInstance/make");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例版本同步Test
     */
    @Test
    public void versionSync() throws Exception {
        GeneratorInstanceVersionSyncWebRequest request = new GeneratorInstanceVersionSyncWebRequest();
        Response<GeneratorInstanceVersionSyncWebVo> response = execute(request, GeneratorInstanceVersionSyncWebVo.class, "/generatorInstance/versionSync");
        Assert.assertNotNull(response.getBody());
    }

}
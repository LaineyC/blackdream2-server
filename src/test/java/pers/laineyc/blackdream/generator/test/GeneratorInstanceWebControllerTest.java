package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceInfoSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceInfoSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceMakeWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceMakeWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceVersionSyncWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceVersionSyncWebResponse;
import java.util.Date; 

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
        GeneratorInstanceCreateWebResponse response = execute(request, GeneratorInstanceCreateWebResponse.class, "/generatorInstance/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorInstanceDeleteWebRequest request = new GeneratorInstanceDeleteWebRequest();
        request.setId("");
        GeneratorInstanceDeleteWebResponse response = execute(request, GeneratorInstanceDeleteWebResponse.class, "/generatorInstance/delete");
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
        GeneratorInstanceUpdateWebResponse response = execute(request, GeneratorInstanceUpdateWebResponse.class, "/generatorInstance/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器实例单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorInstanceGetWebRequest request = new GeneratorInstanceGetWebRequest();
        request.setId("");
        GeneratorInstanceGetWebResponse response = execute(request, GeneratorInstanceGetWebResponse.class, "/generatorInstance/get");
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
        GeneratorInstanceQueryWebResponse response = execute(request, GeneratorInstanceQueryWebResponse.class, "/generatorInstance/query");
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
        GeneratorInstanceSearchWebResponse response = execute(request, GeneratorInstanceSearchWebResponse.class, "/generatorInstance/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例分页查询Test
     */
    @Test
    public void infoSearch() throws Exception {
        GeneratorInstanceInfoSearchWebRequest request = new GeneratorInstanceInfoSearchWebRequest();
        GeneratorInstanceInfoSearchWebResponse response = execute(request, GeneratorInstanceInfoSearchWebResponse.class, "/generatorInstance/infoSearch");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例生成Test
     */
    @Test
    public void make() throws Exception {
        GeneratorInstanceMakeWebRequest request = new GeneratorInstanceMakeWebRequest();
        GeneratorInstanceMakeWebResponse response = execute(request, GeneratorInstanceMakeWebResponse.class, "/generatorInstance/make");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器实例版本同步Test
     */
    @Test
    public void versionSync() throws Exception {
        GeneratorInstanceVersionSyncWebRequest request = new GeneratorInstanceVersionSyncWebRequest();
        GeneratorInstanceVersionSyncWebResponse response = execute(request, GeneratorInstanceVersionSyncWebResponse.class, "/generatorInstance/versionSync");
        Assert.assertNotNull(response.getBody());
    }

}
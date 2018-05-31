package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGuideSearchWebResponse;
import java.util.Date; 

/**
 * 生成器指南ControllerTest
 * @author LaineyC
 */
public class GeneratorGuideWebControllerTest extends BaseWebControllerTest {

    public GeneratorGuideWebControllerTest(){

    }

    /**
     * 生成器指南创建Test
     */
    @Test
    public void create() throws Exception {
        GeneratorGuideCreateWebRequest request = new GeneratorGuideCreateWebRequest();
        request.setGeneratorId("");
        request.setName("");
        request.setDescription("");
        GeneratorGuideCreateWebResponse response = execute(request, GeneratorGuideCreateWebResponse.class, "/generatorGuide/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器指南删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorGuideDeleteWebRequest request = new GeneratorGuideDeleteWebRequest();
        request.setId("");
        GeneratorGuideDeleteWebResponse response = execute(request, GeneratorGuideDeleteWebResponse.class, "/generatorGuide/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器指南修改Test
     */
    @Test
    public void update() throws Exception {
        GeneratorGuideUpdateWebRequest request = new GeneratorGuideUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setDescription("");
        GeneratorGuideUpdateWebResponse response = execute(request, GeneratorGuideUpdateWebResponse.class, "/generatorGuide/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器指南单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorGuideGetWebRequest request = new GeneratorGuideGetWebRequest();
        request.setId("");
        GeneratorGuideGetWebResponse response = execute(request, GeneratorGuideGetWebResponse.class, "/generatorGuide/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器指南多个查询Test
     */
    @Test
    public void query() throws Exception {
        GeneratorGuideQueryWebRequest request = new GeneratorGuideQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        GeneratorGuideQueryWebResponse response = execute(request, GeneratorGuideQueryWebResponse.class, "/generatorGuide/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器指南分页查询Test
     */
    @Test
    public void search() throws Exception {
        GeneratorGuideSearchWebRequest request = new GeneratorGuideSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        GeneratorGuideSearchWebResponse response = execute(request, GeneratorGuideSearchWebResponse.class, "/generatorGuide/search");
        Assert.assertNotNull(response.getBody());
    }

}
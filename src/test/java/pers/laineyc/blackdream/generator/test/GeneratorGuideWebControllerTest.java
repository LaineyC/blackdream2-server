package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGuideSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.*;

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
        Response<GeneratorGuideCreateWebVo> response = execute(request, GeneratorGuideCreateWebVo.class, "/generatorGuide/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器指南删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorGuideDeleteWebRequest request = new GeneratorGuideDeleteWebRequest();
        request.setId("");
        Response<GeneratorGuideDeleteWebVo> response = execute(request, GeneratorGuideDeleteWebVo.class, "/generatorGuide/delete");
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
        Response<GeneratorGuideUpdateWebVo> response = execute(request, GeneratorGuideUpdateWebVo.class, "/generatorGuide/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器指南单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorGuideGetWebRequest request = new GeneratorGuideGetWebRequest();
        request.setId("");
        Response<GeneratorGuideGetWebVo> response = execute(request, GeneratorGuideGetWebVo.class, "/generatorGuide/get");
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
        Response<GeneratorGuideQueryWebVo> response = execute(request, GeneratorGuideQueryWebVo.class, "/generatorGuide/query");
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
        Response<GeneratorGuideSearchWebVo> response = execute(request, GeneratorGuideSearchWebVo.class, "/generatorGuide/search");
        Assert.assertNotNull(response.getBody());
    }

}
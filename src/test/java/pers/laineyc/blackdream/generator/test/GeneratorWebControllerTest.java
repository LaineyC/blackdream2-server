package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorExportWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorExportWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorImportWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorImportWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInfoSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInfoSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorReleaseWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorReleaseWebResponse;
import java.util.Date; 

/**
 * 生成器ControllerTest
 * @author LaineyC
 */
public class GeneratorWebControllerTest extends BaseWebControllerTest {

    public GeneratorWebControllerTest(){

    }

    /**
     * 生成器创建Test
     */
    @Test
    public void create() throws Exception {
        GeneratorCreateWebRequest request = new GeneratorCreateWebRequest();
        request.setName("");
        request.setEngineType(0);
        request.setDescription("");
        GeneratorCreateWebResponse response = execute(request, GeneratorCreateWebResponse.class, "/generator/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorDeleteWebRequest request = new GeneratorDeleteWebRequest();
        request.setId("");
        GeneratorDeleteWebResponse response = execute(request, GeneratorDeleteWebResponse.class, "/generator/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器修改Test
     */
    @Test
    public void update() throws Exception {
        GeneratorUpdateWebRequest request = new GeneratorUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setEngineType(0);
        request.setDescription("");
        GeneratorUpdateWebResponse response = execute(request, GeneratorUpdateWebResponse.class, "/generator/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorGetWebRequest request = new GeneratorGetWebRequest();
        request.setId("");
        GeneratorGetWebResponse response = execute(request, GeneratorGetWebResponse.class, "/generator/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器多个查询Test
     */
    @Test
    public void query() throws Exception {
        GeneratorQueryWebRequest request = new GeneratorQueryWebRequest();
        request.setUserId("");
        request.setName("");
        request.setStatus(0);
        request.setEngineType(0);
        GeneratorQueryWebResponse response = execute(request, GeneratorQueryWebResponse.class, "/generator/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器分页查询Test
     */
    @Test
    public void search() throws Exception {
        GeneratorSearchWebRequest request = new GeneratorSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId("");
        request.setName("");
        request.setStatus(0);
        request.setEngineType(0);
        GeneratorSearchWebResponse response = execute(request, GeneratorSearchWebResponse.class, "/generator/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器导出Test
     */
    @Test
    public void export() throws Exception {
        GeneratorExportWebRequest request = new GeneratorExportWebRequest();
        GeneratorExportWebResponse response = execute(request, GeneratorExportWebResponse.class, "/generator/export");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器导入Test
     */
    @Test
    public void import_() throws Exception {
        GeneratorImportWebRequest request = new GeneratorImportWebRequest();
        GeneratorImportWebResponse response = execute(request, GeneratorImportWebResponse.class, "/generator/import");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器分页查询Test
     */
    @Test
    public void infoSearch() throws Exception {
        GeneratorInfoSearchWebRequest request = new GeneratorInfoSearchWebRequest();
        GeneratorInfoSearchWebResponse response = execute(request, GeneratorInfoSearchWebResponse.class, "/generator/infoSearch");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器发布Test
     */
    @Test
    public void release() throws Exception {
        GeneratorReleaseWebRequest request = new GeneratorReleaseWebRequest();
        GeneratorReleaseWebResponse response = execute(request, GeneratorReleaseWebResponse.class, "/generator/release");
        Assert.assertNotNull(response.getBody());
    }

}
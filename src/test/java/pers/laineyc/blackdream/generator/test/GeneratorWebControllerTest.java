package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.service.domain.*;

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
        Response<Generator> response = execute(request, Generator.class, "/generator/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器删除Test
     */
    @Test
    public void delete() throws Exception {
        GeneratorDeleteWebRequest request = new GeneratorDeleteWebRequest();
        request.setId("");
        Response<Generator> response = execute(request, Generator.class, "/generator/delete");
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
        Response<Generator> response = execute(request, Generator.class, "/generator/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器单个查询Test
     */
    @Test
    public void get() throws Exception {
        GeneratorGetWebRequest request = new GeneratorGetWebRequest();
        request.setId("");
        Response<Generator> response = execute(request, Generator.class, "/generator/get");
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
        Response<Generator> response = execute(request, Generator.class, "/generator/query");
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
        Response<Generator> response = execute(request, Generator.class, "/generator/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器导出Test
     */
    @Test
    public void export() throws Exception {
        GeneratorExportWebRequest request = new GeneratorExportWebRequest();
        Response<Generator> response = execute(request, Generator.class, "/generator/export");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器导入Test
     */
    @Test
    public void import_() throws Exception {
        GeneratorImportWebRequest request = new GeneratorImportWebRequest();
        Response<Generator> response = execute(request, Generator.class, "/generator/import");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器分页查询Test
     */
    @Test
    public void infoSearch() throws Exception {
        GeneratorInfoSearchWebRequest request = new GeneratorInfoSearchWebRequest();
        Response<Generator> response = execute(request, Generator.class, "/generator/infoSearch");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器发布Test
     */
    @Test
    public void release() throws Exception {
        GeneratorReleaseWebRequest request = new GeneratorReleaseWebRequest();
        Response<Generator> response = execute(request, Generator.class, "/generator/release");
        Assert.assertNotNull(response.getBody());
    }

}
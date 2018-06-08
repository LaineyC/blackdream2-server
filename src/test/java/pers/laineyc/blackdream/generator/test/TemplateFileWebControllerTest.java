package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.action.web.vo.*;

/**
 * 生成器模板文件ControllerTest
 * @author LaineyC
 */
public class TemplateFileWebControllerTest extends BaseWebControllerTest {

    public TemplateFileWebControllerTest(){

    }

    /**
     * 生成器模板文件创建Test
     */
    @Test
    public void create() throws Exception {
        TemplateFileCreateWebRequest request = new TemplateFileCreateWebRequest();
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        request.setDescription("");
        Response<TemplateFileCreateWebVo> response = execute(request, TemplateFileCreateWebVo.class, "/templateFile/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器模板文件删除Test
     */
    @Test
    public void delete() throws Exception {
        TemplateFileDeleteWebRequest request = new TemplateFileDeleteWebRequest();
        request.setId("");
        Response<TemplateFileDeleteWebVo> response = execute(request, TemplateFileDeleteWebVo.class, "/templateFile/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件修改Test
     */
    @Test
    public void update() throws Exception {
        TemplateFileUpdateWebRequest request = new TemplateFileUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        request.setDescription("");
        Response<TemplateFileUpdateWebVo> response = execute(request, TemplateFileUpdateWebVo.class, "/templateFile/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器模板文件单个查询Test
     */
    @Test
    public void get() throws Exception {
        TemplateFileGetWebRequest request = new TemplateFileGetWebRequest();
        request.setId("");
        Response<TemplateFileGetWebVo> response = execute(request, TemplateFileGetWebVo.class, "/templateFile/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件多个查询Test
     */
    @Test
    public void query() throws Exception {
        TemplateFileQueryWebRequest request = new TemplateFileQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        Response<TemplateFileQueryWebVo> response = execute(request, TemplateFileQueryWebVo.class, "/templateFile/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件分页查询Test
     */
    @Test
    public void search() throws Exception {
        TemplateFileSearchWebRequest request = new TemplateFileSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        Response<TemplateFileSearchWebVo> response = execute(request, TemplateFileSearchWebVo.class, "/templateFile/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件排序Test
     */
    @Test
    public void sort() throws Exception {
        TemplateFileSortWebRequest request = new TemplateFileSortWebRequest();
        Response<TemplateFileSortWebVo> response = execute(request, TemplateFileSortWebVo.class, "/templateFile/sort");
        Assert.assertNotNull(response.getBody());
    }

}
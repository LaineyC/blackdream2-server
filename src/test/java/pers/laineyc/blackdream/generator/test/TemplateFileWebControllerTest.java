package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.TemplateFileSortWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.TemplateFileSortWebResponse;
import java.util.Date; 

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
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        request.setDescription("");
        TemplateFileCreateWebResponse response = execute(request, TemplateFileCreateWebResponse.class, "/templateFile/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器模板文件删除Test
     */
    @Test
    public void delete() throws Exception {
        TemplateFileDeleteWebRequest request = new TemplateFileDeleteWebRequest();
        request.setId(0L);
        TemplateFileDeleteWebResponse response = execute(request, TemplateFileDeleteWebResponse.class, "/templateFile/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件修改Test
     */
    @Test
    public void update() throws Exception {
        TemplateFileUpdateWebRequest request = new TemplateFileUpdateWebRequest();
        request.setId(0L);
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        request.setDescription("");
        TemplateFileUpdateWebResponse response = execute(request, TemplateFileUpdateWebResponse.class, "/templateFile/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器模板文件单个查询Test
     */
    @Test
    public void get() throws Exception {
        TemplateFileGetWebRequest request = new TemplateFileGetWebRequest();
        request.setId(0L);
        TemplateFileGetWebResponse response = execute(request, TemplateFileGetWebResponse.class, "/templateFile/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件多个查询Test
     */
    @Test
    public void query() throws Exception {
        TemplateFileQueryWebRequest request = new TemplateFileQueryWebRequest();
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        TemplateFileQueryWebResponse response = execute(request, TemplateFileQueryWebResponse.class, "/templateFile/query");
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
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setEngineType(0);
        request.setDisplayGroup("");
        TemplateFileSearchWebResponse response = execute(request, TemplateFileSearchWebResponse.class, "/templateFile/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器模板文件排序Test
     */
    @Test
    public void sort() throws Exception {
        TemplateFileSortWebRequest request = new TemplateFileSortWebRequest();
        TemplateFileSortWebResponse response = execute(request, TemplateFileSortWebResponse.class, "/templateFile/sort");
        Assert.assertNotNull(response.getBody());
    }

}
package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSortWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSortWebResponse;
import java.util.Date; 

/**
 * 生成器数据模型ControllerTest
 * @author LaineyC
 */
public class DataModelWebControllerTest extends BaseWebControllerTest {

    public DataModelWebControllerTest(){

    }

    /**
     * 生成器数据模型创建Test
     */
    @Test
    public void create() throws Exception {
        DataModelCreateWebRequest request = new DataModelCreateWebRequest();
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        request.setDescription("");
        DataModelCreateWebResponse response = execute(request, DataModelCreateWebResponse.class, "/dataModel/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型删除Test
     */
    @Test
    public void delete() throws Exception {
        DataModelDeleteWebRequest request = new DataModelDeleteWebRequest();
        request.setId(0L);
        DataModelDeleteWebResponse response = execute(request, DataModelDeleteWebResponse.class, "/dataModel/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型修改Test
     */
    @Test
    public void update() throws Exception {
        DataModelUpdateWebRequest request = new DataModelUpdateWebRequest();
        request.setId(0L);
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        request.setDescription("");
        DataModelUpdateWebResponse response = execute(request, DataModelUpdateWebResponse.class, "/dataModel/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型单个查询Test
     */
    @Test
    public void get() throws Exception {
        DataModelGetWebRequest request = new DataModelGetWebRequest();
        request.setId(0L);
        DataModelGetWebResponse response = execute(request, DataModelGetWebResponse.class, "/dataModel/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型多个查询Test
     */
    @Test
    public void query() throws Exception {
        DataModelQueryWebRequest request = new DataModelQueryWebRequest();
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        DataModelQueryWebResponse response = execute(request, DataModelQueryWebResponse.class, "/dataModel/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型分页查询Test
     */
    @Test
    public void search() throws Exception {
        DataModelSearchWebRequest request = new DataModelSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        DataModelSearchWebResponse response = execute(request, DataModelSearchWebResponse.class, "/dataModel/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型排序Test
     */
    @Test
    public void sort() throws Exception {
        DataModelSortWebRequest request = new DataModelSortWebRequest();
        DataModelSortWebResponse response = execute(request, DataModelSortWebResponse.class, "/dataModel/sort");
        Assert.assertNotNull(response.getBody());
    }

}
package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.DataModelCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSortWebRequest;
import pers.laineyc.blackdream.generator.service.domain.*;

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
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        request.setDescription("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型删除Test
     */
    @Test
    public void delete() throws Exception {
        DataModelDeleteWebRequest request = new DataModelDeleteWebRequest();
        request.setId("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型修改Test
     */
    @Test
    public void update() throws Exception {
        DataModelUpdateWebRequest request = new DataModelUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        request.setDescription("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型单个查询Test
     */
    @Test
    public void get() throws Exception {
        DataModelGetWebRequest request = new DataModelGetWebRequest();
        request.setId("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型多个查询Test
     */
    @Test
    public void query() throws Exception {
        DataModelQueryWebRequest request = new DataModelQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/query");
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
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        request.setCode("");
        request.setIconStyle("");
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型排序Test
     */
    @Test
    public void sort() throws Exception {
        DataModelSortWebRequest request = new DataModelSortWebRequest();
        Response<DataModel> response = execute(request, DataModel.class, "/dataModel/sort");
        Assert.assertNotNull(response.getBody());
    }

}
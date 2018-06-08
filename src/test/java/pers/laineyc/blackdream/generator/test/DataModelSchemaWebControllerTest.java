package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.*;

/**
 * 生成器数据模型模式ControllerTest
 * @author LaineyC
 */
public class DataModelSchemaWebControllerTest extends BaseWebControllerTest {

    public DataModelSchemaWebControllerTest(){

    }

    /**
     * 生成器数据模型模式创建Test
     */
    @Test
    public void create() throws Exception {
        DataModelSchemaCreateWebRequest request = new DataModelSchemaCreateWebRequest();
        request.setGeneratorId("");
        request.setName("");
        request.setDescription("");
        Response<DataModelSchemaCreateWebVo> response = execute(request, DataModelSchemaCreateWebVo.class, "/dataModelSchema/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型模式删除Test
     */
    @Test
    public void delete() throws Exception {
        DataModelSchemaDeleteWebRequest request = new DataModelSchemaDeleteWebRequest();
        request.setId("");
        Response<DataModelSchemaDeleteWebVo> response = execute(request, DataModelSchemaDeleteWebVo.class, "/dataModelSchema/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型模式修改Test
     */
    @Test
    public void update() throws Exception {
        DataModelSchemaUpdateWebRequest request = new DataModelSchemaUpdateWebRequest();
        request.setId("");
        request.setName("");
        request.setDescription("");
        Response<DataModelSchemaUpdateWebVo> response = execute(request, DataModelSchemaUpdateWebVo.class, "/dataModelSchema/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型模式单个查询Test
     */
    @Test
    public void get() throws Exception {
        DataModelSchemaGetWebRequest request = new DataModelSchemaGetWebRequest();
        request.setId("");
        Response<DataModelSchemaGetWebVo> response = execute(request, DataModelSchemaGetWebVo.class, "/dataModelSchema/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型模式多个查询Test
     */
    @Test
    public void query() throws Exception {
        DataModelSchemaQueryWebRequest request = new DataModelSchemaQueryWebRequest();
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<DataModelSchemaSearchWebVo> response = execute(request, DataModelSchemaSearchWebVo.class, "/dataModelSchema/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型模式分页查询Test
     */
    @Test
    public void search() throws Exception {
        DataModelSchemaSearchWebRequest request = new DataModelSchemaSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId("");
        request.setGeneratorId("");
        request.setName("");
        Response<DataModelSchemaSearchWebVo> response = execute(request, DataModelSchemaSearchWebVo.class, "/dataModelSchema/search");
        Assert.assertNotNull(response.getBody());
    }

}
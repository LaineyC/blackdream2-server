package pers.laineyc.blackdream.generator.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.request.DataModelSchemaSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.DataModelSchemaSearchWebResponse;
import java.util.Date; 

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
        request.setGeneratorId(0L);
        request.setName("");
        request.setDescription("");
        DataModelSchemaCreateWebResponse response = execute(request, DataModelSchemaCreateWebResponse.class, "/dataModelSchema/create");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型模式删除Test
     */
    @Test
    public void delete() throws Exception {
        DataModelSchemaDeleteWebRequest request = new DataModelSchemaDeleteWebRequest();
        request.setId(0L);
        DataModelSchemaDeleteWebResponse response = execute(request, DataModelSchemaDeleteWebResponse.class, "/dataModelSchema/delete");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型模式修改Test
     */
    @Test
    public void update() throws Exception {
        DataModelSchemaUpdateWebRequest request = new DataModelSchemaUpdateWebRequest();
        request.setId(0L);
        request.setName("");
        request.setDescription("");
        DataModelSchemaUpdateWebResponse response = execute(request, DataModelSchemaUpdateWebResponse.class, "/dataModelSchema/update");
        Assert.assertNotNull(response.getBody());
    }
    
    /**
     * 生成器数据模型模式单个查询Test
     */
    @Test
    public void get() throws Exception {
        DataModelSchemaGetWebRequest request = new DataModelSchemaGetWebRequest();
        request.setId(0L);
        DataModelSchemaGetWebResponse response = execute(request, DataModelSchemaGetWebResponse.class, "/dataModelSchema/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 生成器数据模型模式多个查询Test
     */
    @Test
    public void query() throws Exception {
        DataModelSchemaQueryWebRequest request = new DataModelSchemaQueryWebRequest();
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        DataModelSchemaQueryWebResponse response = execute(request, DataModelSchemaQueryWebResponse.class, "/dataModelSchema/query");
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
        request.setUserId(0L);
        request.setGeneratorId(0L);
        request.setName("");
        DataModelSchemaSearchWebResponse response = execute(request, DataModelSchemaSearchWebResponse.class, "/dataModelSchema/search");
        Assert.assertNotNull(response.getBody());
    }

}
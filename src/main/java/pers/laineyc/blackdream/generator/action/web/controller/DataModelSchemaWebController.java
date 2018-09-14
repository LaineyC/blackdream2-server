package pers.laineyc.blackdream.generator.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchema;
import pers.laineyc.blackdream.generator.service.DataModelSchemaService;

/**
 * 生成器数据模型模式Controller
 * @author LaineyC
 */
@Api(tags = "DataModelSchema", description = "生成器数据模型模式接口")
@Controller
public class DataModelSchemaWebController extends BaseWebController {

    @Autowired
    private DataModelSchemaService dataModelSchemaService;
    
    public DataModelSchemaWebController() {

    }
/*
    @Security
    @ApiOperation(value = "生成器数据模型模式创建")
    @PostMapping(value = "/dataModelSchema/create")
    public @ResponseBody Response<DataModelSchema> create(@RequestBody DataModelSchemaCreateWebRequest request) {
        DataModelSchemaCreateParameter parameter = new DataModelSchemaCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.create(parameter);

        return new Response<>(dataModelSchema);
    }

    @ApiOperation(value = "生成器数据模型模式删除")
    @PostMapping(value = "/dataModelSchema/delete")
    public @ResponseBody Response<DataModelSchema> delete(@RequestBody DataModelSchemaDeleteWebRequest request) {
        DataModelSchemaDeleteParameter parameter = new DataModelSchemaDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.delete(parameter);

        return new Response<>(dataModelSchema);
    }

    @Security
    @ApiOperation(value = "生成器数据模型模式修改")
    @PostMapping(value = "/dataModelSchema/update")
    public @ResponseBody Response<DataModelSchema> update(@RequestBody DataModelSchemaUpdateWebRequest request) {
        DataModelSchemaUpdateParameter parameter = new DataModelSchemaUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.update(parameter);

        return new Response<>(dataModelSchema);
    }
*/
    @ApiOperation(value = "生成器数据模型模式单个查询")
    @PostMapping(value = "/dataModelSchema/get")
    public @ResponseBody Response<DataModelSchema> get(@RequestBody DataModelSchemaGetWebRequest request) {
        DataModelSchemaGetParameter parameter = new DataModelSchemaGetParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.get(parameter);
        
        return new Response<>(dataModelSchema);
    }
/*
    @ApiOperation(value="生成器数据模型模式多个查询")
    @PostMapping(value = "/dataModelSchema/query")
    public @ResponseBody Response<List<DataModelSchema>> query(@RequestBody DataModelSchemaQueryWebRequest request) {
        DataModelSchemaQueryParameter parameter = new DataModelSchemaQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<DataModelSchema> dataModelSchemaList = dataModelSchemaService.query(parameter);

        return new Response<>(dataModelSchemaList);
    }

    @ApiOperation(value = "生成器数据模型模式分页查询")
    @PostMapping(value = "/dataModelSchema/search")
    public @ResponseBody Response<PageResult<DataModelSchema>> search(@RequestBody DataModelSchemaSearchWebRequest request) {
        DataModelSchemaSearchParameter parameter = new DataModelSchemaSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<DataModelSchema> dataModelSchemaPageResult = dataModelSchemaService.search(parameter);

        return new Response<>(dataModelSchemaPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型模式保存")
    @PostMapping(value = "/dataModelSchema/save")
    public @ResponseBody Response<DataModelSchema> save(@RequestBody DataModelSchemaSaveWebRequest request) {
        DataModelSchemaSaveParameter parameter = new DataModelSchemaSaveParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.save(parameter);

        return new Response<>(dataModelSchema);
    }

}

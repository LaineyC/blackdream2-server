package pers.laineyc.blackdream.generator.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.action.web.response.*;
import pers.laineyc.blackdream.generator.action.web.vo.*;
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
    public @ResponseBody DataModelSchemaCreateWebResponse create(@RequestBody DataModelSchemaCreateWebRequest request) {
        DataModelSchemaCreateParameter parameter = new DataModelSchemaCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.create(parameter);

        DataModelSchemaCreateWebVo dataModelSchemaCreateWebVo = new DataModelSchemaCreateWebVo();
        BeanUtils.copyProperties(dataModelSchema, dataModelSchemaCreateWebVo);

        return new DataModelSchemaCreateWebResponse(dataModelSchemaCreateWebVo);
    }

    @ApiOperation(value = "生成器数据模型模式删除")
    @PostMapping(value = "/dataModelSchema/delete")
    public @ResponseBody DataModelSchemaDeleteWebResponse delete(@RequestBody DataModelSchemaDeleteWebRequest request) {
        DataModelSchemaDeleteParameter parameter = new DataModelSchemaDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.delete(parameter);

        DataModelSchemaDeleteWebVo dataModelSchemaDeleteWebVo = new DataModelSchemaDeleteWebVo();
        BeanUtils.copyProperties(dataModelSchema, dataModelSchemaDeleteWebVo);

        return new DataModelSchemaDeleteWebResponse(dataModelSchemaDeleteWebVo);
    }

    @Security
    @ApiOperation(value = "生成器数据模型模式修改")
    @PostMapping(value = "/dataModelSchema/update")
    public @ResponseBody DataModelSchemaUpdateWebResponse update(@RequestBody DataModelSchemaUpdateWebRequest request) {
        DataModelSchemaUpdateParameter parameter = new DataModelSchemaUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.update(parameter);
        
        DataModelSchemaUpdateWebVo dataModelSchemaUpdateWebVo = new DataModelSchemaUpdateWebVo();
        BeanUtils.copyProperties(dataModelSchema, dataModelSchemaUpdateWebVo);

        return new DataModelSchemaUpdateWebResponse(dataModelSchemaUpdateWebVo);
    }
*/
    @ApiOperation(value = "生成器数据模型模式单个查询")
    @PostMapping(value = "/dataModelSchema/get")
    public @ResponseBody DataModelSchemaGetWebResponse get(@RequestBody DataModelSchemaGetWebRequest request) {
        DataModelSchemaGetParameter parameter = new DataModelSchemaGetParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.get(parameter);

        DataModelSchemaGetWebVo dataModelSchemaGetWebVo = null;
        if(dataModelSchema != null){
            dataModelSchemaGetWebVo = new DataModelSchemaGetWebVo();
            BeanUtils.copyProperties(dataModelSchema, dataModelSchemaGetWebVo);
        }
        
        return new DataModelSchemaGetWebResponse(dataModelSchemaGetWebVo);
    }
/*
    @ApiOperation(value="生成器数据模型模式多个查询")
    @PostMapping(value = "/dataModelSchema/query")
    public @ResponseBody DataModelSchemaQueryWebResponse query(@RequestBody DataModelSchemaQueryWebRequest request) {
        DataModelSchemaQueryParameter parameter = new DataModelSchemaQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<DataModelSchema> dataModelSchemaList = dataModelSchemaService.query(parameter);
        
        List<DataModelSchemaQueryWebVo> dataModelSchemaQueryWebVoList = new ArrayList<>();
        dataModelSchemaList.forEach(dataModelSchema -> {
            DataModelSchemaQueryWebVo dataModelSchemaQueryWebVo = new DataModelSchemaQueryWebVo();
            BeanUtils.copyProperties(dataModelSchema, dataModelSchemaQueryWebVo);
            dataModelSchemaQueryWebVoList.add(dataModelSchemaQueryWebVo);
        });

        return new DataModelSchemaQueryWebResponse(dataModelSchemaQueryWebVoList);
    }

    @ApiOperation(value = "生成器数据模型模式分页查询")
    @PostMapping(value = "/dataModelSchema/search")
    public @ResponseBody DataModelSchemaSearchWebResponse search(@RequestBody DataModelSchemaSearchWebRequest request) {
        DataModelSchemaSearchParameter parameter = new DataModelSchemaSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<DataModelSchema> dataModelSchemaPageResult = dataModelSchemaService.search(parameter);
        
        PageResult<DataModelSchemaSearchWebVo> dataModelSchemaSearchWebVoPageResult = new PageResult<>();
        dataModelSchemaSearchWebVoPageResult.setTotal(dataModelSchemaPageResult.getTotal());
        List<DataModelSchemaSearchWebVo> dataModelSchemaSearchWebVoList = dataModelSchemaSearchWebVoPageResult.getRecords();
        dataModelSchemaPageResult.getRecords().forEach(dataModelSchema -> {
            DataModelSchemaSearchWebVo dataModelSchemaSearchWebVo = new DataModelSchemaSearchWebVo();
            BeanUtils.copyProperties(dataModelSchema, dataModelSchemaSearchWebVo);
            dataModelSchemaSearchWebVoList.add(dataModelSchemaSearchWebVo);
        });

        return new DataModelSchemaSearchWebResponse(dataModelSchemaSearchWebVoPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型模式保存")
    @PostMapping(value = "/dataModelSchema/save")
    public @ResponseBody DataModelSchemaSaveWebResponse save(@RequestBody DataModelSchemaSaveWebRequest request) {
        DataModelSchemaSaveParameter parameter = new DataModelSchemaSaveParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModelSchema dataModelSchema = dataModelSchemaService.save(parameter);

        DataModelSchemaSaveWebVo dataModelSchemaSaveWebVo = new DataModelSchemaSaveWebVo();
        BeanUtils.copyProperties(dataModelSchema, dataModelSchemaSaveWebVo);

        return new DataModelSchemaSaveWebResponse(dataModelSchemaSaveWebVo);
    }

}

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
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import pers.laineyc.blackdream.generator.service.DataModelService;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器数据模型Controller
 * @author LaineyC
 */
@Api(tags = "DataModel", description = "生成器数据模型接口")
@Controller
public class DataModelWebController extends BaseWebController {

    @Autowired
    private DataModelService dataModelService;
    
    public DataModelWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型创建")
    @PostMapping(value = "/dataModel/create")
    public @ResponseBody Response<DataModel> create(@RequestBody DataModelCreateWebRequest request) {
        DataModelCreateParameter parameter = new DataModelCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.create(parameter);

        return new Response<>(dataModel);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型删除")
    @PostMapping(value = "/dataModel/delete")
    public @ResponseBody Response<DataModel> delete(@RequestBody DataModelDeleteWebRequest request) {
        DataModelDeleteParameter parameter = new DataModelDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.delete(parameter);

        return new Response<>(dataModel);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型修改")
    @PostMapping(value = "/dataModel/update")
    public @ResponseBody Response<DataModel> update(@RequestBody DataModelUpdateWebRequest request) {
        DataModelUpdateParameter parameter = new DataModelUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.update(parameter);

        return new Response<>(dataModel);
    }

    @ApiOperation(value = "生成器数据模型单个查询")
    @PostMapping(value = "/dataModel/get")
    public @ResponseBody Response<DataModel> get(@RequestBody DataModelGetWebRequest request) {
        DataModelGetParameter parameter = new DataModelGetParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.get(parameter);
        
        return new Response<>(dataModel);
    }
/*
    @ApiOperation(value="生成器数据模型多个查询")
    @PostMapping(value = "/dataModel/query")
    public @ResponseBody Response<List<DataModel>> query(@RequestBody DataModelQueryWebRequest request) {
        DataModelQueryParameter parameter = new DataModelQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<DataModel> dataModelList = dataModelService.query(parameter);

        return new Response<>(dataModelList);
    }

    @ApiOperation(value = "生成器数据模型分页查询")
    @PostMapping(value = "/dataModel/search")
    public @ResponseBody Response<PageResult<DataModel>> search(@RequestBody DataModelSearchWebRequest request) {
        DataModelSearchParameter parameter = new DataModelSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<DataModel> dataModelPageResult = dataModelService.search(parameter);

        return new Response<>(dataModelPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型排序")
    @PostMapping(value = "/dataModel/sort")
    public @ResponseBody Response<DataModel> sort(@RequestBody DataModelSortWebRequest request) {
        DataModelSortParameter parameter = new DataModelSortParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.sort(parameter);

        return new Response<>(dataModel);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据模型多个查询")
    @PostMapping(value = "/dataModel/infoQuery")
    public @ResponseBody Response<List<DataModel>> infoQuery(@RequestBody DataModelInfoQueryWebRequest request) {
        DataModelInfoQueryParameter parameter = new DataModelInfoQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<DataModel> dataModelList = dataModelService.infoQuery(parameter);

        return new Response<>(dataModelList);
    }
    
}

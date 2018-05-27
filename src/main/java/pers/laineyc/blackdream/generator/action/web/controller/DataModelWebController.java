package pers.laineyc.blackdream.generator.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.Security;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.action.web.response.*;
import pers.laineyc.blackdream.generator.action.web.vo.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import pers.laineyc.blackdream.generator.service.DataModelService;
import java.util.List;
import java.util.ArrayList;

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

    @Security
    @ApiOperation(value = "生成器数据模型创建")
    @PostMapping(value = "/dataModel/create")
    public @ResponseBody DataModelCreateWebResponse create(@RequestBody DataModelCreateWebRequest request) {
        DataModelCreateParameter parameter = new DataModelCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.create(parameter);

        DataModelCreateWebVo dataModelCreateWebVo = new DataModelCreateWebVo();
        BeanUtils.copyProperties(dataModel, dataModelCreateWebVo);

        return new DataModelCreateWebResponse(dataModelCreateWebVo);
    }

    @Security
    @ApiOperation(value = "生成器数据模型删除")
    @PostMapping(value = "/dataModel/delete")
    public @ResponseBody DataModelDeleteWebResponse delete(@RequestBody DataModelDeleteWebRequest request) {
        DataModelDeleteParameter parameter = new DataModelDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.delete(parameter);

        DataModelDeleteWebVo dataModelDeleteWebVo = new DataModelDeleteWebVo();
        BeanUtils.copyProperties(dataModel, dataModelDeleteWebVo);

        return new DataModelDeleteWebResponse(dataModelDeleteWebVo);
    }

    @Security
    @ApiOperation(value = "生成器数据模型修改")
    @PostMapping(value = "/dataModel/update")
    public @ResponseBody DataModelUpdateWebResponse update(@RequestBody DataModelUpdateWebRequest request) {
        DataModelUpdateParameter parameter = new DataModelUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.update(parameter);
        
        DataModelUpdateWebVo dataModelUpdateWebVo = new DataModelUpdateWebVo();
        BeanUtils.copyProperties(dataModel, dataModelUpdateWebVo);

        return new DataModelUpdateWebResponse(dataModelUpdateWebVo);
    }

    @ApiOperation(value = "生成器数据模型单个查询")
    @PostMapping(value = "/dataModel/get")
    public @ResponseBody DataModelGetWebResponse get(@RequestBody DataModelGetWebRequest request) {
        DataModelGetParameter parameter = new DataModelGetParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.get(parameter);
        
        DataModelGetWebVo dataModelGetWebVo = new DataModelGetWebVo();
        BeanUtils.copyProperties(dataModel, dataModelGetWebVo);
        
        return new DataModelGetWebResponse(dataModelGetWebVo);
    }
/*
    @ApiOperation(value="生成器数据模型多个查询")
    @PostMapping(value = "/dataModel/query")
    public @ResponseBody DataModelQueryWebResponse query(@RequestBody DataModelQueryWebRequest request) {
        DataModelQueryParameter parameter = new DataModelQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<DataModel> dataModelList = dataModelService.query(parameter);
        
        List<DataModelQueryWebVo> dataModelQueryWebVoList = new ArrayList<>();
        dataModelList.forEach(dataModel -> {
            DataModelQueryWebVo dataModelQueryWebVo = new DataModelQueryWebVo();
            BeanUtils.copyProperties(dataModel, dataModelQueryWebVo);
            dataModelQueryWebVoList.add(dataModelQueryWebVo);
        });

        return new DataModelQueryWebResponse(dataModelQueryWebVoList);
    }

    @ApiOperation(value = "生成器数据模型分页查询")
    @PostMapping(value = "/dataModel/search")
    public @ResponseBody DataModelSearchWebResponse search(@RequestBody DataModelSearchWebRequest request) {
        DataModelSearchParameter parameter = new DataModelSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<DataModel> dataModelPageResult = dataModelService.search(parameter);
        
        PageResult<DataModelSearchWebVo> dataModelSearchWebVoPageResult = new PageResult<>();
        dataModelSearchWebVoPageResult.setTotal(dataModelPageResult.getTotal());
        List<DataModelSearchWebVo> dataModelSearchWebVoList = dataModelSearchWebVoPageResult.getRecords();
        dataModelPageResult.getRecords().forEach(dataModel -> {
            DataModelSearchWebVo dataModelSearchWebVo = new DataModelSearchWebVo();
            BeanUtils.copyProperties(dataModel, dataModelSearchWebVo);
            dataModelSearchWebVoList.add(dataModelSearchWebVo);
        });

        return new DataModelSearchWebResponse(dataModelSearchWebVoPageResult);
    }
*/
    @Security
    @ApiOperation(value = "生成器数据模型排序")
    @PostMapping(value = "/dataModel/sort")
    public @ResponseBody DataModelSortWebResponse sort(@RequestBody DataModelSortWebRequest request) {
        DataModelSortParameter parameter = new DataModelSortParameter();
        BeanUtils.copyProperties(request, parameter);

        DataModel dataModel = dataModelService.sort(parameter);

        DataModelSortWebVo dataModelSortWebVo = new DataModelSortWebVo();
        BeanUtils.copyProperties(dataModel, dataModelSortWebVo);

        return new DataModelSortWebResponse(dataModelSortWebVo);
    }

    @Security
    @ApiOperation(value = "生成器数据模型分页查询")
    @PostMapping(value = "/dataModel/infoSearch")
    public @ResponseBody DataModelInfoSearchWebResponse infoSearch(@RequestBody DataModelInfoSearchWebRequest request) {
        DataModelInfoSearchParameter parameter = new DataModelInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<DataModel> dataModelPageResult = dataModelService.infoSearch(parameter);

        PageResult<DataModelInfoSearchWebVo> dataModelSearchWebVoPageResult = new PageResult<>();
        dataModelSearchWebVoPageResult.setTotal(dataModelPageResult.getTotal());
        List<DataModelInfoSearchWebVo> dataModelSearchWebVoList = dataModelSearchWebVoPageResult.getRecords();
        dataModelPageResult.getRecords().forEach(dataModel -> {
            DataModelInfoSearchWebVo dataModelSearchWebVo = new DataModelInfoSearchWebVo();
            BeanUtils.copyProperties(dataModel, dataModelSearchWebVo);
            dataModelSearchWebVoList.add(dataModelSearchWebVo);
        });

        return new DataModelInfoSearchWebResponse(dataModelSearchWebVoPageResult);
    }
    
}

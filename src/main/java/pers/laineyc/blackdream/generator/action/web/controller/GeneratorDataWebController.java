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
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataCreateWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataDeleteWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataUpdateWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataGetWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataTreeWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataTreeWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataTreeWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataSortWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorDataSortWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDataSortWebVo;
import pers.laineyc.blackdream.generator.service.domain.GeneratorData;
import pers.laineyc.blackdream.generator.service.GeneratorDataService;
import java.util.List;
import java.util.ArrayList;

/**
 * 生成器数据Controller
 * @author LaineyC
 */
@Api(tags = "GeneratorData", description = "生成器数据接口")
@Controller
public class GeneratorDataWebController extends BaseWebController {

    @Autowired
    private GeneratorDataService generatorDataService;
    
    public GeneratorDataWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据创建")
    @PostMapping(value = "/generatorData/create")
    public @ResponseBody GeneratorDataCreateWebResponse create(@RequestBody GeneratorDataCreateWebRequest request) {
        GeneratorDataCreateParameter parameter = new GeneratorDataCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.create(parameter);

        GeneratorDataCreateWebVo generatorDataCreateWebVo = new GeneratorDataCreateWebVo();
        BeanUtils.copyProperties(generatorData, generatorDataCreateWebVo);

        return new GeneratorDataCreateWebResponse(generatorDataCreateWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据删除")
    @PostMapping(value = "/generatorData/delete")
    public @ResponseBody GeneratorDataDeleteWebResponse delete(@RequestBody GeneratorDataDeleteWebRequest request) {
        GeneratorDataDeleteParameter parameter = new GeneratorDataDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.delete(parameter);

        GeneratorDataDeleteWebVo generatorDataDeleteWebVo = new GeneratorDataDeleteWebVo();
        BeanUtils.copyProperties(generatorData, generatorDataDeleteWebVo);

        return new GeneratorDataDeleteWebResponse(generatorDataDeleteWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据修改")
    @PostMapping(value = "/generatorData/update")
    public @ResponseBody GeneratorDataUpdateWebResponse update(@RequestBody GeneratorDataUpdateWebRequest request) {
        GeneratorDataUpdateParameter parameter = new GeneratorDataUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.update(parameter);
        
        GeneratorDataUpdateWebVo generatorDataUpdateWebVo = new GeneratorDataUpdateWebVo();
        BeanUtils.copyProperties(generatorData, generatorDataUpdateWebVo);

        return new GeneratorDataUpdateWebResponse(generatorDataUpdateWebVo);
    }

    @ApiOperation(value = "生成器数据单个查询")
    @PostMapping(value = "/generatorData/get")
    public @ResponseBody GeneratorDataGetWebResponse get(@RequestBody GeneratorDataGetWebRequest request) {
        GeneratorDataGetParameter parameter = new GeneratorDataGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.get(parameter);
        
        GeneratorDataGetWebVo generatorDataGetWebVo = new GeneratorDataGetWebVo();
        BeanUtils.copyProperties(generatorData, generatorDataGetWebVo);
        
        return new GeneratorDataGetWebResponse(generatorDataGetWebVo);
    }
/*
    @ApiOperation(value="生成器数据多个查询")
    @PostMapping(value = "/generatorData/query")
    public @ResponseBody GeneratorDataQueryWebResponse query(@RequestBody GeneratorDataQueryWebRequest request) {
        GeneratorDataQueryParameter parameter = new GeneratorDataQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<GeneratorData> generatorDataList = generatorDataService.query(parameter);

        List<GeneratorDataQueryWebVo> generatorDataQueryWebVoList = new ArrayList<>();
        generatorDataList.forEach(generatorData -> {
            GeneratorDataQueryWebVo generatorDataQueryWebVo = new GeneratorDataQueryWebVo();
            BeanUtils.copyProperties(generatorData, generatorDataQueryWebVo);
            generatorDataQueryWebVoList.add(generatorDataQueryWebVo);
        });

        return new GeneratorDataQueryWebResponse(generatorDataQueryWebVoList);
    }

    @ApiOperation(value = "生成器数据分页查询")
    @PostMapping(value = "/generatorData/search")
    public @ResponseBody GeneratorDataSearchWebResponse search(@RequestBody GeneratorDataSearchWebRequest request) {
        GeneratorDataSearchParameter parameter = new GeneratorDataSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<GeneratorData> generatorDataPageResult = generatorDataService.search(parameter);

        PageResult<GeneratorDataSearchWebVo> generatorDataSearchWebVoPageResult = new PageResult<>();
        generatorDataSearchWebVoPageResult.setTotal(generatorDataPageResult.getTotal());
        List<GeneratorDataSearchWebVo> generatorDataSearchWebVoList = generatorDataSearchWebVoPageResult.getRecords();
        generatorDataPageResult.getRecords().forEach(generatorData -> {
            GeneratorDataSearchWebVo generatorDataSearchWebVo = new GeneratorDataSearchWebVo();
            BeanUtils.copyProperties(generatorData, generatorDataSearchWebVo);
            generatorDataSearchWebVoList.add(generatorDataSearchWebVo);
        });

        return new GeneratorDataSearchWebResponse(generatorDataSearchWebVoPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据树形查询")
    @PostMapping(value = "/generatorData/tree")
    public @ResponseBody GeneratorDataTreeWebResponse tree(@RequestBody GeneratorDataTreeWebRequest request) {
        GeneratorDataTreeParameter parameter = new GeneratorDataTreeParameter();
        BeanUtils.copyProperties(request, parameter);

        List<GeneratorData> generatorDataList = generatorDataService.tree(parameter);
        
        List<GeneratorDataTreeWebVo> generatorDataTreeWebVoList = new ArrayList<>();

        return new GeneratorDataTreeWebResponse(generatorDataTreeWebVoList);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据排序")
    @PostMapping(value = "/generatorData/sort")
    public @ResponseBody GeneratorDataSortWebResponse sort(@RequestBody GeneratorDataSortWebRequest request) {
        GeneratorDataSortParameter parameter = new GeneratorDataSortParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.sort(parameter);

        GeneratorDataSortWebVo generatorDataSortWebVo = new GeneratorDataSortWebVo();
        BeanUtils.copyProperties(generatorData, generatorDataSortWebVo);

        return new GeneratorDataSortWebResponse(generatorDataSortWebVo);
    }
    
}

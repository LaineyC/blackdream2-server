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
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataCreateWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataDeleteWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataUpdateWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataGetWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataTreeWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDataSortWebRequest;
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
    public @ResponseBody Response<GeneratorData> create(@RequestBody GeneratorDataCreateWebRequest request) {
        GeneratorDataCreateParameter parameter = new GeneratorDataCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.create(parameter);

        return new Response<>(generatorData);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据删除")
    @PostMapping(value = "/generatorData/delete")
    public @ResponseBody Response<GeneratorData> delete(@RequestBody GeneratorDataDeleteWebRequest request) {
        GeneratorDataDeleteParameter parameter = new GeneratorDataDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.delete(parameter);

        return new Response<>(generatorData);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据修改")
    @PostMapping(value = "/generatorData/update")
    public @ResponseBody Response<GeneratorData> update(@RequestBody GeneratorDataUpdateWebRequest request) {
        GeneratorDataUpdateParameter parameter = new GeneratorDataUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.update(parameter);

        return new Response<>(generatorData);
    }

    @ApiOperation(value = "生成器数据单个查询")
    @PostMapping(value = "/generatorData/get")
    public @ResponseBody Response<GeneratorData> get(@RequestBody GeneratorDataGetWebRequest request) {
        GeneratorDataGetParameter parameter = new GeneratorDataGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.get(parameter);
        
        return new Response<>(generatorData);
    }
/*
    @ApiOperation(value="生成器数据多个查询")
    @PostMapping(value = "/generatorData/query")
    public @ResponseBody Response<List<GeneratorData>> query(@RequestBody GeneratorDataQueryWebRequest request) {
        GeneratorDataQueryParameter parameter = new GeneratorDataQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<GeneratorData> generatorDataList = generatorDataService.query(parameter);

        return new Response<>(generatorDataList);
    }

    @ApiOperation(value = "生成器数据分页查询")
    @PostMapping(value = "/generatorData/search")
    public @ResponseBody Response<PageResult<GeneratorData>> search(@RequestBody GeneratorDataSearchWebRequest request) {
        GeneratorDataSearchParameter parameter = new GeneratorDataSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<GeneratorData> generatorDataPageResult = generatorDataService.search(parameter);

        return new Response<>(generatorDataPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据树形查询")
    @PostMapping(value = "/generatorData/tree")
    public @ResponseBody Response<List<GeneratorData>> tree(@RequestBody GeneratorDataTreeWebRequest request) {
        GeneratorDataTreeParameter parameter = new GeneratorDataTreeParameter();
        BeanUtils.copyProperties(request, parameter);

        List<GeneratorData> generatorDataList = generatorDataService.tree(parameter);

        return new Response<>(generatorDataList);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器数据排序")
    @PostMapping(value = "/generatorData/sort")
    public @ResponseBody Response<GeneratorData> sort(@RequestBody GeneratorDataSortWebRequest request) {
        GeneratorDataSortParameter parameter = new GeneratorDataSortParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorData generatorData = generatorDataService.sort(parameter);

        return new Response<>(generatorData);
    }
    
}

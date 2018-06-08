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
import pers.laineyc.blackdream.generator.action.web.vo.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceService;
import java.util.List;

/**
 * 生成器实例Controller
 * @author LaineyC
 */
@Api(tags = "GeneratorInstance", description = "生成器实例接口")
@Controller
public class GeneratorInstanceWebController extends BaseWebController {

    @Autowired
    private GeneratorInstanceService generatorInstanceService;
    
    public GeneratorInstanceWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例创建")
    @PostMapping(value = "/generatorInstance/create")
    public @ResponseBody Response<GeneratorInstanceCreateWebVo> create(@RequestBody GeneratorInstanceCreateWebRequest request) {
        GeneratorInstanceCreateParameter parameter = new GeneratorInstanceCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.create(parameter);

        GeneratorInstanceCreateWebVo generatorInstanceCreateWebVo = new GeneratorInstanceCreateWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceCreateWebVo);

        return new Response<>(generatorInstanceCreateWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例删除")
    @PostMapping(value = "/generatorInstance/delete")
    public @ResponseBody Response<GeneratorInstanceDeleteWebVo> delete(@RequestBody GeneratorInstanceDeleteWebRequest request) {
        GeneratorInstanceDeleteParameter parameter = new GeneratorInstanceDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.delete(parameter);

        GeneratorInstanceDeleteWebVo generatorInstanceDeleteWebVo = new GeneratorInstanceDeleteWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceDeleteWebVo);

        return new Response<>(generatorInstanceDeleteWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例修改")
    @PostMapping(value = "/generatorInstance/update")
    public @ResponseBody Response<GeneratorInstanceUpdateWebVo> update(@RequestBody GeneratorInstanceUpdateWebRequest request) {
        GeneratorInstanceUpdateParameter parameter = new GeneratorInstanceUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.update(parameter);
        
        GeneratorInstanceUpdateWebVo generatorInstanceUpdateWebVo = new GeneratorInstanceUpdateWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceUpdateWebVo);

        return new Response<>(generatorInstanceUpdateWebVo);
    }

    @ApiOperation(value = "生成器实例单个查询")
    @PostMapping(value = "/generatorInstance/get")
    public @ResponseBody Response<GeneratorInstanceGetWebVo> get(@RequestBody GeneratorInstanceGetWebRequest request) {
        GeneratorInstanceGetParameter parameter = new GeneratorInstanceGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.get(parameter);
        
        GeneratorInstanceGetWebVo generatorInstanceGetWebVo = new GeneratorInstanceGetWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceGetWebVo);
        
        return new Response<>(generatorInstanceGetWebVo);
    }
/*
    @ApiOperation(value="生成器实例多个查询")
    @PostMapping(value = "/generatorInstance/query")
    public @ResponseBody Response<List<GeneratorInstanceQueryWebVo>> query(@RequestBody GeneratorInstanceQueryWebRequest request) {
        GeneratorInstanceQueryParameter parameter = new GeneratorInstanceQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorInstance> generatorInstanceList = generatorInstanceService.query(parameter);
        
        List<GeneratorInstanceQueryWebVo> generatorInstanceQueryWebVoList = new ArrayList<>();
        generatorInstanceList.forEach(generatorInstance -> {
            GeneratorInstanceQueryWebVo generatorInstanceQueryWebVo = new GeneratorInstanceQueryWebVo();
            BeanUtils.copyProperties(generatorInstance, generatorInstanceQueryWebVo);
            generatorInstanceQueryWebVoList.add(generatorInstanceQueryWebVo);
        });

        return new Response<>(generatorInstanceQueryWebVoList);
    }

    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/search")
    public @ResponseBody Response<PageResult<GeneratorInstanceSearchWebVo>> search(@RequestBody GeneratorInstanceSearchWebRequest request) {
        GeneratorInstanceSearchParameter parameter = new GeneratorInstanceSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<GeneratorInstance> generatorInstancePageResult = generatorInstanceService.search(parameter);
        
        PageResult<GeneratorInstanceSearchWebVo> generatorInstanceSearchWebVoPageResult = new PageResult<>();
        generatorInstanceSearchWebVoPageResult.setTotal(generatorInstancePageResult.getTotal());
        List<GeneratorInstanceSearchWebVo> generatorInstanceSearchWebVoList = generatorInstanceSearchWebVoPageResult.getRecords();
        generatorInstancePageResult.getRecords().forEach(generatorInstance -> {
            GeneratorInstanceSearchWebVo generatorInstanceSearchWebVo = new GeneratorInstanceSearchWebVo();
            BeanUtils.copyProperties(generatorInstance, generatorInstanceSearchWebVo);
            generatorInstanceSearchWebVoList.add(generatorInstanceSearchWebVo);
        });

        return new Response<>(generatorInstanceSearchWebVoPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/infoSearch")
    public @ResponseBody Response<PageResult<GeneratorInstanceInfoSearchWebVo>> infoSearch(@RequestBody GeneratorInstanceInfoSearchWebRequest request) {
        GeneratorInstanceInfoSearchParameter parameter = new GeneratorInstanceInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<GeneratorInstance> generatorInstancePageResult = generatorInstanceService.infoSearch(parameter);

        PageResult<GeneratorInstanceInfoSearchWebVo> generatorInstanceSearchWebVoPageResult = new PageResult<>();
        generatorInstanceSearchWebVoPageResult.setTotal(generatorInstancePageResult.getTotal());
        List<GeneratorInstanceInfoSearchWebVo> generatorInstanceSearchWebVoList = generatorInstanceSearchWebVoPageResult.getRecords();
        generatorInstancePageResult.getRecords().forEach(generatorInstance -> {
            GeneratorInstanceInfoSearchWebVo generatorInstanceSearchWebVo = new GeneratorInstanceInfoSearchWebVo();
            BeanUtils.copyProperties(generatorInstance, generatorInstanceSearchWebVo);
            generatorInstanceSearchWebVoList.add(generatorInstanceSearchWebVo);
        });

        return new Response<>(generatorInstanceSearchWebVoPageResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例生成")
    @PostMapping(value = "/generatorInstance/make")
    public @ResponseBody Response<GeneratorInstanceMakeWebVo> make(@RequestBody GeneratorInstanceMakeWebRequest request) {
        GeneratorInstanceMakeParameter parameter = new GeneratorInstanceMakeParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.make(parameter);

        GeneratorInstanceMakeWebVo generatorInstanceMakeWebVo = new GeneratorInstanceMakeWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceMakeWebVo);

        return new Response<>(generatorInstanceMakeWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例生成测试")
    @PostMapping(value = "/generatorInstance/makeTest")
    public @ResponseBody Response<GeneratorInstanceMakeTestWebVo> makeTest(@RequestBody GeneratorInstanceMakeTestWebRequest request) {
        GeneratorInstanceMakeTestParameter parameter = new GeneratorInstanceMakeTestParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.makeTest(parameter);

        GeneratorInstanceMakeTestWebVo generatorInstanceMakeTestWebVo = new GeneratorInstanceMakeTestWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceMakeTestWebVo);

        return new Response<>(generatorInstanceMakeTestWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例版本同步")
    @PostMapping(value = "/generatorInstance/versionSync")
    public @ResponseBody Response<GeneratorInstanceVersionSyncWebVo> versionSync(@RequestBody GeneratorInstanceVersionSyncWebRequest request) {
        GeneratorInstanceVersionSyncParameter parameter = new GeneratorInstanceVersionSyncParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.versionSync(parameter);

        GeneratorInstanceVersionSyncWebVo generatorInstanceVersionSyncWebVo = new GeneratorInstanceVersionSyncWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceVersionSyncWebVo);

        return new Response<>(generatorInstanceVersionSyncWebVo);
    }
    
}

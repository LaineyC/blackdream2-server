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
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceMakeResult;
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
    public @ResponseBody Response<GeneratorInstance> create(@RequestBody GeneratorInstanceCreateWebRequest request) {
        GeneratorInstanceCreateParameter parameter = new GeneratorInstanceCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.create(parameter);

        return new Response<>(generatorInstance);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例删除")
    @PostMapping(value = "/generatorInstance/delete")
    public @ResponseBody Response<GeneratorInstance> delete(@RequestBody GeneratorInstanceDeleteWebRequest request) {
        GeneratorInstanceDeleteParameter parameter = new GeneratorInstanceDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.delete(parameter);

        return new Response<>(generatorInstance);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例修改")
    @PostMapping(value = "/generatorInstance/update")
    public @ResponseBody Response<GeneratorInstance> update(@RequestBody GeneratorInstanceUpdateWebRequest request) {
        GeneratorInstanceUpdateParameter parameter = new GeneratorInstanceUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.update(parameter);

        return new Response<>(generatorInstance);
    }

    @ApiOperation(value = "生成器实例单个查询")
    @PostMapping(value = "/generatorInstance/get")
    public @ResponseBody Response<GeneratorInstance> get(@RequestBody GeneratorInstanceGetWebRequest request) {
        GeneratorInstanceGetParameter parameter = new GeneratorInstanceGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.get(parameter);
        
        return new Response<>(generatorInstance);
    }
/*
    @ApiOperation(value="生成器实例多个查询")
    @PostMapping(value = "/generatorInstance/query")
    public @ResponseBody Response<List<GeneratorInstance>> query(@RequestBody GeneratorInstanceQueryWebRequest request) {
        GeneratorInstanceQueryParameter parameter = new GeneratorInstanceQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorInstance> generatorInstanceList = generatorInstanceService.query(parameter);

        return new Response<>(generatorInstanceList);
    }

    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/search")
    public @ResponseBody Response<PageResult<GeneratorInstance>> search(@RequestBody GeneratorInstanceSearchWebRequest request) {
        GeneratorInstanceSearchParameter parameter = new GeneratorInstanceSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<GeneratorInstance> generatorInstancePageResult = generatorInstanceService.search(parameter);

        return new Response<>(generatorInstancePageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/infoSearch")
    public @ResponseBody Response<PageResult<GeneratorInstance>> infoSearch(@RequestBody GeneratorInstanceInfoSearchWebRequest request) {
        GeneratorInstanceInfoSearchParameter parameter = new GeneratorInstanceInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<GeneratorInstance> generatorInstancePageResult = generatorInstanceService.infoSearch(parameter);

        return new Response<>(generatorInstancePageResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例生成")
    @PostMapping(value = "/generatorInstance/make")
    public @ResponseBody Response<GeneratorInstanceMakeResult> make(@RequestBody GeneratorInstanceMakeWebRequest request) {
        GeneratorInstanceMakeParameter parameter = new GeneratorInstanceMakeParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceMakeResult generatorInstanceMakeResult = generatorInstanceService.make(parameter);

        return new Response<>(generatorInstanceMakeResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例生成测试")
    @PostMapping(value = "/generatorInstance/makeTest")
    public @ResponseBody Response<GeneratorInstanceMakeResult> makeTest(@RequestBody GeneratorInstanceMakeTestWebRequest request) {
        GeneratorInstanceMakeTestParameter parameter = new GeneratorInstanceMakeTestParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceMakeResult generatorInstanceMakeResult = generatorInstanceService.makeTest(parameter);

        return new Response<>(generatorInstanceMakeResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例版本同步")
    @PostMapping(value = "/generatorInstance/versionSync")
    public @ResponseBody Response<GeneratorInstance> versionSync(@RequestBody GeneratorInstanceVersionSyncWebRequest request) {
        GeneratorInstanceVersionSyncParameter parameter = new GeneratorInstanceVersionSyncParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.versionSync(parameter);

        return new Response<>(generatorInstance);
    }
    
}

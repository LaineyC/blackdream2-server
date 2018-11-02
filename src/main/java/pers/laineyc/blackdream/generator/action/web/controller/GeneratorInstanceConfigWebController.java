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
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceConfigService;

/**
 * 生成器实例设置Controller
 * @author LaineyC
 */
@Api(tags = "GeneratorInstanceConfig", description = "生成器实例设置接口")
@Controller
public class GeneratorInstanceConfigWebController extends BaseWebController {

    @Autowired
    private GeneratorInstanceConfigService generatorInstanceConfigService;
    
    public GeneratorInstanceConfigWebController() {

    }
/*
    @Security
    @ApiOperation(value = "生成器实例设置创建")
    @PostMapping(value = "/generatorInstanceConfig/create")
    public @ResponseBody Response<GeneratorInstanceConfig> create(@RequestBody GeneratorInstanceConfigCreateWebRequest request) {
        GeneratorInstanceConfigCreateParameter parameter = new GeneratorInstanceConfigCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.create(parameter);

        return new Response<>(generatorInstanceConfig);
    }

    @Security
    @ApiOperation(value = "生成器实例设置删除")
    @PostMapping(value = "/generatorInstanceConfig/delete")
    public @ResponseBody Response<GeneratorInstanceConfig> delete(@RequestBody GeneratorInstanceConfigDeleteWebRequest request) {
        GeneratorInstanceConfigDeleteParameter parameter = new GeneratorInstanceConfigDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.delete(parameter);

        return new Response<>(generatorInstanceConfig);
    }

    @Security
    @ApiOperation(value = "生成器实例设置修改")
    @PostMapping(value = "/generatorInstanceConfig/update")
    public @ResponseBody Response<GeneratorInstanceConfig> update(@RequestBody GeneratorInstanceConfigUpdateWebRequest request) {
        GeneratorInstanceConfigUpdateParameter parameter = new GeneratorInstanceConfigUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.update(parameter);

        return new Response<>(generatorInstanceConfig);
    }
*/
    @ApiOperation(value = "生成器实例设置单个查询")
    @PostMapping(value = "/generatorInstanceConfig/get")
    public @ResponseBody Response<GeneratorInstanceConfig> get(@RequestBody GeneratorInstanceConfigGetWebRequest request) {
        GeneratorInstanceConfigGetParameter parameter = new GeneratorInstanceConfigGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.get(parameter);

        return new Response<>(generatorInstanceConfig);
    }
/*
    @ApiOperation(value="生成器实例设置多个查询")
    @PostMapping(value = "/generatorInstanceConfig/query")
    public @ResponseBody Response<List<GeneratorInstanceConfig>> query(@RequestBody GeneratorInstanceConfigQueryWebRequest request) {
        GeneratorInstanceConfigQueryParameter parameter = new GeneratorInstanceConfigQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorInstanceConfig> generatorInstanceConfigList = generatorInstanceConfigService.query(parameter);

        return new Response<>(generatorInstanceConfigList);
    }

    @ApiOperation(value = "生成器实例设置分页查询")
    @PostMapping(value = "/generatorInstanceConfig/search")
    public @ResponseBody Response<PageResult<GeneratorInstanceConfig>> search(@RequestBody GeneratorInstanceConfigSearchWebRequest request) {
        GeneratorInstanceConfigSearchParameter parameter = new GeneratorInstanceConfigSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<GeneratorInstanceConfig> generatorInstanceConfigPageResult = generatorInstanceConfigService.search(parameter);

        return new Response<>(generatorInstanceConfigPageResult);
    }
*/

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器实例设置保存")
    @PostMapping(value = "/generatorInstanceConfig/save")
    public @ResponseBody Response<GeneratorInstanceConfig> save(@RequestBody GeneratorInstanceConfigSaveWebRequest request) {
        GeneratorInstanceConfigSaveParameter parameter = new GeneratorInstanceConfigSaveParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.save(parameter);

        return new Response<>(generatorInstanceConfig);
    }
}

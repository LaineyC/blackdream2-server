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
import pers.laineyc.blackdream.generator.service.parameter.GeneratorCreateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorCreateWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDeleteWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorUpdateWebRequest;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGetParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGetWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInfoSearchParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInfoSearchWebRequest;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorReleaseParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorReleaseWebRequest;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.service.GeneratorService;
import java.util.List;

/**
 * 生成器Controller
 * @author LaineyC
 */
@Api(tags = "Generator", description = "生成器接口")
@Controller
public class GeneratorWebController extends BaseWebController {

    @Autowired
    private GeneratorService generatorService;
    
    public GeneratorWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器创建")
    @PostMapping(value = "/generator/create")
    public @ResponseBody Response<Generator> create(@RequestBody GeneratorCreateWebRequest request) {
        GeneratorCreateParameter parameter = new GeneratorCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.create(parameter);

        return new Response<>(generator);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器删除")
    @PostMapping(value = "/generator/delete")
    public @ResponseBody Response<Generator> delete(@RequestBody GeneratorDeleteWebRequest request) {
        GeneratorDeleteParameter parameter = new GeneratorDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.delete(parameter);

        return new Response<>(generator);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器修改")
    @PostMapping(value = "/generator/update")
    public @ResponseBody Response<Generator> update(@RequestBody GeneratorUpdateWebRequest request) {
        GeneratorUpdateParameter parameter = new GeneratorUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.update(parameter);

        return new Response<>(generator);
    }

    @ApiOperation(value = "生成器单个查询")
    @PostMapping(value = "/generator/get")
    public @ResponseBody Response<Generator> get(@RequestBody GeneratorGetWebRequest request) {
        GeneratorGetParameter parameter = new GeneratorGetParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.get(parameter);

        return new Response<>(generator);
    }
/*
    @ApiOperation(value="生成器多个查询")
    @PostMapping(value = "/generator/query")
    public @ResponseBody Response<List<Generator>> query(@RequestBody GeneratorQueryWebRequest request) {
        GeneratorQueryParameter parameter = new GeneratorQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<Generator> generatorList = generatorService.query(parameter);

        return new Response<>(generatorList);
    }

    @ApiOperation(value = "生成器分页查询")
    @PostMapping(value = "/generator/search")
    public @ResponseBody Response<PageResult<Generator>> search(@RequestBody GeneratorSearchWebRequest request) {
        GeneratorSearchParameter parameter = new GeneratorSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<Generator> generatorPageResult = generatorService.search(parameter);

        return new Response<>(generatorPageResult);
    }

    @Security
    @ApiOperation(value = "生成器导出")
    @PostMapping(value = "/generator/export")
    public @ResponseBody Response<Generator> export(@RequestBody GeneratorExportWebRequest request) {
        GeneratorExportParameter parameter = new GeneratorExportParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.export(parameter);

        return new Response<>(generator);
    }

    @Security
    @ApiOperation(value = "生成器导入")
    @PostMapping(value = "/generator/import")
    public @ResponseBody Response<Generator> import_(@RequestBody GeneratorImportWebRequest request) {
        GeneratorImportParameter parameter = new GeneratorImportParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.import_(parameter);

        return new Response<>(generator);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器分页查询")
    @PostMapping(value = "/generator/infoSearch")
    public @ResponseBody Response<PageResult<Generator>> infoSearch(@RequestBody GeneratorInfoSearchWebRequest request) {
        GeneratorInfoSearchParameter parameter = new GeneratorInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        PageResult<Generator> generatorPageResult = generatorService.infoSearch(parameter);

        return new Response<>(generatorPageResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器发布")
    @PostMapping(value = "/generator/release")
    public @ResponseBody Response<Generator> release(@RequestBody GeneratorReleaseWebRequest request) {
        GeneratorReleaseParameter parameter = new GeneratorReleaseParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.release(parameter);

        return new Response<>(generator);
    }
    
}

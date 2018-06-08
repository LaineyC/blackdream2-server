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
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorCreateWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorDeleteWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorUpdateWebVo;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorGetParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorGetWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInfoSearchParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInfoSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInfoSearchWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorReleaseParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorReleaseWebRequest;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorReleaseWebVo;
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
    public @ResponseBody Response<GeneratorCreateWebVo> create(@RequestBody GeneratorCreateWebRequest request) {
        GeneratorCreateParameter parameter = new GeneratorCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.create(parameter);

        GeneratorCreateWebVo generatorCreateWebVo = new GeneratorCreateWebVo();
        BeanUtils.copyProperties(generator, generatorCreateWebVo);

        return new Response<>(generatorCreateWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器删除")
    @PostMapping(value = "/generator/delete")
    public @ResponseBody Response<GeneratorDeleteWebVo> delete(@RequestBody GeneratorDeleteWebRequest request) {
        GeneratorDeleteParameter parameter = new GeneratorDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.delete(parameter);

        GeneratorDeleteWebVo generatorDeleteWebVo = new GeneratorDeleteWebVo();
        BeanUtils.copyProperties(generator, generatorDeleteWebVo);

        return new Response<>(generatorDeleteWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器修改")
    @PostMapping(value = "/generator/update")
    public @ResponseBody Response<GeneratorUpdateWebVo> update(@RequestBody GeneratorUpdateWebRequest request) {
        GeneratorUpdateParameter parameter = new GeneratorUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.update(parameter);
        
        GeneratorUpdateWebVo generatorUpdateWebVo = new GeneratorUpdateWebVo();
        BeanUtils.copyProperties(generator, generatorUpdateWebVo);

        return new Response<>(generatorUpdateWebVo);
    }

    @ApiOperation(value = "生成器单个查询")
    @PostMapping(value = "/generator/get")
    public @ResponseBody Response<GeneratorGetWebVo> get(@RequestBody GeneratorGetWebRequest request) {
        GeneratorGetParameter parameter = new GeneratorGetParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.get(parameter);
        
        GeneratorGetWebVo generatorGetWebVo = new GeneratorGetWebVo();
        BeanUtils.copyProperties(generator, generatorGetWebVo);
        
        return new Response<>(generatorGetWebVo);
    }
/*
    @ApiOperation(value="生成器多个查询")
    @PostMapping(value = "/generator/query")
    public @ResponseBody Response<List<GeneratorQueryWebVo>> query(@RequestBody GeneratorQueryWebRequest request) {
        GeneratorQueryParameter parameter = new GeneratorQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<Generator> generatorList = generatorService.query(parameter);
        
        List<GeneratorQueryWebVo> generatorQueryWebVoList = new ArrayList<>();
        generatorList.forEach(generator -> {
            GeneratorQueryWebVo generatorQueryWebVo = new GeneratorQueryWebVo();
            BeanUtils.copyProperties(generator, generatorQueryWebVo);
            generatorQueryWebVoList.add(generatorQueryWebVo);
        });

        return new Response<>(generatorQueryWebVoList);
    }

    @ApiOperation(value = "生成器分页查询")
    @PostMapping(value = "/generator/search")
    public @ResponseBody Response<PageResult<GeneratorSearchWebVo>> search(@RequestBody GeneratorSearchWebRequest request) {
        GeneratorSearchParameter parameter = new GeneratorSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<Generator> generatorPageResult = generatorService.search(parameter);
        
        PageResult<GeneratorSearchWebVo> generatorSearchWebVoPageResult = new PageResult<>();
        generatorSearchWebVoPageResult.setTotal(generatorPageResult.getTotal());
        List<GeneratorSearchWebVo> generatorSearchWebVoList = generatorSearchWebVoPageResult.getRecords();
        generatorPageResult.getRecords().forEach(generator -> {
            GeneratorSearchWebVo generatorSearchWebVo = new GeneratorSearchWebVo();
            BeanUtils.copyProperties(generator, generatorSearchWebVo);
            generatorSearchWebVoList.add(generatorSearchWebVo);
        });

        return new Response<>(generatorSearchWebVoPageResult);
    }

    @Security
    @ApiOperation(value = "生成器导出")
    @PostMapping(value = "/generator/export")
    public @ResponseBody Response<GeneratorExportWebVo> export(@RequestBody GeneratorExportWebRequest request) {
        GeneratorExportParameter parameter = new GeneratorExportParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.export(parameter);

        GeneratorExportWebVo generatorExportWebVo = new GeneratorExportWebVo();
        BeanUtils.copyProperties(generator, generatorExportWebVo);

        return new Response<>(generatorExportWebVo);
    }

    @Security
    @ApiOperation(value = "生成器导入")
    @PostMapping(value = "/generator/import")
    public @ResponseBody Response<GeneratorImportWebVo> import_(@RequestBody GeneratorImportWebRequest request) {
        GeneratorImportParameter parameter = new GeneratorImportParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.import_(parameter);

        GeneratorImportWebVo generatorImportWebVo = new GeneratorImportWebVo();
        BeanUtils.copyProperties(generator, generatorImportWebVo);

        return new Response<>(generatorImportWebVo);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器分页查询")
    @PostMapping(value = "/generator/infoSearch")
    public @ResponseBody Response<PageResult<GeneratorInfoSearchWebVo>> infoSearch(@RequestBody GeneratorInfoSearchWebRequest request) {
        GeneratorInfoSearchParameter parameter = new GeneratorInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        PageResult<Generator> generatorPageResult = generatorService.infoSearch(parameter);

        PageResult<GeneratorInfoSearchWebVo> generatorSearchWebVoPageResult = new PageResult<>();
        generatorSearchWebVoPageResult.setTotal(generatorPageResult.getTotal());
        List<GeneratorInfoSearchWebVo> generatorSearchWebVoList = generatorSearchWebVoPageResult.getRecords();
        generatorPageResult.getRecords().forEach(generator -> {
            GeneratorInfoSearchWebVo generatorSearchWebVo = new GeneratorInfoSearchWebVo();
            BeanUtils.copyProperties(generator, generatorSearchWebVo);
            generatorSearchWebVoList.add(generatorSearchWebVo);
        });

        return new Response<>(generatorSearchWebVoPageResult);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器发布")
    @PostMapping(value = "/generator/release")
    public @ResponseBody Response<GeneratorReleaseWebVo> release(@RequestBody GeneratorReleaseWebRequest request) {
        GeneratorReleaseParameter parameter = new GeneratorReleaseParameter();
        BeanUtils.copyProperties(request, parameter);

        Generator generator = generatorService.release(parameter);

        GeneratorReleaseWebVo generatorReleaseWebVo = new GeneratorReleaseWebVo();
        BeanUtils.copyProperties(generator, generatorReleaseWebVo);

        return new Response<>(generatorReleaseWebVo);
    }
    
}

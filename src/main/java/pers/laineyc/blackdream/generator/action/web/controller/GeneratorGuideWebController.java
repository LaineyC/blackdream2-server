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
import pers.laineyc.blackdream.generator.service.domain.GeneratorGuide;
import pers.laineyc.blackdream.generator.service.GeneratorGuideService;

/**
 * 生成器指南Controller
 * @author LaineyC
 */
@Api(tags = "GeneratorGuide", description = "生成器指南接口")
@Controller
public class GeneratorGuideWebController extends BaseWebController {

    @Autowired
    private GeneratorGuideService generatorGuideService;
    
    public GeneratorGuideWebController() {

    }
/*
    @Security
    @ApiOperation(value = "生成器指南创建")
    @PostMapping(value = "/generatorGuide/create")
    public @ResponseBody Response<GeneratorGuide> create(@RequestBody GeneratorGuideCreateWebRequest request) {
        GeneratorGuideCreateParameter parameter = new GeneratorGuideCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorGuide generatorGuide = generatorGuideService.create(parameter);

        return new Response<>(generatorGuide);
    }

    @Security
    @ApiOperation(value = "生成器指南删除")
    @PostMapping(value = "/generatorGuide/delete")
    public @ResponseBody Response<GeneratorGuide> delete(@RequestBody GeneratorGuideDeleteWebRequest request) {
        GeneratorGuideDeleteParameter parameter = new GeneratorGuideDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorGuide generatorGuide = generatorGuideService.delete(parameter);

        return new Response<>(generatorGuide);
    }

    @Security
    @ApiOperation(value = "生成器指南修改")
    @PostMapping(value = "/generatorGuide/update")
    public @ResponseBody Response<GeneratorGuide> update(@RequestBody GeneratorGuideUpdateWebRequest request) {
        GeneratorGuideUpdateParameter parameter = new GeneratorGuideUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorGuide generatorGuide = generatorGuideService.update(parameter);

        return new Response<>(generatorGuide);
    }
*/
    @ApiOperation(value = "生成器指南单个查询")
    @PostMapping(value = "/generatorGuide/get")
    public @ResponseBody Response<GeneratorGuide> get(@RequestBody GeneratorGuideGetWebRequest request) {
        GeneratorGuideGetParameter parameter = new GeneratorGuideGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorGuide generatorGuide = generatorGuideService.get(parameter);

        return new Response<>(generatorGuide);
    }
/*
    @ApiOperation(value="生成器指南多个查询")
    @PostMapping(value = "/generatorGuide/query")
    public @ResponseBody Response<List<GeneratorGuide>> query(@RequestBody GeneratorGuideQueryWebRequest request) {
        GeneratorGuideQueryParameter parameter = new GeneratorGuideQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorGuide> generatorGuideList = generatorGuideService.query(parameter);

        return new Response<>(generatorGuideList);
    }

    @ApiOperation(value = "生成器指南分页查询")
    @PostMapping(value = "/generatorGuide/search")
    public @ResponseBody Response<PageResult<GeneratorGuide>> search(@RequestBody GeneratorGuideSearchWebRequest request) {
        GeneratorGuideSearchParameter parameter = new GeneratorGuideSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<GeneratorGuide> generatorGuidePageResult = generatorGuideService.search(parameter);

        return new Response<>(generatorGuidePageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器指南保存")
    @PostMapping(value = "/generatorGuide/save")
    public @ResponseBody Response<GeneratorGuide> save(@RequestBody GeneratorGuideSaveWebRequest request) {
        GeneratorGuideSaveParameter parameter = new GeneratorGuideSaveParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorGuide generatorGuide = generatorGuideService.save(parameter);

        return new Response<>(generatorGuide);
    }
}

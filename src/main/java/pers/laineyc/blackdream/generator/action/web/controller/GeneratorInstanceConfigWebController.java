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
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigCreateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigCreateWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigDeleteWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigUpdateWebVo;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigSearchParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigGetWebVo;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigQueryWebVo;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceConfigSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceConfigSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceConfigSearchWebVo;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceConfigService;
import java.util.List;
import java.util.ArrayList;

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

    @Security
    @ApiOperation(value = "生成器实例设置创建")
    @PostMapping(value = "/generatorInstanceConfig/create")
    public @ResponseBody GeneratorInstanceConfigCreateWebResponse create(@RequestBody GeneratorInstanceConfigCreateWebRequest request) {
        GeneratorInstanceConfigCreateParameter parameter = new GeneratorInstanceConfigCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.create(parameter);

        GeneratorInstanceConfigCreateWebVo generatorInstanceConfigCreateWebVo = new GeneratorInstanceConfigCreateWebVo();
        BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigCreateWebVo);

        return new GeneratorInstanceConfigCreateWebResponse(generatorInstanceConfigCreateWebVo);
    }
/*
    @Security
    @ApiOperation(value = "生成器实例设置删除")
    @PostMapping(value = "/generatorInstanceConfig/delete")
    public @ResponseBody GeneratorInstanceConfigDeleteWebResponse delete(@RequestBody GeneratorInstanceConfigDeleteWebRequest request) {
        GeneratorInstanceConfigDeleteParameter parameter = new GeneratorInstanceConfigDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.delete(parameter);

        GeneratorInstanceConfigDeleteWebVo generatorInstanceConfigDeleteWebVo = new GeneratorInstanceConfigDeleteWebVo();
        BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigDeleteWebVo);

        return new GeneratorInstanceConfigDeleteWebResponse(generatorInstanceConfigDeleteWebVo);
    }
*/
    @Security
    @ApiOperation(value = "生成器实例设置修改")
    @PostMapping(value = "/generatorInstanceConfig/update")
    public @ResponseBody GeneratorInstanceConfigUpdateWebResponse update(@RequestBody GeneratorInstanceConfigUpdateWebRequest request) {
        GeneratorInstanceConfigUpdateParameter parameter = new GeneratorInstanceConfigUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.update(parameter);
        
        GeneratorInstanceConfigUpdateWebVo generatorInstanceConfigUpdateWebVo = new GeneratorInstanceConfigUpdateWebVo();
        BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigUpdateWebVo);

        return new GeneratorInstanceConfigUpdateWebResponse(generatorInstanceConfigUpdateWebVo);
    }

    @ApiOperation(value = "生成器实例设置单个查询")
    @PostMapping(value = "/generatorInstanceConfig/get")
    public @ResponseBody GeneratorInstanceConfigGetWebResponse get(@RequestBody GeneratorInstanceConfigGetWebRequest request) {
        GeneratorInstanceConfigGetParameter parameter = new GeneratorInstanceConfigGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstanceConfig generatorInstanceConfig = generatorInstanceConfigService.get(parameter);
        
        GeneratorInstanceConfigGetWebVo generatorInstanceConfigGetWebVo = new GeneratorInstanceConfigGetWebVo();
        BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigGetWebVo);
        
        return new GeneratorInstanceConfigGetWebResponse(generatorInstanceConfigGetWebVo);
    }
/*
    @ApiOperation(value="生成器实例设置多个查询")
    @PostMapping(value = "/generatorInstanceConfig/query")
    public @ResponseBody GeneratorInstanceConfigQueryWebResponse query(@RequestBody GeneratorInstanceConfigQueryWebRequest request) {
        GeneratorInstanceConfigQueryParameter parameter = new GeneratorInstanceConfigQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorInstanceConfig> generatorInstanceConfigList = generatorInstanceConfigService.query(parameter);
        
        List<GeneratorInstanceConfigQueryWebVo> generatorInstanceConfigQueryWebVoList = new ArrayList<>();
        generatorInstanceConfigList.forEach(generatorInstanceConfig -> {
            GeneratorInstanceConfigQueryWebVo generatorInstanceConfigQueryWebVo = new GeneratorInstanceConfigQueryWebVo();
            BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigQueryWebVo);
            generatorInstanceConfigQueryWebVoList.add(generatorInstanceConfigQueryWebVo);
        });

        return new GeneratorInstanceConfigQueryWebResponse(generatorInstanceConfigQueryWebVoList);
    }

    @ApiOperation(value = "生成器实例设置分页查询")
    @PostMapping(value = "/generatorInstanceConfig/search")
    public @ResponseBody GeneratorInstanceConfigSearchWebResponse search(@RequestBody GeneratorInstanceConfigSearchWebRequest request) {
        GeneratorInstanceConfigSearchParameter parameter = new GeneratorInstanceConfigSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<GeneratorInstanceConfig> generatorInstanceConfigPageResult = generatorInstanceConfigService.search(parameter);
        
        PageResult<GeneratorInstanceConfigSearchWebVo> generatorInstanceConfigSearchWebVoPageResult = new PageResult<>();
        generatorInstanceConfigSearchWebVoPageResult.setTotal(generatorInstanceConfigPageResult.getTotal());
        List<GeneratorInstanceConfigSearchWebVo> generatorInstanceConfigSearchWebVoList = generatorInstanceConfigSearchWebVoPageResult.getRecords();
        generatorInstanceConfigPageResult.getRecords().forEach(generatorInstanceConfig -> {
            GeneratorInstanceConfigSearchWebVo generatorInstanceConfigSearchWebVo = new GeneratorInstanceConfigSearchWebVo();
            BeanUtils.copyProperties(generatorInstanceConfig, generatorInstanceConfigSearchWebVo);
            generatorInstanceConfigSearchWebVoList.add(generatorInstanceConfigSearchWebVo);
        });

        return new GeneratorInstanceConfigSearchWebResponse(generatorInstanceConfigSearchWebVoPageResult);
    }
*/
}

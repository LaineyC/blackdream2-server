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
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceCreateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceCreateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceCreateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceCreateWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceDeleteParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceDeleteWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceDeleteWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceDeleteWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceUpdateParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceUpdateWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceUpdateWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceUpdateWebVo;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceSearchParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceGetWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceGetWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceGetWebVo;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceQueryWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceQueryWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceQueryWebVo;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceSearchWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceInfoSearchParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceInfoSearchWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceInfoSearchWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceInfoSearchWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceMakeParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceMakeWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceMakeWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceMakeWebVo;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceVersionSyncParameter;
import pers.laineyc.blackdream.generator.action.web.request.GeneratorInstanceVersionSyncWebRequest;
import pers.laineyc.blackdream.generator.action.web.response.GeneratorInstanceVersionSyncWebResponse;
import pers.laineyc.blackdream.generator.action.web.vo.GeneratorInstanceVersionSyncWebVo;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceService;
import java.util.List;
import java.util.ArrayList;

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

    @Security
    @ApiOperation(value = "生成器实例创建")
    @PostMapping(value = "/generatorInstance/create")
    public @ResponseBody GeneratorInstanceCreateWebResponse create(@RequestBody GeneratorInstanceCreateWebRequest request) {
        GeneratorInstanceCreateParameter parameter = new GeneratorInstanceCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.create(parameter);

        GeneratorInstanceCreateWebVo generatorInstanceCreateWebVo = new GeneratorInstanceCreateWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceCreateWebVo);

        return new GeneratorInstanceCreateWebResponse(generatorInstanceCreateWebVo);
    }

    @Security
    @ApiOperation(value = "生成器实例删除")
    @PostMapping(value = "/generatorInstance/delete")
    public @ResponseBody GeneratorInstanceDeleteWebResponse delete(@RequestBody GeneratorInstanceDeleteWebRequest request) {
        GeneratorInstanceDeleteParameter parameter = new GeneratorInstanceDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.delete(parameter);

        GeneratorInstanceDeleteWebVo generatorInstanceDeleteWebVo = new GeneratorInstanceDeleteWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceDeleteWebVo);

        return new GeneratorInstanceDeleteWebResponse(generatorInstanceDeleteWebVo);
    }

    @Security
    @ApiOperation(value = "生成器实例修改")
    @PostMapping(value = "/generatorInstance/update")
    public @ResponseBody GeneratorInstanceUpdateWebResponse update(@RequestBody GeneratorInstanceUpdateWebRequest request) {
        GeneratorInstanceUpdateParameter parameter = new GeneratorInstanceUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.update(parameter);
        
        GeneratorInstanceUpdateWebVo generatorInstanceUpdateWebVo = new GeneratorInstanceUpdateWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceUpdateWebVo);

        return new GeneratorInstanceUpdateWebResponse(generatorInstanceUpdateWebVo);
    }

    @ApiOperation(value = "生成器实例单个查询")
    @PostMapping(value = "/generatorInstance/get")
    public @ResponseBody GeneratorInstanceGetWebResponse get(@RequestBody GeneratorInstanceGetWebRequest request) {
        GeneratorInstanceGetParameter parameter = new GeneratorInstanceGetParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.get(parameter);
        
        GeneratorInstanceGetWebVo generatorInstanceGetWebVo = new GeneratorInstanceGetWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceGetWebVo);
        
        return new GeneratorInstanceGetWebResponse(generatorInstanceGetWebVo);
    }
/*
    @ApiOperation(value="生成器实例多个查询")
    @PostMapping(value = "/generatorInstance/query")
    public @ResponseBody GeneratorInstanceQueryWebResponse query(@RequestBody GeneratorInstanceQueryWebRequest request) {
        GeneratorInstanceQueryParameter parameter = new GeneratorInstanceQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<GeneratorInstance> generatorInstanceList = generatorInstanceService.query(parameter);
        
        List<GeneratorInstanceQueryWebVo> generatorInstanceQueryWebVoList = new ArrayList<>();
        generatorInstanceList.forEach(generatorInstance -> {
            GeneratorInstanceQueryWebVo generatorInstanceQueryWebVo = new GeneratorInstanceQueryWebVo();
            BeanUtils.copyProperties(generatorInstance, generatorInstanceQueryWebVo);
            generatorInstanceQueryWebVoList.add(generatorInstanceQueryWebVo);
        });

        return new GeneratorInstanceQueryWebResponse(generatorInstanceQueryWebVoList);
    }

    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/search")
    public @ResponseBody GeneratorInstanceSearchWebResponse search(@RequestBody GeneratorInstanceSearchWebRequest request) {
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

        return new GeneratorInstanceSearchWebResponse(generatorInstanceSearchWebVoPageResult);
    }
*/
    @Security
    @ApiOperation(value = "生成器实例分页查询")
    @PostMapping(value = "/generatorInstance/infoSearch")
    public @ResponseBody GeneratorInstanceInfoSearchWebResponse infoSearch(@RequestBody GeneratorInstanceInfoSearchWebRequest request) {
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

        return new GeneratorInstanceInfoSearchWebResponse(generatorInstanceSearchWebVoPageResult);
    }

    @Security
    @ApiOperation(value = "生成器实例生成")
    @PostMapping(value = "/generatorInstance/make")
    public @ResponseBody GeneratorInstanceMakeWebResponse make(@RequestBody GeneratorInstanceMakeWebRequest request) {
        GeneratorInstanceMakeParameter parameter = new GeneratorInstanceMakeParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.make(parameter);

        GeneratorInstanceMakeWebVo generatorInstanceMakeWebVo = new GeneratorInstanceMakeWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceMakeWebVo);

        return new GeneratorInstanceMakeWebResponse(generatorInstanceMakeWebVo);
    }

    @Security
    @ApiOperation(value = "生成器实例版本同步")
    @PostMapping(value = "/generatorInstance/versionSync")
    public @ResponseBody GeneratorInstanceVersionSyncWebResponse versionSync(@RequestBody GeneratorInstanceVersionSyncWebRequest request) {
        GeneratorInstanceVersionSyncParameter parameter = new GeneratorInstanceVersionSyncParameter();
        BeanUtils.copyProperties(request, parameter);

        GeneratorInstance generatorInstance = generatorInstanceService.versionSync(parameter);

        GeneratorInstanceVersionSyncWebVo generatorInstanceVersionSyncWebVo = new GeneratorInstanceVersionSyncWebVo();
        BeanUtils.copyProperties(generatorInstance, generatorInstanceVersionSyncWebVo);

        return new GeneratorInstanceVersionSyncWebResponse(generatorInstanceVersionSyncWebVo);
    }
    
}
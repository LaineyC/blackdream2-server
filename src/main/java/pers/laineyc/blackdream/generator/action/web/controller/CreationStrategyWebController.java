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
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.CreationStrategy;
import pers.laineyc.blackdream.generator.service.CreationStrategyService;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器生成策略Controller
 * @author LaineyC
 */
@Api(tags = "CreationStrategy", description = "生成器生成策略接口")
@Controller
public class CreationStrategyWebController extends BaseWebController {

    @Autowired
    private CreationStrategyService creationStrategyService;
    
    public CreationStrategyWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器生成策略创建")
    @PostMapping(value = "/creationStrategy/create")
    public @ResponseBody Response<CreationStrategy> create(@RequestBody CreationStrategyCreateWebRequest request) {
        CreationStrategyCreateParameter parameter = new CreationStrategyCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        CreationStrategy creationStrategy = creationStrategyService.create(parameter);

        return new Response<>(creationStrategy);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器生成策略删除")
    @PostMapping(value = "/creationStrategy/delete")
    public @ResponseBody Response<CreationStrategy> delete(@RequestBody CreationStrategyDeleteWebRequest request) {
        CreationStrategyDeleteParameter parameter = new CreationStrategyDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        CreationStrategy creationStrategy = creationStrategyService.delete(parameter);

        return new Response<>(creationStrategy);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器生成策略修改")
    @PostMapping(value = "/creationStrategy/update")
    public @ResponseBody Response<CreationStrategy> update(@RequestBody CreationStrategyUpdateWebRequest request) {
        CreationStrategyUpdateParameter parameter = new CreationStrategyUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        CreationStrategy creationStrategy = creationStrategyService.update(parameter);

        return new Response<>(creationStrategy);
    }

    @ApiOperation(value = "生成器生成策略单个查询")
    @PostMapping(value = "/creationStrategy/get")
    public @ResponseBody Response<CreationStrategy> get(@RequestBody CreationStrategyGetWebRequest request) {
        CreationStrategyGetParameter parameter = new CreationStrategyGetParameter();
        BeanUtils.copyProperties(request, parameter);

        CreationStrategy creationStrategy = creationStrategyService.get(parameter);
        
        return new Response<>(creationStrategy);
    }
/*
    @ApiOperation(value="生成器生成策略多个查询")
    @PostMapping(value = "/creationStrategy/query")
    public @ResponseBody Response<List<CreationStrategy>> query(@RequestBody CreationStrategyQueryWebRequest request) {
        CreationStrategyQueryParameter parameter = new CreationStrategyQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<CreationStrategy> creationStrategyList = creationStrategyService.query(parameter);

        return new Response<>(creationStrategyList);
    }

    @ApiOperation(value = "生成器生成策略分页查询")
    @PostMapping(value = "/creationStrategy/search")
    public @ResponseBody Response<PageResult<CreationStrategy>> search(@RequestBody CreationStrategySearchWebRequest request) {
        CreationStrategySearchParameter parameter = new CreationStrategySearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<CreationStrategy> creationStrategyPageResult = creationStrategyService.search(parameter);

        return new Response<>(creationStrategyPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器生成策略排序")
    @PostMapping(value = "/creationStrategy/sort")
    public @ResponseBody Response<CreationStrategy> sort(@RequestBody CreationStrategySortWebRequest request) {
        CreationStrategySortParameter parameter = new CreationStrategySortParameter();
        BeanUtils.copyProperties(request, parameter);

        CreationStrategy creationStrategy = creationStrategyService.sort(parameter);

        return new Response<>(creationStrategy);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器生成策略多个查询")
    @PostMapping(value = "/creationStrategy/infoQuery")
    public @ResponseBody Response<List<CreationStrategy>> infoQuery(@RequestBody CreationStrategyInfoQueryWebRequest request) {
        CreationStrategyInfoQueryParameter parameter = new CreationStrategyInfoQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<CreationStrategy> creationStrategyList = creationStrategyService.infoQuery(parameter);

        return new Response<>(creationStrategyList);
    }
    
}

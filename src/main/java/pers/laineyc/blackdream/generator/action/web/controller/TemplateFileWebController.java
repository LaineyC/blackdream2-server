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
import pers.laineyc.blackdream.generator.service.domain.TemplateFile;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成器模板文件Controller
 * @author LaineyC
 */
@Api(tags = "TemplateFile", description = "生成器模板文件接口")
@Controller
public class TemplateFileWebController extends BaseWebController {

    @Autowired
    private TemplateFileService templateFileService;
    
    public TemplateFileWebController() {

    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件创建")
    @PostMapping(value = "/templateFile/create")
    public @ResponseBody Response<TemplateFile> create(@RequestBody TemplateFileCreateWebRequest request) {
        TemplateFileCreateParameter parameter = new TemplateFileCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.create(parameter);

        return new Response<>(templateFile);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件删除")
    @PostMapping(value = "/templateFile/delete")
    public @ResponseBody Response<TemplateFile> delete(@RequestBody TemplateFileDeleteWebRequest request) {
        TemplateFileDeleteParameter parameter = new TemplateFileDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.delete(parameter);

        return new Response<>(templateFile);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件修改")
    @PostMapping(value = "/templateFile/update")
    public @ResponseBody Response<TemplateFile> update(@RequestBody TemplateFileUpdateWebRequest request) {
        TemplateFileUpdateParameter parameter = new TemplateFileUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.update(parameter);

        return new Response<>(templateFile);
    }

    @ApiOperation(value = "生成器模板文件单个查询")
    @PostMapping(value = "/templateFile/get")
    public @ResponseBody Response<TemplateFile> get(@RequestBody TemplateFileGetWebRequest request) {
        TemplateFileGetParameter parameter = new TemplateFileGetParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.get(parameter);
        
        return new Response<>(templateFile);
    }
/*
    @ApiOperation(value="生成器模板文件多个查询")
    @PostMapping(value = "/templateFile/query")
    public @ResponseBody Response<List<TemplateFile>> query(@RequestBody TemplateFileQueryWebRequest request) {
        TemplateFileQueryParameter parameter = new TemplateFileQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<TemplateFile> templateFileList = templateFileService.query(parameter);

        return new Response<>(templateFileList);
    }

    @ApiOperation(value = "生成器模板文件分页查询")
    @PostMapping(value = "/templateFile/search")
    public @ResponseBody Response<PageResult<TemplateFile>> search(@RequestBody TemplateFileSearchWebRequest request) {
        TemplateFileSearchParameter parameter = new TemplateFileSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<TemplateFile> templateFilePageResult = templateFileService.search(parameter);

        return new Response<>(templateFilePageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件排序")
    @PostMapping(value = "/templateFile/sort")
    public @ResponseBody Response<TemplateFile> sort(@RequestBody TemplateFileSortWebRequest request) {
        TemplateFileSortParameter parameter = new TemplateFileSortParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.sort(parameter);

        return new Response<>(templateFile);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件查询")
    @PostMapping(value = "/templateFile/infoQuery")
    public @ResponseBody Response<List<TemplateFile>> infoQuery(@RequestBody TemplateFileInfoQueryWebRequest request) {
        TemplateFileInfoQueryParameter parameter = new TemplateFileInfoQueryParameter();
        BeanUtils.copyProperties(request, parameter);

        List<TemplateFile> templateFileList = templateFileService.infoQuery(parameter);

        return new Response<>(templateFileList);
    }

}

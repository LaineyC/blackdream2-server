package pers.laineyc.blackdream.generator.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.laineyc.blackdream.configuration.config.AuthSecurity;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.generator.action.web.request.*;
import pers.laineyc.blackdream.generator.action.web.response.*;
import pers.laineyc.blackdream.generator.action.web.vo.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.TemplateFile;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
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
    public @ResponseBody TemplateFileCreateWebResponse create(@RequestBody TemplateFileCreateWebRequest request) {
        TemplateFileCreateParameter parameter = new TemplateFileCreateParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.create(parameter);

        TemplateFileCreateWebVo templateFileCreateWebVo = new TemplateFileCreateWebVo();
        BeanUtils.copyProperties(templateFile, templateFileCreateWebVo);

        return new TemplateFileCreateWebResponse(templateFileCreateWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件删除")
    @PostMapping(value = "/templateFile/delete")
    public @ResponseBody TemplateFileDeleteWebResponse delete(@RequestBody TemplateFileDeleteWebRequest request) {
        TemplateFileDeleteParameter parameter = new TemplateFileDeleteParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.delete(parameter);

        TemplateFileDeleteWebVo templateFileDeleteWebVo = new TemplateFileDeleteWebVo();
        BeanUtils.copyProperties(templateFile, templateFileDeleteWebVo);

        return new TemplateFileDeleteWebResponse(templateFileDeleteWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件修改")
    @PostMapping(value = "/templateFile/update")
    public @ResponseBody TemplateFileUpdateWebResponse update(@RequestBody TemplateFileUpdateWebRequest request) {
        TemplateFileUpdateParameter parameter = new TemplateFileUpdateParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.update(parameter);
        
        TemplateFileUpdateWebVo templateFileUpdateWebVo = new TemplateFileUpdateWebVo();
        BeanUtils.copyProperties(templateFile, templateFileUpdateWebVo);

        return new TemplateFileUpdateWebResponse(templateFileUpdateWebVo);
    }

    @ApiOperation(value = "生成器模板文件单个查询")
    @PostMapping(value = "/templateFile/get")
    public @ResponseBody TemplateFileGetWebResponse get(@RequestBody TemplateFileGetWebRequest request) {
        TemplateFileGetParameter parameter = new TemplateFileGetParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.get(parameter);
        
        TemplateFileGetWebVo templateFileGetWebVo = new TemplateFileGetWebVo();
        BeanUtils.copyProperties(templateFile, templateFileGetWebVo);
        
        return new TemplateFileGetWebResponse(templateFileGetWebVo);
    }
/*
    @ApiOperation(value="生成器模板文件多个查询")
    @PostMapping(value = "/templateFile/query")
    public @ResponseBody TemplateFileQueryWebResponse query(@RequestBody TemplateFileQueryWebRequest request) {
        TemplateFileQueryParameter parameter = new TemplateFileQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<TemplateFile> templateFileList = templateFileService.query(parameter);
        
        List<TemplateFileQueryWebVo> templateFileQueryWebVoList = new ArrayList<>();
        templateFileList.forEach(templateFile -> {
            TemplateFileQueryWebVo templateFileQueryWebVo = new TemplateFileQueryWebVo();
            BeanUtils.copyProperties(templateFile, templateFileQueryWebVo);
            templateFileQueryWebVoList.add(templateFileQueryWebVo);
        });

        return new TemplateFileQueryWebResponse(templateFileQueryWebVoList);
    }

    @ApiOperation(value = "生成器模板文件分页查询")
    @PostMapping(value = "/templateFile/search")
    public @ResponseBody TemplateFileSearchWebResponse search(@RequestBody TemplateFileSearchWebRequest request) {
        TemplateFileSearchParameter parameter = new TemplateFileSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<TemplateFile> templateFilePageResult = templateFileService.search(parameter);
        
        PageResult<TemplateFileSearchWebVo> templateFileSearchWebVoPageResult = new PageResult<>();
        templateFileSearchWebVoPageResult.setTotal(templateFilePageResult.getTotal());
        List<TemplateFileSearchWebVo> templateFileSearchWebVoList = templateFileSearchWebVoPageResult.getRecords();
        templateFilePageResult.getRecords().forEach(templateFile -> {
            TemplateFileSearchWebVo templateFileSearchWebVo = new TemplateFileSearchWebVo();
            BeanUtils.copyProperties(templateFile, templateFileSearchWebVo);
            templateFileSearchWebVoList.add(templateFileSearchWebVo);
        });

        return new TemplateFileSearchWebResponse(templateFileSearchWebVoPageResult);
    }
*/
    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件排序")
    @PostMapping(value = "/templateFile/sort")
    public @ResponseBody TemplateFileSortWebResponse sort(@RequestBody TemplateFileSortWebRequest request) {
        TemplateFileSortParameter parameter = new TemplateFileSortParameter();
        BeanUtils.copyProperties(request, parameter);

        TemplateFile templateFile = templateFileService.sort(parameter);

        TemplateFileSortWebVo templateFileSortWebVo = new TemplateFileSortWebVo();
        BeanUtils.copyProperties(templateFile, templateFileSortWebVo);

        return new TemplateFileSortWebResponse(templateFileSortWebVo);
    }

    @AuthSecurity(developer = true)
    @ApiOperation(value = "生成器模板文件分页查询")
    @PostMapping(value = "/templateFile/infoSearch")
    public @ResponseBody TemplateFileInfoSearchWebResponse infoSearch(@RequestBody TemplateFileInfoSearchWebRequest request) {
        TemplateFileInfoSearchParameter parameter = new TemplateFileInfoSearchParameter();
        BeanUtils.copyProperties(request, parameter);

        PageResult<TemplateFile> templateFilePageResult = templateFileService.infoSearch(parameter);

        PageResult<TemplateFileInfoSearchWebVo> templateFileSearchWebVoPageResult = new PageResult<>();
        templateFileSearchWebVoPageResult.setTotal(templateFilePageResult.getTotal());
        List<TemplateFileInfoSearchWebVo> templateFileSearchWebVoList = templateFileSearchWebVoPageResult.getRecords();
        templateFilePageResult.getRecords().forEach(templateFile -> {
            TemplateFileInfoSearchWebVo templateFileSearchWebVo = new TemplateFileInfoSearchWebVo();
            BeanUtils.copyProperties(templateFile, templateFileSearchWebVo);
            templateFileSearchWebVoList.add(templateFileSearchWebVo);
        });

        return new TemplateFileInfoSearchWebResponse(templateFileSearchWebVoPageResult);
    }

}

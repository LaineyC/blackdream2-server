package pers.laineyc.blackdream.foundation.action.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pers.laineyc.blackdream.foundation.action.web.request.StorageFileFileDownloadWebRequest;
import pers.laineyc.blackdream.foundation.service.StorageFileService;
import pers.laineyc.blackdream.foundation.service.domain.StorageFile;
import pers.laineyc.blackdream.foundation.service.parameter.StorageFileGetParameter;
import pers.laineyc.blackdream.framework.controller.response.Response;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.controller.BaseWebController;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileUploadParameter;
import pers.laineyc.blackdream.foundation.action.web.request.DetachedFileUploadWebRequest;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import pers.laineyc.blackdream.foundation.service.DetachedFileService;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * 文件Controller
 * @author LaineyC
 */
@Api(tags = "File", description = "文件接口")
@Controller
public class FileWebController extends BaseWebController {

    @Autowired
    private DetachedFileService detachedFileService;

    @Autowired
    private StorageFileService storageFileService;
    
    public FileWebController() {

    }
/*
    @ApiOperation(value = "游离文件单个查询")
    @PostMapping(value = "/detachedFile/get")
    public @ResponseBody Response<DetachedFile> get(@RequestBody DetachedFileGetWebRequest request) {
        DetachedFileGetParameter parameter = new DetachedFileGetParameter();
        BeanUtils.copyProperties(request, parameter);

        DetachedFile detachedFile = detachedFileService.get(parameter);
        
        return new Response<>(detachedFile);
    }

    @ApiOperation(value="游离文件多个查询")
    @PostMapping(value = "/detachedFile/query")
    public @ResponseBody Response<List<DetachedFile>> query(@RequestBody DetachedFileQueryWebRequest request) {
        DetachedFileQueryParameter parameter = new DetachedFileQueryParameter();
        BeanUtils.copyProperties(request, parameter);
        
        List<DetachedFile> detachedFileList = detachedFileService.query(parameter);

        return new Response<>(detachedFileList);
    }

    @ApiOperation(value = "游离文件分页查询")
    @PostMapping(value = "/detachedFile/search")
    public @ResponseBody Response<PageResult<DetachedFile>> search(@RequestBody DetachedFileSearchWebRequest request) {
        DetachedFileSearchParameter parameter = new DetachedFileSearchParameter();
        BeanUtils.copyProperties(request, parameter);
        
        PageResult<DetachedFile> detachedFilePageResult = detachedFileService.search(parameter);

        return new Response<>(detachedFilePageResult);
    }
*/
    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/file/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public @ResponseBody Response<DetachedFile> upload(DetachedFileUploadWebRequest request) {
        MultipartFile multipartFile = request.getFile();

        DetachedFileUploadParameter parameter = new DetachedFileUploadParameter();
        parameter.setAuth(request.getAuth());
        parameter.setSize(multipartFile.getSize());
        String originalFilename = multipartFile.getOriginalFilename();
        String name = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        parameter.setName(name);
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        parameter.setExtension(extension);
        parameter.setContentType(multipartFile.getContentType());
        try {
            parameter.setInputStream(multipartFile.getInputStream());
        }
        catch (Exception e){
            throw new BusinessException("上次失败");
        }

        DetachedFile detachedFile = detachedFileService.upload(parameter);

        return new Response<>(detachedFile);
    }

    @ApiOperation(value = "文件下载")
    @GetMapping(value = "/file/download")
    public ResponseEntity<byte[]> download(StorageFileFileDownloadWebRequest request, HttpServletRequest httpServletRequest) throws Exception{
        StorageFileGetParameter parameter = new StorageFileGetParameter();
        BeanUtils.copyProperties(request, parameter);

        StorageFile storageFile = storageFileService.get(parameter);
        String name = storageFile.getName();
        String extension = storageFile.getExtension();
        if(StringUtils.hasText(extension)){
            extension = "." + storageFile.getExtension();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" +  URLEncoder.encode(name, "UTF-8") + extension);
        HttpStatus statusCode = HttpStatus.OK;

        InputStream inputStream = storageFile.getInputStream();
        ResponseEntity<byte[]> entity = new ResponseEntity<>(IOUtils.toByteArray(inputStream), headers, statusCode);
        return entity;
    }

}

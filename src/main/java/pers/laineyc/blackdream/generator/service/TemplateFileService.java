package pers.laineyc.blackdream.generator.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.TemplateFile;
import java.util.List; 

/**
 * 生成器模板文件Service
 * @author LaineyC
 */
public interface TemplateFileService extends Service{

    /**
     * 生成器模板文件创建
     */
    TemplateFile create(TemplateFileCreateParameter parameter);

    /**
     * 生成器模板文件删除
     */
    TemplateFile delete(TemplateFileDeleteParameter parameter);
    
    /**
     * 生成器模板文件修改
     */
    TemplateFile update(TemplateFileUpdateParameter parameter);
    
    /**
     * 生成器模板文件单个查询
     */
    TemplateFile get(TemplateFileGetParameter parameter);

    /**
     * 生成器模板文件多个查询
     */
    List<TemplateFile> query(TemplateFileQueryParameter parameter);

    /**
     * 生成器模板文件分页查询
     */
    PageResult<TemplateFile> search(TemplateFileSearchParameter parameter);

    /**
     * 生成器模板文件排序
     */
    TemplateFile sort(TemplateFileSortParameter parameter);

    /**
     * 生成器模板文件多个查询
     */
    List<TemplateFile> infoQuery(TemplateFileInfoQueryParameter parameter);

    /**
     * 构建资源
     */
    void buildResource(TemplateFileBuildResourceParameter parameter);
    
}
package pers.laineyc.blackdream.foundation.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileGetParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileQueryParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileSearchParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileUploadParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFilePersistParameter;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import java.util.List; 

/**
 * 游离文件Service
 * @author LaineyC
 */
public interface DetachedFileService extends Service{

    /**
     * 游离文件单个查询
     */
    DetachedFile get(DetachedFileGetParameter parameter);

    /**
     * 游离文件多个查询
     */
    List<DetachedFile> query(DetachedFileQueryParameter parameter);

    /**
     * 游离文件分页查询
     */
    PageResult<DetachedFile> search(DetachedFileSearchParameter parameter);

    /**
     * 游离文件上传
     */
    DetachedFile upload(DetachedFileUploadParameter parameter);
    
    /**
     * 游离文件处理
     */
    DetachedFile persist(DetachedFilePersistParameter parameter);
    
}
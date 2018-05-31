package pers.laineyc.blackdream.foundation.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileGetParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileQueryParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileSearchParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileUploadParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFilePersistParameter;
import pers.laineyc.blackdream.foundation.dao.DetachedFileDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;

/**
 * 游离文件ServiceTool
 * @author LaineyC
 */
@Component
public class DetachedFileServiceTool{

    @Autowired
    private DetachedFileDao detachedFileDao;

    @Autowired
    private UserDao userDao;

    public DetachedFileServiceTool() {

	}

    /**
     * 游离文件单个查询Validate
     */
    public void getValidate(DetachedFileGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 游离文件多个查询Validate
     */
    public void queryValidate(DetachedFileQueryParameter parameter) {

    }

    /**
     * 游离文件分页查询Validate
     */
    public void searchValidate(DetachedFileSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }

    /**
     * 游离文件上传Validate
     */
    public void uploadValidate(DetachedFileUploadParameter parameter) {
       
    }
    
    /**
     * 游离文件处理Validate
     */
    public void handleValidate(DetachedFilePersistParameter parameter) {
       
    }
    
}
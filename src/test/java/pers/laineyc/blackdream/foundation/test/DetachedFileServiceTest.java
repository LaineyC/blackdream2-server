package pers.laineyc.blackdream.foundation.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.foundation.service.DetachedFileService;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileGetParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileQueryParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileSearchParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFileUploadParameter;
import pers.laineyc.blackdream.foundation.service.parameter.DetachedFilePersistParameter;
import pers.laineyc.blackdream.foundation.service.domain.DetachedFile;
import java.util.List;

/**
 * 游离文件ServiceTest
 * @author LaineyC
 */
public class DetachedFileServiceTest extends BaseServiceTest {

    @Autowired
    private DetachedFileService detachedFileService;
    
    public DetachedFileServiceTest(){

    }

    /**
     * 游离文件单个查询Test
     */
    @Test
    public void get(){
        DetachedFileGetParameter parameter = new DetachedFileGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId(0L);
        DetachedFile detachedFile = detachedFileService.get(parameter);
        Assert.assertNotNull(detachedFile);
    }

    /**
     * 游离文件多个查询Test
     */
    @Test
    public void query() {
        DetachedFileQueryParameter parameter = new DetachedFileQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId(0L);
        parameter.setSize(0L);
        parameter.setName("");
        parameter.setExtension("");
        parameter.setContentType("");
        List<DetachedFile> list = detachedFileService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 游离文件分页查询Test
     */
    @Test
    public void search() {
        DetachedFileSearchParameter parameter = new DetachedFileSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId(0L);
        parameter.setSize(0L);
        parameter.setName("");
        parameter.setExtension("");
        parameter.setContentType("");
        PageResult<DetachedFile> pageResult = detachedFileService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 游离文件上传Test
     */
    @Test
    public void upload() {
        DetachedFileUploadParameter parameter = new DetachedFileUploadParameter();
        parameter.setAuth(getAuth());
        DetachedFile detachedFile = detachedFileService.upload(parameter);
        Assert.assertNotNull(detachedFile);
    }

    /**
     * 游离文件处理Test
     */
    @Test
    public void persist() {
        DetachedFilePersistParameter parameter = new DetachedFilePersistParameter();
        parameter.setAuth(getAuth());
        DetachedFile detachedFile = detachedFileService.persist(parameter);
        Assert.assertNotNull(detachedFile);
    }

}
package pers.laineyc.blackdream.foundation.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.foundation.action.web.request.DetachedFileGetWebRequest;
import pers.laineyc.blackdream.foundation.action.web.response.DetachedFileGetWebResponse;
import pers.laineyc.blackdream.foundation.action.web.request.DetachedFileQueryWebRequest;
import pers.laineyc.blackdream.foundation.action.web.response.DetachedFileQueryWebResponse;
import pers.laineyc.blackdream.foundation.action.web.request.DetachedFileSearchWebRequest;
import pers.laineyc.blackdream.foundation.action.web.response.DetachedFileSearchWebResponse;
import pers.laineyc.blackdream.foundation.action.web.request.DetachedFileUploadWebRequest;
import pers.laineyc.blackdream.foundation.action.web.response.DetachedFileUploadWebResponse;
import pers.laineyc.blackdream.foundation.action.web.request.StorageFileFileDownloadWebRequest;

/**
 * 游离文件ControllerTest
 * @author LaineyC
 */
public class DetachedFileWebControllerTest extends BaseWebControllerTest {

    public DetachedFileWebControllerTest(){

    }

    /**
     * 游离文件单个查询Test
     */
    @Test
    public void get() throws Exception {
        DetachedFileGetWebRequest request = new DetachedFileGetWebRequest();
        request.setId(0L);
        DetachedFileGetWebResponse response = execute(request, DetachedFileGetWebResponse.class, "/detachedFile/get");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 游离文件多个查询Test
     */
    @Test
    public void query() throws Exception {
        DetachedFileQueryWebRequest request = new DetachedFileQueryWebRequest();
        request.setUserId(0L);
        request.setSize(0L);
        request.setName("");
        request.setExtension("");
        request.setContentType("");
        DetachedFileQueryWebResponse response = execute(request, DetachedFileQueryWebResponse.class, "/detachedFile/query");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 游离文件分页查询Test
     */
    @Test
    public void search() throws Exception {
        DetachedFileSearchWebRequest request = new DetachedFileSearchWebRequest();
        request.setPage(1);
        request.setPageSize(10);
        request.setUserId(0L);
        request.setSize(0L);
        request.setName("");
        request.setExtension("");
        request.setContentType("");
        DetachedFileSearchWebResponse response = execute(request, DetachedFileSearchWebResponse.class, "/detachedFile/search");
        Assert.assertNotNull(response.getBody());
    }

    /**
     * 游离文件上传Test
     */
    @Test
    public void upload() throws Exception {
        DetachedFileUploadWebRequest request = new DetachedFileUploadWebRequest();
        DetachedFileUploadWebResponse response = execute(request, DetachedFileUploadWebResponse.class, "/detachedFile/upload");
        Assert.assertNotNull(response.getBody());
    }

}
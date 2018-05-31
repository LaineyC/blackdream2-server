package pers.laineyc.blackdream.generator.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.TemplateFileSortParameter;
import pers.laineyc.blackdream.generator.service.domain.TemplateFile;
import java.util.List; 
import java.util.Date; 

/**
 * 生成器模板文件ServiceTest
 * @author LaineyC
 */
public class TemplateFileServiceTest extends BaseServiceTest {

    @Autowired
    private TemplateFileService templateFileService;
    
    public TemplateFileServiceTest(){

    }

    /**
     * 生成器模板文件创建Test
     */
    @Test
    public void create() {
        TemplateFileCreateParameter parameter = new TemplateFileCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setCode("");
        parameter.setEngineType(0);
        parameter.setDisplayGroup("");
        parameter.setDescription("");
        TemplateFile templateFile = templateFileService.create(parameter);
        Assert.assertNotNull(templateFile);
    }
    
    /**
     * 生成器模板文件删除Test
     */
    @Test
    public void delete() {
        TemplateFileDeleteParameter parameter = new TemplateFileDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        TemplateFile templateFile = templateFileService.delete(parameter);
        Assert.assertNotNull(templateFile);
    }

    /**
     * 生成器模板文件修改Test
     */
    @Test
    public void update() {
        TemplateFileUpdateParameter parameter = new TemplateFileUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        parameter.setName("");
        parameter.setCode("");
        parameter.setEngineType(0);
        parameter.setDisplayGroup("");
        parameter.setDescription("");
        TemplateFile templateFile = templateFileService.update(parameter);
        Assert.assertNotNull(templateFile);
    }
    
    /**
     * 生成器模板文件单个查询Test
     */
    @Test
    public void get(){
        TemplateFileGetParameter parameter = new TemplateFileGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        TemplateFile templateFile = templateFileService.get(parameter);
        Assert.assertNotNull(templateFile);
    }

    /**
     * 生成器模板文件多个查询Test
     */
    @Test
    public void query() {
        TemplateFileQueryParameter parameter = new TemplateFileQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setCode("");
        parameter.setEngineType(0);
        parameter.setDisplayGroup("");
        List<TemplateFile> list = templateFileService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 生成器模板文件分页查询Test
     */
    @Test
    public void search() {
        TemplateFileSearchParameter parameter = new TemplateFileSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setUserId("");
        parameter.setGeneratorId("");
        parameter.setName("");
        parameter.setCode("");
        parameter.setEngineType(0);
        parameter.setDisplayGroup("");
        PageResult<TemplateFile> pageResult = templateFileService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 生成器模板文件排序Test
     */
    @Test
    public void sort() {
        TemplateFileSortParameter parameter = new TemplateFileSortParameter();
        parameter.setAuth(getAuth());
        TemplateFile templateFile = templateFileService.sort(parameter);
        Assert.assertNotNull(templateFile);
    }

}
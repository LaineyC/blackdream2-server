package pers.laineyc.blackdream.foundation.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.foundation.service.ValidCodeService;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeCreateParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeDeleteParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeGetParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeQueryParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeSearchParameter;
import pers.laineyc.blackdream.foundation.service.parameter.ValidCodeCheckParameter;
import pers.laineyc.blackdream.foundation.service.domain.ValidCode;
import java.util.List; 

/**
 * 验证码ServiceTest
 * @author LaineyC
 */
public class ValidCodeServiceTest extends BaseServiceTest {

    @Autowired
    private ValidCodeService validCodeService;
    
    public ValidCodeServiceTest(){

    }

    /**
     * 验证码创建Test
     */
    @Test
    public void create() {
        ValidCodeCreateParameter parameter = new ValidCodeCreateParameter();
        parameter.setAuth(getAuth());
        parameter.setType(0);
        parameter.setPlatformType(0);
        parameter.setPlatformAccount("");
        parameter.setCode("");
        parameter.setInterval(0);
        parameter.setTimeout(0);
        parameter.setFailCount(0);
        parameter.setMaxFailCount(0);
        ValidCode validCode = validCodeService.create(parameter);
        Assert.assertNotNull(validCode);
    }
    
    /**
     * 验证码删除Test
     */
    @Test
    public void delete() {
        ValidCodeDeleteParameter parameter = new ValidCodeDeleteParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        ValidCode validCode = validCodeService.delete(parameter);
        Assert.assertNotNull(validCode);
    }

    /**
     * 验证码修改Test
     */
    @Test
    public void update() {
        ValidCodeUpdateParameter parameter = new ValidCodeUpdateParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        parameter.setType(0);
        parameter.setPlatformType(0);
        parameter.setPlatformAccount("");
        parameter.setCode("");
        parameter.setInterval(0);
        parameter.setTimeout(0);
        parameter.setFailCount(0);
        parameter.setMaxFailCount(0);
        ValidCode validCode = validCodeService.update(parameter);
        Assert.assertNotNull(validCode);
    }
    
    /**
     * 验证码单个查询Test
     */
    @Test
    public void get(){
        ValidCodeGetParameter parameter = new ValidCodeGetParameter();
        parameter.setAuth(getAuth());
        parameter.setId("");
        ValidCode validCode = validCodeService.get(parameter);
        Assert.assertNotNull(validCode);
    }

    /**
     * 验证码多个查询Test
     */
    @Test
    public void query() {
        ValidCodeQueryParameter parameter = new ValidCodeQueryParameter();
        parameter.setAuth(getAuth());
        parameter.setType(0);
        parameter.setPlatformType(0);
        parameter.setPlatformAccount("");
        parameter.setCode("");
        parameter.setInterval(0);
        parameter.setTimeout(0);
        parameter.setFailCount(0);
        parameter.setMaxFailCount(0);
        List<ValidCode> list = validCodeService.query(parameter);
        Assert.assertNotNull(list);
    }

    /**
     * 验证码分页查询Test
     */
    @Test
    public void search() {
        ValidCodeSearchParameter parameter = new ValidCodeSearchParameter();
        parameter.setAuth(getAuth());
        parameter.setPage(1);
        parameter.setPageSize(10);
        parameter.setType(0);
        parameter.setPlatformType(0);
        parameter.setPlatformAccount("");
        parameter.setCode("");
        parameter.setInterval(0);
        parameter.setTimeout(0);
        parameter.setFailCount(0);
        parameter.setMaxFailCount(0);
        PageResult<ValidCode> pageResult = validCodeService.search(parameter);
        Assert.assertNotNull(pageResult);
    }

    /**
     * 验证码验证有效Test
     */
    @Test
    public void check() {
        ValidCodeCheckParameter parameter = new ValidCodeCheckParameter();
        parameter.setAuth(getAuth());
        ValidCode validCode = validCodeService.check(parameter);
        Assert.assertNotNull(validCode);
    }

}
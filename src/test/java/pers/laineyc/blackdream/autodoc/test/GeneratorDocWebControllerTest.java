package pers.laineyc.blackdream.autodoc.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.autodoc.service.domain.*;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.autodoc.action.web.request.GeneratorDocMakeWebRequest;
import pers.laineyc.blackdream.framework.controller.response.Response;

/**
 * 生成器文档ControllerTest
 * @author LaineyC
 */
public class GeneratorDocWebControllerTest extends BaseWebControllerTest {

    public GeneratorDocWebControllerTest(){

    }

    /**
     * 生成器文档生成Test
     */
    @Test
    public void make() throws Exception {
        GeneratorDocMakeWebRequest request = new GeneratorDocMakeWebRequest();
        Response<GeneratorDoc> response = execute(request, GeneratorDoc.class, "/generatorDoc/make");
        Assert.assertNotNull(response.getBody());
    }

}
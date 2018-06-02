package pers.laineyc.blackdream.autodoc.test;

import org.junit.Test;
import org.junit.Assert;
import pers.laineyc.blackdream.framework.controller.BaseWebControllerTest;
import pers.laineyc.blackdream.autodoc.action.web.request.GeneratorDocMakeWebRequest;
import pers.laineyc.blackdream.autodoc.action.web.response.GeneratorDocMakeWebResponse;
import java.util.Date; 

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
        GeneratorDocMakeWebResponse response = execute(request, GeneratorDocMakeWebResponse.class, "/generatorDoc/make");
        Assert.assertNotNull(response.getBody());
    }

}
package pers.laineyc.blackdream.autodoc.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.service.BaseServiceTest;
import pers.laineyc.blackdream.autodoc.service.GeneratorDocService;
import pers.laineyc.blackdream.autodoc.service.parameter.GeneratorDocMakeParameter;
import pers.laineyc.blackdream.autodoc.service.domain.GeneratorDoc;
import java.util.Date; 

/**
 * 生成器文档ServiceTest
 * @author LaineyC
 */
public class GeneratorDocServiceTest extends BaseServiceTest {

    @Autowired
    private GeneratorDocService generatorDocService;
    
    public GeneratorDocServiceTest(){

    }

    /**
     * 生成器文档生成Test
     */
    @Test
    public void make() {
        GeneratorDocMakeParameter parameter = new GeneratorDocMakeParameter();
        parameter.setAuth(getAuth());
        GeneratorDoc generatorDoc = generatorDocService.make(parameter);
        Assert.assertNotNull(generatorDoc);
    }

}
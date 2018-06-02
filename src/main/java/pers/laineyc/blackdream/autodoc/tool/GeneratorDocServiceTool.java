package pers.laineyc.blackdream.autodoc.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.autodoc.service.parameter.GeneratorDocMakeParameter;
import pers.laineyc.blackdream.autodoc.service.domain.GeneratorDoc;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.util.Date; 

/**
 * 生成器文档ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorDocServiceTool{

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    public GeneratorDocServiceTool() {

	}

    /**
     * 生成器文档生成Validate
     */
    public void makeValidate(GeneratorDocMakeParameter parameter) {
       
    }
    
}
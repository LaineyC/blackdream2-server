package pers.laineyc.blackdream.autodoc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.autodoc.service.GeneratorDocService;
import pers.laineyc.blackdream.autodoc.tool.GeneratorDocServiceTool;
import pers.laineyc.blackdream.autodoc.service.parameter.GeneratorDocMakeParameter;
import pers.laineyc.blackdream.autodoc.service.domain.GeneratorDoc;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.util.Date; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 生成器文档ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorDocServiceImpl extends BaseService implements GeneratorDocService {

    @Autowired
    private GeneratorDocServiceTool generatorDocServiceTool;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    public GeneratorDocServiceImpl() {

	}

    /**
     * 生成器文档生成
     */
    @Transactional
    public GeneratorDoc make(GeneratorDocMakeParameter parameter) {
        generatorDocServiceTool.makeValidate(parameter);
    
        Auth auth = parameter.getAuth();

        GeneratorDoc generatorDoc = new GeneratorDoc();

        return generatorDoc;
    }
    
}
package pers.laineyc.blackdream.autodoc.service;

import pers.laineyc.blackdream.framework.service.Service;
import pers.laineyc.blackdream.autodoc.service.parameter.GeneratorDocMakeParameter;
import pers.laineyc.blackdream.autodoc.service.domain.GeneratorDoc;

/**
 * 生成器文档Service
 * @author LaineyC
 */
public interface GeneratorDocService extends Service{

    /**
     * 生成器文档生成
     */
    GeneratorDoc make(GeneratorDocMakeParameter parameter);
    
}
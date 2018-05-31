package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.GeneratorGuideDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorGuidePo;

/**
 * 生成器指南Dao
 * @author LaineyC
 */
@Repository
public class GeneratorGuideDaoImpl extends MongoBaseDao<GeneratorGuidePo, String> implements GeneratorGuideDao{

}
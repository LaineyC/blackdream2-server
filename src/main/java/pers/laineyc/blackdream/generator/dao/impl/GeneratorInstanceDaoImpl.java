package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstancePo;

/**
 * 生成器实例Dao
 * @author LaineyC
 */
@Repository
public class GeneratorInstanceDaoImpl extends MongoBaseDao<GeneratorInstancePo, String> implements GeneratorInstanceDao{

}
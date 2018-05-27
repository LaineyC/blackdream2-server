package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;

/**
 * 生成器Dao
 * @author LaineyC
 */
@Repository
public class GeneratorDaoImpl extends MongoBaseDao<GeneratorPo, Long> implements GeneratorDao{

}
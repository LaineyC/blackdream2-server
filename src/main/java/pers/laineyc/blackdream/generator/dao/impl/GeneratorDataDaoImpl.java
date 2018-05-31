package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.GeneratorDataDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorDataPo;

/**
 * 生成器数据Dao
 * @author LaineyC
 */
@Repository
public class GeneratorDataDaoImpl extends MongoBaseDao<GeneratorDataPo, String> implements GeneratorDataDao{

}
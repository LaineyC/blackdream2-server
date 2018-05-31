package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceConfigDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstanceConfigPo;

/**
 * 生成器实例用户设置Dao
 * @author LaineyC
 */
@Repository
public class GeneratorInstanceConfigDaoImpl extends MongoBaseDao<GeneratorInstanceConfigPo, String> implements GeneratorInstanceConfigDao{

}
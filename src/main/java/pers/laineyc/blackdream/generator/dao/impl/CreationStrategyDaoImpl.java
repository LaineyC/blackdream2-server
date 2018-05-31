package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.CreationStrategyDao;
import pers.laineyc.blackdream.generator.dao.po.CreationStrategyPo;

/**
 * 生成器生成策略Dao
 * @author LaineyC
 */
@Repository
public class CreationStrategyDaoImpl extends MongoBaseDao<CreationStrategyPo, String> implements CreationStrategyDao{

}
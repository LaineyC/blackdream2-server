package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.DataModelDao;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;

/**
 * 生成器数据模型Dao
 * @author LaineyC
 */
@Repository
public class DataModelDaoImpl extends MongoBaseDao<DataModelPo, Long> implements DataModelDao{

}
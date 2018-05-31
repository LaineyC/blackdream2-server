package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.DataModelSchemaDao;
import pers.laineyc.blackdream.generator.dao.po.DataModelSchemaPo;

/**
 * 生成器数据模型模式Dao
 * @author LaineyC
 */
@Repository
public class DataModelSchemaDaoImpl extends MongoBaseDao<DataModelSchemaPo, String> implements DataModelSchemaDao{

}
package pers.laineyc.blackdream.foundation.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.foundation.dao.ValidCodeDao;
import pers.laineyc.blackdream.foundation.dao.po.ValidCodePo;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;

/**
 * 验证码Dao
 * @author LaineyC
 */
@Repository
public class ValidCodeDaoImpl extends MongoBaseDao<ValidCodePo, String> implements ValidCodeDao{

}
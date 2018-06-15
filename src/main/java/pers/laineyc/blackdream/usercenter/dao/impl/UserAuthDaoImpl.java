package pers.laineyc.blackdream.usercenter.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.usercenter.dao.UserAuthDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserAuthPo;

/**
 * 用户认证Dao
 * @author LaineyC
 */
@Repository
public class UserAuthDaoImpl extends MongoBaseDao<UserAuthPo, String> implements UserAuthDao{

}
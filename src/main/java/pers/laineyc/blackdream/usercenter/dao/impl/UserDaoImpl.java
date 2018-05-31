package pers.laineyc.blackdream.usercenter.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;

/**
 * 用户Dao
 * @author LaineyC
 */
@Repository
public class UserDaoImpl extends MongoBaseDao<UserPo, String> implements UserDao{

}
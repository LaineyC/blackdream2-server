package pers.laineyc.blackdream.foundation.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.foundation.dao.DetachedFileDao;
import pers.laineyc.blackdream.foundation.dao.po.DetachedFilePo;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;

/**
 * 用户Dao
 * @author LaineyC
 */
@Repository
public class DetachedFileDaoImpl extends MongoBaseDao<DetachedFilePo, Long> implements DetachedFileDao{

}
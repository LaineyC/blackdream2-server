package pers.laineyc.blackdream.generator.dao.impl;

import org.springframework.stereotype.Repository;
import pers.laineyc.blackdream.framework.dao.support.mongo.MongoBaseDao;
import pers.laineyc.blackdream.generator.dao.TemplateFileDao;
import pers.laineyc.blackdream.generator.dao.po.TemplateFilePo;

/**
 * 生成器模板文件Dao
 * @author LaineyC
 */
@Repository
public class TemplateFileDaoImpl extends MongoBaseDao<TemplateFilePo, Long> implements TemplateFileDao{

}
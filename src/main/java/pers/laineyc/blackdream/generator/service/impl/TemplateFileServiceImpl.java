package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.util.FileUtil;
import pers.laineyc.blackdream.generator.constant.TemplateEngineTypeEnum;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.TemplateFileServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.TemplateFile;
import pers.laineyc.blackdream.generator.dao.po.TemplateFilePo;
import pers.laineyc.blackdream.generator.dao.query.TemplateFileQuery;
import pers.laineyc.blackdream.generator.dao.TemplateFileDao;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Date; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 生成器模板文件ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class TemplateFileServiceImpl extends BaseService implements TemplateFileService {

    @Autowired
    private TemplateFileServiceTool templateFileServiceTool;

    @Autowired
    private TemplateFileDao templateFileDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private SequenceService sequenceService;

    public TemplateFileServiceImpl() {

	}

    /**
     * 生成器模板文件创建
     */
    @Transactional
    public TemplateFile create(TemplateFileCreateParameter parameter) {
        templateFileServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();
    
        TemplateFilePo templateFilePo = new TemplateFilePo();

        templateFilePo.setId(id);
        
        templateFilePo.setUserId(authUserId);

        Long generatorId = parameter.getGeneratorId();
        templateFilePo.setGeneratorId(generatorId);

        String name = parameter.getName();
        templateFilePo.setName(name);

        Integer engineType = parameter.getEngineType();
        templateFilePo.setEngineType(engineType);

        String code = parameter.getCode();
        if(!StringUtils.hasText(code)){
            TemplateEngineTypeEnum templateEngineTypeEnum = TemplateEngineTypeEnum.value(engineType);
            code = id.toString() + "." + templateEngineTypeEnum.getSuffix();
        }
        templateFilePo.setCode(code);

        String displayGroup = parameter.getDisplayGroup();
        templateFilePo.setDisplayGroup(displayGroup);

        templateFilePo.setDisplayOrder(1000);

        String description = parameter.getDescription();
        templateFilePo.setDescription(description);

        templateFilePo.setIsDeleted(false);

        templateFilePo.setCreateTime(now);

        String script = parameter.getScript();
        templateFilePo.setScript(script);

        templateFileDao.insert(templateFilePo);

        TemplateFile templateFile = new TemplateFile();
        templateFile.setId(templateFilePo.getId());

        return templateFile;
    }

    /**
     * 生成器模板文件删除
     */
    @Transactional
    public TemplateFile delete(TemplateFileDeleteParameter parameter) {
        templateFileServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null){
            throw new BusinessException("生成器模板文件不存在");
        }
        if(!templateFilePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        TemplateFilePo templateFilePoUpdate = new TemplateFilePo();
        templateFilePoUpdate.setId(id);
        templateFilePoUpdate.setUpdateTime(now);
        templateFilePoUpdate.setIsDeleted(true);
        templateFileDao.updateSelective(templateFilePoUpdate);

        TemplateFile templateFile = new TemplateFile();
        templateFile.setId(id);

        return templateFile;
    }
    
    /**
     * 生成器模板文件修改
     */
    @Transactional
    public TemplateFile update(TemplateFileUpdateParameter parameter) {
        templateFileServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null){
            throw new BusinessException("生成器模板文件不存在");
        }
        if(!templateFilePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        String name = parameter.getName();
        templateFilePo.setName(name);

        Integer engineType = parameter.getEngineType();
        templateFilePo.setEngineType(engineType);

        String code = parameter.getCode();
        if(!StringUtils.hasText(code)){
            TemplateEngineTypeEnum templateEngineTypeEnum = TemplateEngineTypeEnum.value(engineType);
            code = id.toString() + "." + templateEngineTypeEnum.getSuffix();
        }
        templateFilePo.setCode(code);

        String displayGroup = parameter.getDisplayGroup();
        templateFilePo.setDisplayGroup(displayGroup);

        String description = parameter.getDescription();
        templateFilePo.setDescription(description);

        templateFilePo.setUpdateTime(now);

        String script = parameter.getScript();
        templateFilePo.setScript(script);

        templateFileDao.update(templateFilePo);

        TemplateFile templateFile = new TemplateFile();
        templateFile.setId(id);

        return templateFile;
    }
    
    /**
     * 生成器模板文件单个查询
     */
    //@Transactional(readOnly = true)
    public TemplateFile get(TemplateFileGetParameter parameter) {
        templateFileServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null) {
            throw new BusinessException("生成器模板文件不存在");
        }

        TemplateFile templateFile = new TemplateFile();
        
        templateFile.setId(templateFilePo.getId());

        Long userId = templateFilePo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                templateFile.setUser(user);
            }
        }

        Long generatorId = templateFilePo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                templateFile.setGenerator(generator);
            }
        }

        templateFile.setName(templateFilePo.getName());

        templateFile.setCode(templateFilePo.getCode());

        templateFile.setEngineType(templateFilePo.getEngineType());

        templateFile.setDisplayGroup(templateFilePo.getDisplayGroup());

        templateFile.setDisplayOrder(templateFilePo.getDisplayOrder());

        templateFile.setDescription(templateFilePo.getDescription());

        templateFile.setCreateTime(templateFilePo.getCreateTime());

        templateFile.setUpdateTime(templateFilePo.getUpdateTime());

        templateFile.setScript(templateFilePo.getScript());

        return templateFile;
    }

    /**
     * 生成器模板文件多个查询
     */
    //@Transactional(readOnly = true)
    public List<TemplateFile> query(TemplateFileQueryParameter parameter) {
        templateFileServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setUserId(parameter.getUserId());
        templateFileQuery.setGeneratorId(parameter.getGeneratorId());
        templateFileQuery.setName(parameter.getName());
        templateFileQuery.setCode(parameter.getCode());
        templateFileQuery.setEngineType(parameter.getEngineType());
        templateFileQuery.setDisplayGroup(parameter.getDisplayGroup());

        List<TemplateFilePo> templateFilePoList = templateFileDao.selectList(templateFileQuery);

        List<TemplateFile> templateFileList = new ArrayList<>();
        if(templateFilePoList.isEmpty()){
            return templateFileList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        templateFilePoList.forEach(po -> {
            TemplateFile templateFile = new TemplateFile();
            
            templateFile.setId(po.getId());

            Long userId = po.getUserId();
            if(userId != null) {
                User user;
                if(userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                }
                else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                templateFile.setUser(user);
            }

            Long generatorId = po.getGeneratorId();
            if(generatorId != null) {
                Generator generator;
                if(generatorMap.containsKey(generatorId)) {
                    generator = generatorMap.get(generatorId);
                }
                else {
                    generator = new Generator();
                    generator.setId(generatorId);
                    generatorMap.put(generatorId, generator);
                }
                templateFile.setGenerator(generator);
            }

            templateFile.setName(po.getName());

            templateFile.setCode(po.getCode());

            templateFile.setEngineType(po.getEngineType());

            templateFile.setDisplayGroup(po.getDisplayGroup());

            templateFile.setDisplayOrder(po.getDisplayOrder());

            templateFile.setDescription(po.getDescription());

            templateFile.setCreateTime(po.getCreateTime());

            templateFile.setUpdateTime(po.getUpdateTime());

            templateFileList.add(templateFile);
        });
        
        if(!userMap.isEmpty()){
            List<UserPo> userPos = userDao.selectByIds(userMap.keySet());
            userPos.forEach(po -> {
                Long id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            List<GeneratorPo> generatorPos = generatorDao.selectByIds(generatorMap.keySet());
            generatorPos.forEach(po -> {
                Long id = po.getId();
                Generator generator = generatorMap.get(id);
                generator.setId(id);
            });
        }

        return templateFileList;
    }

    /**
     * 生成器模板文件分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<TemplateFile> search(TemplateFileSearchParameter parameter) {
        templateFileServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<TemplateFile> pageResult = new PageResult<>();
        List<TemplateFile> records = pageResult.getRecords();

        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setUserId(parameter.getUserId());
        templateFileQuery.setGeneratorId(parameter.getGeneratorId());
        templateFileQuery.setName(parameter.getName());
        templateFileQuery.setCode(parameter.getCode());
        templateFileQuery.setEngineType(parameter.getEngineType());
        templateFileQuery.setDisplayGroup(parameter.getDisplayGroup());
        templateFileQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<TemplateFilePo> templateFilePoPageResult = templateFileDao.selectPage(templateFileQuery);
        pageResult.setTotal(templateFilePoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        templateFilePoPageResult.getRecords().forEach(po -> {
            TemplateFile templateFile = new TemplateFile();
            
            templateFile.setId(po.getId());

            Long userId = po.getUserId();
            if(userId != null) {
                User user;
                if(userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                }
                else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                templateFile.setUser(user);
            }

            Long generatorId = po.getGeneratorId();
            if(generatorId != null) {
                Generator generator;
                if(generatorMap.containsKey(generatorId)) {
                    generator = generatorMap.get(generatorId);
                }
                else {
                    generator = new Generator();
                    generator.setId(generatorId);
                    generatorMap.put(generatorId, generator);
                }
                templateFile.setGenerator(generator);
            }

            templateFile.setName(po.getName());

            templateFile.setCode(po.getCode());

            templateFile.setEngineType(po.getEngineType());

            templateFile.setDisplayGroup(po.getDisplayGroup());

            templateFile.setDisplayOrder(po.getDisplayOrder());

            templateFile.setDescription(po.getDescription());

            templateFile.setCreateTime(po.getCreateTime());

            templateFile.setUpdateTime(po.getUpdateTime());

            records.add(templateFile);
        });

        if(!userMap.isEmpty()){
            List<UserPo> userPos = userDao.selectByIds(userMap.keySet());
            userPos.forEach(po -> {
                Long id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            List<GeneratorPo> generatorPos = generatorDao.selectByIds(generatorMap.keySet());
            generatorPos.forEach(po -> {
                Long id = po.getId();
                Generator generator = generatorMap.get(id);
                generator.setId(id);
            });
        }

        return pageResult;
    }

    /**
     * 生成器模板文件排序
     */
    @Transactional
    public TemplateFile sort(TemplateFileSortParameter parameter) {
        templateFileServiceTool.sortValidate(parameter);
    
        Auth auth = parameter.getAuth();

        TemplateFile templateFile = new TemplateFile();

        return templateFile;
    }

    /**
     * 生成器模板文件分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<TemplateFile> infoSearch(TemplateFileInfoSearchParameter parameter) {
        templateFileServiceTool.infoSearchValidate(parameter);

        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        TemplateFileSearchParameter templateFileSearchParameter = new TemplateFileSearchParameter();
        BeanUtils.copyProperties(parameter, templateFileSearchParameter);
        templateFileSearchParameter.setUserId(authUserId);

        return this.search(templateFileSearchParameter);
    }

    /**
     * 构建资源
     */
    //@Transactional(readOnly = true)
    public void buildResource(TemplateFileBuildResourceParameter parameter) {
        templateFileServiceTool.buildResourceValidate(parameter);

        Auth auth = parameter.getAuth();

        Long generatorId = parameter.getGeneratorId();

        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setGeneratorId(generatorId);

        List<TemplateFilePo> templateFilePoList = templateFileDao.selectList(templateFileQuery);
        templateFilePoList.forEach(templateFilePo -> {
            String code = templateFilePo.getCode();
            Path path = Paths.get(templateFileServiceTool.getScriptPath(templateFilePo.getGeneratorId(), code));

            Path parentPath = path.getParent();
            FileUtil.create(parentPath);

            String script = templateFilePo.getScript();
            FileUtil.writeString(path, script);
        });
    }

}
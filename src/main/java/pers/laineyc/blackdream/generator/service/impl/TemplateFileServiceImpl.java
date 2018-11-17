package pers.laineyc.blackdream.generator.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.framework.dao.query.Order;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.framework.util.FileUtil;
import pers.laineyc.blackdream.generator.constant.TemplateEngineTypeEnum;
import pers.laineyc.blackdream.generator.service.GeneratorService;
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
    private GeneratorService generatorService;

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
        String authUserId = auth.getUserId();

        TemplateFilePo templateFilePo = new TemplateFilePo();

        templateFilePo.setUserId(authUserId);

        String generatorId = parameter.getGeneratorId();
        templateFilePo.setGeneratorId(generatorId);

        String name = parameter.getName();
        templateFilePo.setName(name);

        Integer engineType = parameter.getEngineType();
        templateFilePo.setEngineType(engineType);

        String code = ObjectId.get().toString();
        templateFilePo.setCode(code);

        String displayGroup = parameter.getDisplayGroup();
        templateFilePo.setDisplayGroup(displayGroup);

        templateFilePo.setDisplayOrder(1000);

        String description = parameter.getDescription();
        templateFilePo.setDescription(description);

        templateFilePo.setIsDeleted(false);

        templateFilePo.setCreateTime(now);

        templateFilePo.setUpdateTime(now);

        String script = parameter.getScript();
        templateFilePo.setScript(script);

        templateFileDao.insert(templateFilePo);

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(generatorId);
        generatorService.develop(generatorDevelopParameter);

        this.buildResource(templateFilePo);

        TemplateFile templateFile = new TemplateFile();
        templateFile.setId(templateFilePo.getId());
        templateFile.setCode(templateFilePo.getCode());

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
        String authUserId = auth.getUserId();

        List<String> idList = parameter.getIdList();
        String id = parameter.getId();
        if(StringUtils.hasText(id)){
            idList.add(id);
        }

        String generatorId = null;
        for(String item : idList){
            TemplateFilePo templateFilePo = templateFileDao.selectById(item);
            if (templateFilePo == null || templateFilePo.getIsDeleted() || !templateFilePo.getUserId().equals(authUserId)) {
                throw new BusinessException("生成器模板文件不存在");
            }

            if(generatorId == null){
                generatorId = templateFilePo.getGeneratorId();
            }
            else if(!generatorId.equals(templateFilePo.getGeneratorId())){
                throw new BusinessException("不属于同一个生成器");
            }
        }

        for(String item : idList){
            TemplateFilePo templateFilePoUpdate = new TemplateFilePo();
            templateFilePoUpdate.setId(item);
            templateFilePoUpdate.setUpdateTime(now);
            templateFilePoUpdate.setIsDeleted(true);
            templateFileDao.updateSelective(templateFilePoUpdate);
        }

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(generatorId);
        generatorService.develop(generatorDevelopParameter);

        TemplateFile templateFile = new TemplateFile();

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
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null || templateFilePo.getIsDeleted() || !templateFilePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        String name = parameter.getName();
        templateFilePo.setName(name);

        Integer engineType = parameter.getEngineType();
        templateFilePo.setEngineType(engineType);
/*
        String code = parameter.getCode();
        if(!StringUtils.hasText(code)){
            code = id;
        }
        templateFilePo.setCode(code);
*/
        String displayGroup = parameter.getDisplayGroup();
        templateFilePo.setDisplayGroup(displayGroup);

        String description = parameter.getDescription();
        templateFilePo.setDescription(description);

        templateFilePo.setUpdateTime(now);

        String script = parameter.getScript();
        templateFilePo.setScript(script);

        templateFileDao.update(templateFilePo);

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(templateFilePo.getGeneratorId());
        generatorService.develop(generatorDevelopParameter);

        this.buildResource(templateFilePo);

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

        String id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null || templateFilePo.getIsDeleted()){
            throw new BusinessException("生成器模板文件不存在");
        }

        TemplateFile templateFile = new TemplateFile();

        templateFile.setId(templateFilePo.getId());

        String userId = templateFilePo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                templateFile.setUser(user);
            }
        }

        String generatorId = templateFilePo.getGeneratorId();
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

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        templateFilePoList.forEach(po -> {
            TemplateFile templateFile = new TemplateFile();

            templateFile.setId(po.getId());

            String userId = po.getUserId();
            if (userId != null) {
                User user;
                if (userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                } else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                templateFile.setUser(user);
            }

            String generatorId = po.getGeneratorId();
            if (generatorId != null) {
                Generator generator;
                if (generatorMap.containsKey(generatorId)) {
                    generator = generatorMap.get(generatorId);
                } else {
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
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                String id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            GeneratorQuery generatorQuery = new GeneratorQuery();
            generatorQuery.setIdList(new ArrayList<>(generatorMap.keySet()));
            List<GeneratorPo> generatorPos = generatorDao.selectList(generatorQuery);
            generatorPos.forEach(po -> {
                String id = po.getId();
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

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        templateFilePoPageResult.getRecords().forEach(po -> {
            TemplateFile templateFile = new TemplateFile();

            templateFile.setId(po.getId());

            String userId = po.getUserId();
            if (userId != null) {
                User user;
                if (userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                } else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                templateFile.setUser(user);
            }

            String generatorId = po.getGeneratorId();
            if (generatorId != null) {
                Generator generator;
                if (generatorMap.containsKey(generatorId)) {
                    generator = generatorMap.get(generatorId);
                } else {
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
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                String id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            GeneratorQuery generatorQuery = new GeneratorQuery();
            generatorQuery.setIdList(new ArrayList<>(generatorMap.keySet()));
            List<GeneratorPo> generatorPos = generatorDao.selectList(generatorQuery);
            generatorPos.forEach(po -> {
                String id = po.getId();
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

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        TemplateFilePo templateFilePo = templateFileDao.selectById(id);
        if(templateFilePo == null || templateFilePo.getIsDeleted() || !templateFilePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setGeneratorId(templateFilePo.getGeneratorId());
        templateFileQuery.orderByDisplayOrder(Order.Direction.ASC);
        List<TemplateFilePo> templateFilePoList = templateFileDao.selectList(templateFileQuery);

        int fromIndex = parameter.getFromIndex();
        int toIndex = parameter.getToIndex();
        int size = templateFilePoList.size();
        if(size == 0 || toIndex > size - 1 || fromIndex > size - 1){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }

        TemplateFilePo templateFilePoRemove = templateFilePoList.remove(fromIndex);
        if(templateFilePoRemove == null || !id.equals(templateFilePoRemove.getId())){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }
        templateFilePoList.add(toIndex, templateFilePoRemove);

        int displayOrder = 1;
        for(TemplateFilePo po : templateFilePoList){
            String poId = po.getId();
            if(po.getDisplayOrder() != displayOrder) {
                TemplateFilePo templateFilePoUpdate = new TemplateFilePo();
                templateFilePoUpdate.setId(poId);
                templateFilePoUpdate.setDisplayOrder(displayOrder);
                templateFilePoUpdate.setUpdateTime(now);
                templateFileDao.updateSelective(templateFilePoUpdate);
            }
            displayOrder++;
        }

        TemplateFile templateFile = new TemplateFile();

        return templateFile;
    }

    /**
     * 生成器模板文件多个查询
     */
    //@Transactional(readOnly = true)
    public List<TemplateFile> infoQuery(TemplateFileInfoQueryParameter parameter) {
        templateFileServiceTool.infoQueryValidate(parameter);

        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        TemplateFileQueryParameter templateFileQueryParameter = new TemplateFileQueryParameter();
        BeanUtils.copyProperties(parameter, templateFileQueryParameter);
        templateFileQueryParameter.setUserId(authUserId);

        return this.query(templateFileQueryParameter);
    }

    /**
     * 构建资源到OS文件系统
     */
    //@Transactional(readOnly = true)
    public void buildResource(TemplateFileBuildResourceParameter parameter) {
        templateFileServiceTool.buildResourceValidate(parameter);

        Auth auth = parameter.getAuth();

        String generatorId = parameter.getGeneratorId();

        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setGeneratorId(generatorId);
        templateFileQuery.fetchLazy(false);

        List<TemplateFilePo> templateFilePoList = templateFileDao.selectList(templateFileQuery);
        templateFilePoList.forEach(this::buildResource);
    }

    private void buildResource(TemplateFilePo templateFilePo){
        Integer engineType = templateFilePo.getEngineType();
        String code = templateFilePo.getCode();
        Path path = Paths.get(templateFileServiceTool.getTemplatePath(templateFilePo.getGeneratorId(), code, engineType));

        Path parentPath = path.getParent();
        FileUtil.create(parentPath);

        String script = templateFilePo.getScript();
        FileUtil.writeString(path, script);
    }

}
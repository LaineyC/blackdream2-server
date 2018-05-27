package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceConfigService;
import pers.laineyc.blackdream.generator.tool.GeneratorInstanceConfigServiceTool;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorInstanceConfigSearchParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstanceConfig;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstanceConfigPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceConfigQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceConfigDao;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstancePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import java.util.List;
import java.util.Date; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 生成器实例设置ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorInstanceConfigServiceImpl extends BaseService implements GeneratorInstanceConfigService {

    @Autowired
    private GeneratorInstanceConfigServiceTool generatorInstanceConfigServiceTool;

    @Autowired
    private GeneratorInstanceConfigDao generatorInstanceConfigDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private SequenceService sequenceService;

    public GeneratorInstanceConfigServiceImpl() {

	}

    /**
     * 生成器实例设置创建
     */
    @Transactional
    public GeneratorInstanceConfig create(GeneratorInstanceConfigCreateParameter parameter) {
        generatorInstanceConfigServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();

        GeneratorInstanceConfigPo generatorInstanceConfigPo = new GeneratorInstanceConfigPo();

        generatorInstanceConfigPo.setId(id);
        
        generatorInstanceConfigPo.setUserId(authUserId);

        Long generatorInstanceId = parameter.getGeneratorInstanceId();
        generatorInstanceConfigPo.setGeneratorInstanceId(generatorInstanceId);

        String name = parameter.getName();
        generatorInstanceConfigPo.setName(name);

        String description = parameter.getDescription();
        generatorInstanceConfigPo.setDescription(description);

        generatorInstanceConfigPo.setIsDeleted(false);

        generatorInstanceConfigPo.setCreateTime(now);

        generatorInstanceConfigPo.setIsAddDefaultRecordList(parameter.getIsAddDefaultRecordList());

        generatorInstanceConfigPo.setDefaultRecordList(parameter.getDefaultRecordList());

        generatorInstanceConfigDao.insert(generatorInstanceConfigPo);

        GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
        generatorInstanceConfig.setId(generatorInstanceConfigPo.getId());

        return generatorInstanceConfig;
    }

    /**
     * 生成器实例设置删除
     */
    @Transactional
    public GeneratorInstanceConfig delete(GeneratorInstanceConfigDeleteParameter parameter) {
        generatorInstanceConfigServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        GeneratorInstanceConfigPo generatorInstanceConfigPo = generatorInstanceConfigDao.selectById(id);
        if(generatorInstanceConfigPo == null){
            throw new BusinessException("生成器实例设置不存在");
        }
        if(!generatorInstanceConfigPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例设置不存在");
        }

        GeneratorInstanceConfigPo GeneratorInstanceConfigPoUpdate = new GeneratorInstanceConfigPo();
        GeneratorInstanceConfigPoUpdate.setId(id);
        GeneratorInstanceConfigPoUpdate.setUpdateTime(now);
        GeneratorInstanceConfigPoUpdate.setIsDeleted(true);
        generatorInstanceConfigDao.updateSelective(GeneratorInstanceConfigPoUpdate);

        GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
        generatorInstanceConfig.setId(id);

        return generatorInstanceConfig;
    }
    
    /**
     * 生成器实例设置修改
     */
    @Transactional
    public GeneratorInstanceConfig update(GeneratorInstanceConfigUpdateParameter parameter) {
        generatorInstanceConfigServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        GeneratorInstanceConfigPo generatorInstanceConfigPo = generatorInstanceConfigDao.selectById(id);
        if(generatorInstanceConfigPo == null){
            throw new BusinessException("生成器实例设置不存在");
        }
        if(!generatorInstanceConfigPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例设置不存在");
        }

        String name = parameter.getName();
        generatorInstanceConfigPo.setName(name);

        String description = parameter.getDescription();
        generatorInstanceConfigPo.setDescription(description);

        generatorInstanceConfigPo.setUpdateTime(now);

        generatorInstanceConfigPo.setIsAddDefaultRecordList(parameter.getIsAddDefaultRecordList());

        generatorInstanceConfigPo.setDefaultRecordList(parameter.getDefaultRecordList());

        generatorInstanceConfigDao.update(generatorInstanceConfigPo);

        GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
        generatorInstanceConfig.setId(id);

        return generatorInstanceConfig;
    }
    
    /**
     * 生成器实例设置单个查询
     */
    //@Transactional(readOnly = true)
    public GeneratorInstanceConfig get(GeneratorInstanceConfigGetParameter parameter) {
        generatorInstanceConfigServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        GeneratorInstanceConfigPo generatorInstanceConfigPo = generatorInstanceConfigDao.selectById(id);
        if(generatorInstanceConfigPo == null) {
            throw new BusinessException("生成器实例设置不存在");
        }

        GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
        
        generatorInstanceConfig.setId(generatorInstanceConfigPo.getId());

        Long userId = generatorInstanceConfigPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                generatorInstanceConfig.setUser(user);
            }
        }

        Long generatorId = generatorInstanceConfigPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                generatorInstanceConfig.setGenerator(generator);
            }
        }

        Long generatorInstanceId = generatorInstanceConfigPo.getGeneratorInstanceId();
        if(generatorInstanceId != null){
            GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
            if(generatorInstancePo != null){
                GeneratorInstance generatorInstance = new GeneratorInstance();
                generatorInstance.setId(generatorInstancePo.getId());
                generatorInstanceConfig.setGeneratorInstance(generatorInstance);
            }
        }

        generatorInstanceConfig.setName(generatorInstanceConfigPo.getName());

        generatorInstanceConfig.setDescription(generatorInstanceConfigPo.getDescription());

        generatorInstanceConfig.setCreateTime(generatorInstanceConfigPo.getCreateTime());

        generatorInstanceConfig.setUpdateTime(generatorInstanceConfigPo.getUpdateTime());

        generatorInstanceConfig.setIsAddDefaultRecordList(generatorInstanceConfigPo.getIsAddDefaultRecordList());

        generatorInstanceConfig.setIsAddDefaultRecordList(generatorInstanceConfigPo.getIsAddDefaultRecordList());

        return generatorInstanceConfig;
    }

    /**
     * 生成器实例设置多个查询
     */
    //@Transactional(readOnly = true)
    public List<GeneratorInstanceConfig> query(GeneratorInstanceConfigQueryParameter parameter) {
        generatorInstanceConfigServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        GeneratorInstanceConfigQuery generatorInstanceConfigQuery = new GeneratorInstanceConfigQuery();
        generatorInstanceConfigQuery.setIsDeleted(false);
        generatorInstanceConfigQuery.setUserId(parameter.getUserId());
        generatorInstanceConfigQuery.setGeneratorId(parameter.getGeneratorId());
        generatorInstanceConfigQuery.setGeneratorInstanceId(parameter.getGeneratorInstanceId());
        generatorInstanceConfigQuery.setName(parameter.getName());
        generatorInstanceConfigQuery.setDescription(parameter.getDescription());

        List<GeneratorInstanceConfigPo> generatorInstanceConfigPoList = generatorInstanceConfigDao.selectList(generatorInstanceConfigQuery);

        List<GeneratorInstanceConfig> generatorInstanceConfigList = new ArrayList<>();
        if(generatorInstanceConfigPoList.isEmpty()){
            return generatorInstanceConfigList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        Map<Long, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        generatorInstanceConfigPoList.forEach(po -> {
            GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
            
            generatorInstanceConfig.setId(po.getId());

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
                generatorInstanceConfig.setUser(user);
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
                generatorInstanceConfig.setGenerator(generator);
            }

            Long generatorInstanceId = po.getGeneratorInstanceId();
            if(generatorInstanceId != null) {
                GeneratorInstance generatorInstance;
                if(generatorInstanceMap.containsKey(generatorInstanceId)) {
                    generatorInstance = generatorInstanceMap.get(generatorInstanceId);
                }
                else {
                    generatorInstance = new GeneratorInstance();
                    generatorInstance.setId(generatorInstanceId);
                    generatorInstanceMap.put(generatorInstanceId, generatorInstance);
                }
                generatorInstanceConfig.setGeneratorInstance(generatorInstance);
            }

            generatorInstanceConfig.setName(po.getName());

            generatorInstanceConfig.setDescription(po.getDescription());

            generatorInstanceConfig.setCreateTime(po.getCreateTime());

            generatorInstanceConfig.setUpdateTime(po.getUpdateTime());

            generatorInstanceConfigList.add(generatorInstanceConfig);
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

        if(!generatorInstanceMap.isEmpty()){
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectByIds(generatorInstanceMap.keySet());
            generatorInstancePos.forEach(po -> {
                Long id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        return generatorInstanceConfigList;
    }

    /**
     * 生成器实例设置分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<GeneratorInstanceConfig> search(GeneratorInstanceConfigSearchParameter parameter) {
        generatorInstanceConfigServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<GeneratorInstanceConfig> pageResult = new PageResult<>();
        List<GeneratorInstanceConfig> records = pageResult.getRecords();

        GeneratorInstanceConfigQuery generatorInstanceConfigQuery = new GeneratorInstanceConfigQuery();
        generatorInstanceConfigQuery.setIsDeleted(false);
        generatorInstanceConfigQuery.setUserId(parameter.getUserId());
        generatorInstanceConfigQuery.setGeneratorId(parameter.getGeneratorId());
        generatorInstanceConfigQuery.setGeneratorInstanceId(parameter.getGeneratorInstanceId());
        generatorInstanceConfigQuery.setName(parameter.getName());
        generatorInstanceConfigQuery.setDescription(parameter.getDescription());
        generatorInstanceConfigQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorInstanceConfigPo> generatorInstanceConfigPoPageResult = generatorInstanceConfigDao.selectPage(generatorInstanceConfigQuery);
        pageResult.setTotal(generatorInstanceConfigPoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        Map<Long, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        generatorInstanceConfigPoPageResult.getRecords().forEach(po -> {
            GeneratorInstanceConfig generatorInstanceConfig = new GeneratorInstanceConfig();
            
            generatorInstanceConfig.setId(po.getId());

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
                generatorInstanceConfig.setUser(user);
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
                generatorInstanceConfig.setGenerator(generator);
            }

            Long generatorInstanceId = po.getGeneratorInstanceId();
            if(generatorInstanceId != null) {
                GeneratorInstance generatorInstance;
                if(generatorInstanceMap.containsKey(generatorInstanceId)) {
                    generatorInstance = generatorInstanceMap.get(generatorInstanceId);
                }
                else {
                    generatorInstance = new GeneratorInstance();
                    generatorInstance.setId(generatorInstanceId);
                    generatorInstanceMap.put(generatorInstanceId, generatorInstance);
                }
                generatorInstanceConfig.setGeneratorInstance(generatorInstance);
            }

            generatorInstanceConfig.setName(po.getName());

            generatorInstanceConfig.setDescription(po.getDescription());

            generatorInstanceConfig.setCreateTime(po.getCreateTime());

            generatorInstanceConfig.setUpdateTime(po.getUpdateTime());

            records.add(generatorInstanceConfig);
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

        if(!generatorInstanceMap.isEmpty()){
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectByIds(generatorInstanceMap.keySet());
            generatorInstancePos.forEach(po -> {
                Long id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        return pageResult;
    }

}
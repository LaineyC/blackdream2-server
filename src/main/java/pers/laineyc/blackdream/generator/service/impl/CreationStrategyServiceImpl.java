package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.generator.service.CreationStrategyService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.CreationStrategyServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.CreationStrategy;
import pers.laineyc.blackdream.generator.dao.po.CreationStrategyPo;
import pers.laineyc.blackdream.generator.dao.query.CreationStrategyQuery;
import pers.laineyc.blackdream.generator.dao.CreationStrategyDao;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.service.domain.Generator;
import pers.laineyc.blackdream.generator.dao.po.GeneratorPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import java.util.List;
import java.util.Date; 
import java.util.ArrayList; 
import java.util.Map; 
import java.util.HashMap; 

/**
 * 生成器生成策略ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class CreationStrategyServiceImpl extends BaseService implements CreationStrategyService {

    @Autowired
    private CreationStrategyServiceTool creationStrategyServiceTool;

    @Autowired
    private CreationStrategyDao creationStrategyDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private SequenceService sequenceService;

    public CreationStrategyServiceImpl() {

	}

    /**
     * 生成器生成策略创建
     */
    @Transactional
    public CreationStrategy create(CreationStrategyCreateParameter parameter) {
        creationStrategyServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();
    
        CreationStrategyPo creationStrategyPo = new CreationStrategyPo();

        creationStrategyPo.setId(id);
        
        creationStrategyPo.setUserId(authUserId);

        Long generatorId = parameter.getGeneratorId();
        creationStrategyPo.setGeneratorId(generatorId);

        String name = parameter.getName();
        creationStrategyPo.setName(name);

        creationStrategyPo.setDisplayOrder(1000);

        String description = parameter.getDescription();
        creationStrategyPo.setDescription(description);

        creationStrategyPo.setIsDeleted(false);

        creationStrategyPo.setCreateTime(now);

        String script = parameter.getScript();
        creationStrategyPo.setScript(script);

        creationStrategyDao.insert(creationStrategyPo);

        CreationStrategy creationStrategy = new CreationStrategy();
        creationStrategy.setId(creationStrategyPo.getId());

        return creationStrategy;
    }

    /**
     * 生成器生成策略删除
     */
    @Transactional
    public CreationStrategy delete(CreationStrategyDeleteParameter parameter) {
        creationStrategyServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        CreationStrategyPo creationStrategyPo = creationStrategyDao.selectById(id);
        if(creationStrategyPo == null){
            throw new BusinessException("生成器生成策略不存在");
        }
        if(!creationStrategyPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        CreationStrategyPo creationStrategyPoUpdate = new CreationStrategyPo();
        creationStrategyPoUpdate.setId(id);
        creationStrategyPoUpdate.setUpdateTime(now);
        creationStrategyPoUpdate.setIsDeleted(true);
        creationStrategyDao.updateSelective(creationStrategyPoUpdate);

        CreationStrategy creationStrategy = new CreationStrategy();
        creationStrategy.setId(id);

        return creationStrategy;
    }
    
    /**
     * 生成器生成策略修改
     */
    @Transactional
    public CreationStrategy update(CreationStrategyUpdateParameter parameter) {
        creationStrategyServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        CreationStrategyPo creationStrategyPo = creationStrategyDao.selectById(id);
        if(creationStrategyPo == null){
            throw new BusinessException("生成器生成策略不存在");
        }
        if(!creationStrategyPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器模板文件不存在");
        }

        String name = parameter.getName();
        creationStrategyPo.setName(name);

        String description = parameter.getDescription();
        creationStrategyPo.setDescription(description);

        creationStrategyPo.setUpdateTime(now);

        String script = parameter.getScript();
        creationStrategyPo.setScript(script);

        creationStrategyDao.update(creationStrategyPo);

        CreationStrategy creationStrategy = new CreationStrategy();
        creationStrategy.setId(id);

        return creationStrategy;
    }
    
    /**
     * 生成器生成策略单个查询
     */
    //@Transactional(readOnly = true)
    public CreationStrategy get(CreationStrategyGetParameter parameter) {
        creationStrategyServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        CreationStrategyPo creationStrategyPo = creationStrategyDao.selectById(id);
        if(creationStrategyPo == null) {
            throw new BusinessException("生成器生成策略不存在");
        }

        CreationStrategy creationStrategy = new CreationStrategy();
        
        creationStrategy.setId(creationStrategyPo.getId());

        Long userId = creationStrategyPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                creationStrategy.setUser(user);
            }
        }

        Long generatorId = creationStrategyPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                creationStrategy.setGenerator(generator);
            }
        }

        creationStrategy.setName(creationStrategyPo.getName());

        creationStrategy.setDisplayOrder(creationStrategyPo.getDisplayOrder());

        creationStrategy.setDescription(creationStrategyPo.getDescription());

        creationStrategy.setCreateTime(creationStrategyPo.getCreateTime());

        creationStrategy.setUpdateTime(creationStrategyPo.getUpdateTime());

        creationStrategy.setScript(creationStrategyPo.getScript());

        return creationStrategy;
    }

    /**
     * 生成器生成策略多个查询
     */
    //@Transactional(readOnly = true)
    public List<CreationStrategy> query(CreationStrategyQueryParameter parameter) {
        creationStrategyServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        CreationStrategyQuery creationStrategyQuery = new CreationStrategyQuery();
        creationStrategyQuery.setIsDeleted(false);
        creationStrategyQuery.setUserId(parameter.getUserId());
        creationStrategyQuery.setGeneratorId(parameter.getGeneratorId());
        creationStrategyQuery.setName(parameter.getName());

        List<CreationStrategyPo> creationStrategyPoList = creationStrategyDao.selectList(creationStrategyQuery);

        List<CreationStrategy> creationStrategyList = new ArrayList<>();
        if(creationStrategyPoList.isEmpty()){
            return creationStrategyList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        creationStrategyPoList.forEach(po -> {
            CreationStrategy creationStrategy = new CreationStrategy();
            
            creationStrategy.setId(po.getId());

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
                creationStrategy.setUser(user);
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
                creationStrategy.setGenerator(generator);
            }

            creationStrategy.setName(po.getName());

            creationStrategy.setDisplayOrder(po.getDisplayOrder());

            creationStrategy.setDescription(po.getDescription());

            creationStrategy.setCreateTime(po.getCreateTime());

            creationStrategy.setUpdateTime(po.getUpdateTime());

            creationStrategyList.add(creationStrategy);
        });

        if(!userMap.isEmpty()){
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                Long id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            GeneratorQuery generatorQuery = new GeneratorQuery();
            generatorQuery.setIdList(new ArrayList<>(generatorMap.keySet()));
            List<GeneratorPo> generatorPos = generatorDao.selectList(generatorQuery);
            generatorPos.forEach(po -> {
                Long id = po.getId();
                Generator generator = generatorMap.get(id);
                generator.setId(id);
            });
        }

        return creationStrategyList;
    }

    /**
     * 生成器生成策略分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<CreationStrategy> search(CreationStrategySearchParameter parameter) {
        creationStrategyServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<CreationStrategy> pageResult = new PageResult<>();
        List<CreationStrategy> records = pageResult.getRecords();

        CreationStrategyQuery creationStrategyQuery = new CreationStrategyQuery();
        creationStrategyQuery.setIsDeleted(false);
        creationStrategyQuery.setUserId(parameter.getUserId());
        creationStrategyQuery.setGeneratorId(parameter.getGeneratorId());
        creationStrategyQuery.setName(parameter.getName());
        creationStrategyQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<CreationStrategyPo> creationStrategyPoPageResult = creationStrategyDao.selectPage(creationStrategyQuery);
        pageResult.setTotal(creationStrategyPoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        creationStrategyPoPageResult.getRecords().forEach(po -> {
            CreationStrategy creationStrategy = new CreationStrategy();
            
            creationStrategy.setId(po.getId());

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
                creationStrategy.setUser(user);
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
                creationStrategy.setGenerator(generator);
            }

            creationStrategy.setName(po.getName());

            creationStrategy.setDisplayOrder(po.getDisplayOrder());

            creationStrategy.setDescription(po.getDescription());

            creationStrategy.setCreateTime(po.getCreateTime());

            creationStrategy.setUpdateTime(po.getUpdateTime());

            records.add(creationStrategy);
        });

        if(!userMap.isEmpty()){
            UserQuery userQuery = new UserQuery();
            userQuery.setIdList(new ArrayList<>(userMap.keySet()));
            List<UserPo> userPos = userDao.selectList(userQuery);
            userPos.forEach(po -> {
                Long id = po.getId();
                User user = userMap.get(id);
                user.setId(id);
            });
        }

        if(!generatorMap.isEmpty()){
            GeneratorQuery generatorQuery = new GeneratorQuery();
            generatorQuery.setIdList(new ArrayList<>(generatorMap.keySet()));
            List<GeneratorPo> generatorPos = generatorDao.selectList(generatorQuery);
            generatorPos.forEach(po -> {
                Long id = po.getId();
                Generator generator = generatorMap.get(id);
                generator.setId(id);
            });
        }

        return pageResult;
    }

    /**
     * 生成器生成策略排序
     */
    @Transactional
    public CreationStrategy sort(CreationStrategySortParameter parameter) {
        creationStrategyServiceTool.sortValidate(parameter);
    
        Auth auth = parameter.getAuth();

        CreationStrategy creationStrategy = new CreationStrategy();

        return creationStrategy;
    }

    /**
     * 生成器生成策略分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<CreationStrategy> infoSearch(CreationStrategyInfoSearchParameter parameter) {
        creationStrategyServiceTool.infoSearchValidate(parameter);

        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        CreationStrategySearchParameter creationStrategySearchParameter = new CreationStrategySearchParameter();
        BeanUtils.copyProperties(parameter, creationStrategySearchParameter);
        creationStrategySearchParameter.setUserId(authUserId);

        return this.search(creationStrategySearchParameter);
    }
}
package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.GeneratorInstanceServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.GeneratorInstance;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstancePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
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
 * 生成器实例ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorInstanceServiceImpl extends BaseService implements GeneratorInstanceService {

    @Autowired
    private GeneratorInstanceServiceTool generatorInstanceServiceTool;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    public GeneratorInstanceServiceImpl() {

	}

    /**
     * 生成器实例创建
     */
    @Transactional
    public GeneratorInstance create(GeneratorInstanceCreateParameter parameter) {
        generatorInstanceServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();
    
        GeneratorInstancePo generatorInstancePo = new GeneratorInstancePo();
        
        generatorInstancePo.setUserId(authUserId);

        String generatorId = parameter.getGeneratorId();
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }
        generatorInstancePo.setGeneratorId(generatorId);

        String name = parameter.getName();
        generatorInstancePo.setName(name);

        generatorInstancePo.setReleaseVersion(generatorPo.getReleaseVersion());

        String description = parameter.getDescription();
        generatorInstancePo.setDescription(description);

        generatorInstancePo.setIsDeleted(false);

        generatorInstancePo.setCreateTime(now);

        generatorInstanceDao.insert(generatorInstancePo);

        GeneratorInstance generatorInstance = new GeneratorInstance();
        generatorInstance.setId(generatorInstancePo.getId());

        return generatorInstance;
    }

    /**
     * 生成器实例删除
     */
    @Transactional
    public GeneratorInstance delete(GeneratorInstanceDeleteParameter parameter) {
        generatorInstanceServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();
               
        String id = parameter.getId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(id);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !generatorInstancePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例不存在");
        }

        GeneratorInstancePo generatorInstancePoUpdate = new GeneratorInstancePo();
        generatorInstancePoUpdate.setId(id);
        generatorInstancePoUpdate.setIsDeleted(true);
        generatorInstancePoUpdate.setUpdateTime(now);
        generatorInstanceDao.updateSelective(generatorInstancePoUpdate);

        GeneratorInstance generatorInstance = new GeneratorInstance();
        generatorInstance.setId(id);

        return generatorInstance;
    }
    
    /**
     * 生成器实例修改
     */
    @Transactional
    public GeneratorInstance update(GeneratorInstanceUpdateParameter parameter) {
        generatorInstanceServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(id);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !generatorInstancePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例不存在");
        }

        String name = parameter.getName();
        generatorInstancePo.setName(name);

        String description = parameter.getDescription();
        generatorInstancePo.setDescription(description);

        generatorInstancePo.setUpdateTime(now);

        generatorInstanceDao.update(generatorInstancePo);

        GeneratorInstance generatorInstance = new GeneratorInstance();
        generatorInstance.setId(id);

        return generatorInstance;
    }
    
    /**
     * 生成器实例单个查询
     */
    //@Transactional(readOnly = true)
    public GeneratorInstance get(GeneratorInstanceGetParameter parameter) {
        generatorInstanceServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        String id = parameter.getId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(id);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted()){
            throw new BusinessException("生成器实例不存在");
        }

        GeneratorInstance generatorInstance = new GeneratorInstance();
        
        generatorInstance.setId(generatorInstancePo.getId());

        String userId = generatorInstancePo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                generatorInstance.setUser(user);
            }
        }

        String generatorId = generatorInstancePo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                generatorInstance.setGenerator(generator);
            }
        }

        generatorInstance.setName(generatorInstancePo.getName());

        generatorInstance.setReleaseVersion(generatorInstancePo.getReleaseVersion());

        generatorInstance.setDescription(generatorInstancePo.getDescription());

        generatorInstance.setCreateTime(generatorInstancePo.getCreateTime());

        generatorInstance.setUpdateTime(generatorInstancePo.getUpdateTime());

        return generatorInstance;
    }

    /**
     * 生成器实例多个查询
     */
    //@Transactional(readOnly = true)
    public List<GeneratorInstance> query(GeneratorInstanceQueryParameter parameter) {
        generatorInstanceServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
        generatorInstanceQuery.setIsDeleted(false);
        generatorInstanceQuery.setUserId(parameter.getUserId());
        generatorInstanceQuery.setGeneratorId(parameter.getGeneratorId());
        generatorInstanceQuery.setName(parameter.getName());

        List<GeneratorInstancePo> generatorInstancePoList = generatorInstanceDao.selectList(generatorInstanceQuery);

        List<GeneratorInstance> generatorInstanceList = new ArrayList<>();
        if(generatorInstancePoList.isEmpty()){
            return generatorInstanceList;
        }
        
        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        generatorInstancePoList.forEach(po -> {
            GeneratorInstance generatorInstance = new GeneratorInstance();
            
            generatorInstance.setId(po.getId());

            String userId = po.getUserId();
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
                generatorInstance.setUser(user);
            }

            String generatorId = po.getGeneratorId();
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
                generatorInstance.setGenerator(generator);
            }

            generatorInstance.setName(po.getName());

            generatorInstance.setReleaseVersion(po.getReleaseVersion());

            generatorInstance.setDescription(po.getDescription());

            generatorInstance.setCreateTime(po.getCreateTime());

            generatorInstance.setUpdateTime(po.getUpdateTime());

            generatorInstanceList.add(generatorInstance);
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

        return generatorInstanceList;
    }

    /**
     * 生成器实例分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<GeneratorInstance> search(GeneratorInstanceSearchParameter parameter) {
        generatorInstanceServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<GeneratorInstance> pageResult = new PageResult<>();
        List<GeneratorInstance> records = pageResult.getRecords();

        GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
        generatorInstanceQuery.setIsDeleted(false);
        generatorInstanceQuery.setUserId(parameter.getUserId());
        generatorInstanceQuery.setGeneratorId(parameter.getGeneratorId());
        generatorInstanceQuery.setName(parameter.getName());
        generatorInstanceQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorInstancePo> generatorInstancePoPageResult = generatorInstanceDao.selectPage(generatorInstanceQuery);
        pageResult.setTotal(generatorInstancePoPageResult.getTotal());

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        generatorInstancePoPageResult.getRecords().forEach(po -> {
            GeneratorInstance generatorInstance = new GeneratorInstance();
            
            generatorInstance.setId(po.getId());

            String userId = po.getUserId();
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
                generatorInstance.setUser(user);
            }

            String generatorId = po.getGeneratorId();
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
                generatorInstance.setGenerator(generator);
            }

            generatorInstance.setName(po.getName());

            generatorInstance.setReleaseVersion(po.getReleaseVersion());

            generatorInstance.setDescription(po.getDescription());

            generatorInstance.setCreateTime(po.getCreateTime());

            generatorInstance.setUpdateTime(po.getUpdateTime());

            records.add(generatorInstance);
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
     * 生成器实例分页查询
     */
    @Transactional
    public PageResult<GeneratorInstance> infoSearch(GeneratorInstanceInfoSearchParameter parameter) {
        generatorInstanceServiceTool.infoSearchValidate(parameter);

        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        GeneratorInstanceSearchParameter generatorInstanceSearchParameter = new GeneratorInstanceSearchParameter();
        BeanUtils.copyProperties(parameter, generatorInstanceSearchParameter);
        generatorInstanceSearchParameter.setUserId(authUserId);

        return this.search(generatorInstanceSearchParameter);
    }
    
    /**
     * 生成器实例生成
     */
    @Transactional
    public GeneratorInstance make(GeneratorInstanceMakeParameter parameter) {
        generatorInstanceServiceTool.makeValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        GeneratorInstance generatorInstance = new GeneratorInstance();

        return generatorInstance;
    }

    /**
     * 生成器实例生成参数
     */
    @Transactional
    public GeneratorInstance makeTest(GeneratorInstanceMakeTestParameter parameter) {
        return null;
    }

    /**
     * 生成器实例版本同步
     */
    @Transactional
    public GeneratorInstance versionSync(GeneratorInstanceVersionSyncParameter parameter) {
        generatorInstanceServiceTool.versionSyncValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(id);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !generatorInstancePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例不存在");
        }

        String generatorId = generatorInstancePo.getGeneratorId();
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }

        Integer generatorReleaseVersion = generatorPo.getReleaseVersion();
        if(generatorInstancePo.getReleaseVersion() < generatorReleaseVersion){
            GeneratorInstancePo generatorInstancePoUpdate = new GeneratorInstancePo();
            generatorInstancePoUpdate.setId(id);
            generatorInstancePoUpdate.setReleaseVersion(generatorReleaseVersion);
            generatorInstancePoUpdate.setUpdateTime(now);
            generatorInstanceDao.updateSelective(generatorInstancePoUpdate);
        }

        GeneratorInstance generatorInstance = new GeneratorInstance();
        generatorInstance.setId(id);

        return generatorInstance;
    }
    
}
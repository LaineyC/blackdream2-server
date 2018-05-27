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
import pers.laineyc.blackdream.generator.service.GeneratorGuideService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.GeneratorGuideServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.GeneratorGuide;
import pers.laineyc.blackdream.generator.dao.po.GeneratorGuidePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorGuideQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorGuideDao;
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
 * 生成器指南ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorGuideServiceImpl extends BaseService implements GeneratorGuideService {

    @Autowired
    private GeneratorGuideServiceTool generatorGuideServiceTool;

    @Autowired
    private GeneratorGuideDao generatorGuideDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private SequenceService sequenceService;

    public GeneratorGuideServiceImpl() {

	}

    /**
     * 生成器指南创建
     */
    @Transactional
    public GeneratorGuide create(GeneratorGuideCreateParameter parameter) {
        generatorGuideServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();
    
        GeneratorGuidePo generatorGuidePo = new GeneratorGuidePo();

        generatorGuidePo.setId(id);
        
        generatorGuidePo.setUserId(authUserId);

        Long generatorId = parameter.getGeneratorId();
        generatorGuidePo.setGeneratorId(generatorId);

        String name = parameter.getName();
        generatorGuidePo.setName(name);

        String description = parameter.getDescription();
        generatorGuidePo.setDescription(description);

        generatorGuidePo.setIsDeleted(false);

        generatorGuidePo.setCreateTime(now);

        String content = parameter.getContent();
        generatorGuidePo.setContent(content);

        generatorGuideDao.insert(generatorGuidePo);

        GeneratorGuide generatorGuide = new GeneratorGuide();
        generatorGuide.setId(generatorGuidePo.getId());

        return generatorGuide;
    }

    /**
     * 生成器指南删除
     */
    @Transactional
    public GeneratorGuide delete(GeneratorGuideDeleteParameter parameter) {
        generatorGuideServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        GeneratorGuidePo generatorGuidePo = generatorGuideDao.selectById(id);
        if(generatorGuidePo == null){
            throw new BusinessException("生成器指南不存在");
        }
        if(!generatorGuidePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器指南不存在");
        }

        GeneratorGuidePo generatorGuidePoUpdate = new GeneratorGuidePo();
        generatorGuidePoUpdate.setId(id);
        generatorGuidePoUpdate.setUpdateTime(now);
        generatorGuidePoUpdate.setIsDeleted(true);
        generatorGuideDao.updateSelective(generatorGuidePoUpdate);

        GeneratorGuide generatorGuide = new GeneratorGuide();
        generatorGuide.setId(id);

        return generatorGuide;
    }
    
    /**
     * 生成器指南修改
     */
    @Transactional
    public GeneratorGuide update(GeneratorGuideUpdateParameter parameter) {
        generatorGuideServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        GeneratorGuidePo generatorGuidePo = generatorGuideDao.selectById(id);
        if(generatorGuidePo == null){
            throw new BusinessException("生成器指南不存在");
        }
        if(!generatorGuidePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器指南不存在");
        }

        String name = parameter.getName();
        generatorGuidePo.setName(name);

        String description = parameter.getDescription();
        generatorGuidePo.setDescription(description);

        generatorGuidePo.setUpdateTime(now);

        String content = parameter.getContent();
        generatorGuidePo.setContent(content);

        generatorGuideDao.update(generatorGuidePo);

        GeneratorGuide generatorGuide = new GeneratorGuide();
        generatorGuide.setId(id);

        return generatorGuide;
    }
    
    /**
     * 生成器指南单个查询
     */
    //@Transactional(readOnly = true)
    public GeneratorGuide get(GeneratorGuideGetParameter parameter) {
        generatorGuideServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        Long parameterGeneratorId = parameter.getGeneratorId();
        GeneratorGuidePo generatorGuidePo = null;
        if(id != null){
            generatorGuidePo = generatorGuideDao.selectById(id);
        }
        else if(parameterGeneratorId != null){
            GeneratorGuideQuery generatorGuideQuery = new GeneratorGuideQuery();
            generatorGuideQuery.setGeneratorId(parameterGeneratorId);
            generatorGuidePo = generatorGuideDao.selectOne(generatorGuideQuery);
        }

        if(generatorGuidePo == null) {
            return null;
        }

        GeneratorGuide generatorGuide = new GeneratorGuide();
        
        generatorGuide.setId(generatorGuidePo.getId());

        Long userId = generatorGuidePo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                generatorGuide.setUser(user);
            }
        }

        Long generatorId = generatorGuidePo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                generatorGuide.setGenerator(generator);
            }
        }

        generatorGuide.setName(generatorGuidePo.getName());

        generatorGuide.setDescription(generatorGuidePo.getDescription());

        generatorGuide.setCreateTime(generatorGuidePo.getCreateTime());

        generatorGuide.setUpdateTime(generatorGuidePo.getUpdateTime());

        generatorGuide.setContent(generatorGuidePo.getContent());

        return generatorGuide;
    }

    /**
     * 生成器指南多个查询
     */
    //@Transactional(readOnly = true)
    public List<GeneratorGuide> query(GeneratorGuideQueryParameter parameter) {
        generatorGuideServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        GeneratorGuideQuery generatorGuideQuery = new GeneratorGuideQuery();
        generatorGuideQuery.setIsDeleted(false);
        generatorGuideQuery.setUserId(parameter.getUserId());
        generatorGuideQuery.setGeneratorId(parameter.getGeneratorId());
        generatorGuideQuery.setName(parameter.getName());

        List<GeneratorGuidePo> generatorGuidePoList = generatorGuideDao.selectList(generatorGuideQuery);

        List<GeneratorGuide> generatorGuideList = new ArrayList<>();
        if(generatorGuidePoList.isEmpty()){
            return generatorGuideList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        generatorGuidePoList.forEach(po -> {
            GeneratorGuide generatorGuide = new GeneratorGuide();
            
            generatorGuide.setId(po.getId());

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
                generatorGuide.setUser(user);
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
                generatorGuide.setGenerator(generator);
            }

            generatorGuide.setName(po.getName());

            generatorGuide.setDescription(po.getDescription());

            generatorGuide.setCreateTime(po.getCreateTime());

            generatorGuide.setUpdateTime(po.getUpdateTime());

            generatorGuideList.add(generatorGuide);
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

        return generatorGuideList;
    }

    /**
     * 生成器指南分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<GeneratorGuide> search(GeneratorGuideSearchParameter parameter) {
        generatorGuideServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<GeneratorGuide> pageResult = new PageResult<>();
        List<GeneratorGuide> records = pageResult.getRecords();

        GeneratorGuideQuery generatorGuideQuery = new GeneratorGuideQuery();
        generatorGuideQuery.setIsDeleted(false);
        generatorGuideQuery.setUserId(parameter.getUserId());
        generatorGuideQuery.setGeneratorId(parameter.getGeneratorId());
        generatorGuideQuery.setName(parameter.getName());
        generatorGuideQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorGuidePo> generatorGuidePoPageResult = generatorGuideDao.selectPage(generatorGuideQuery);
        pageResult.setTotal(generatorGuidePoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        generatorGuidePoPageResult.getRecords().forEach(po -> {
            GeneratorGuide generatorGuide = new GeneratorGuide();
            
            generatorGuide.setId(po.getId());

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
                generatorGuide.setUser(user);
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
                generatorGuide.setGenerator(generator);
            }

            generatorGuide.setName(po.getName());

            generatorGuide.setDescription(po.getDescription());

            generatorGuide.setCreateTime(po.getCreateTime());

            generatorGuide.setUpdateTime(po.getUpdateTime());

            records.add(generatorGuide);
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

    @Transactional
    public GeneratorGuide save(GeneratorGuideSaveParameter parameter) {
        generatorGuideServiceTool.saveValidate(parameter);

        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long generatorId = parameter.getGeneratorId();

        GeneratorGuideQuery generatorGuideQuery = new GeneratorGuideQuery();
        generatorGuideQuery.setGeneratorId(generatorId);
        GeneratorGuidePo generatorGuidePo = generatorGuideDao.selectOne(generatorGuideQuery);

        if(generatorGuidePo == null) {
            GeneratorGuideCreateParameter generatorGuideCreateParameter = new GeneratorGuideCreateParameter();
            BeanUtils.copyProperties(parameter, generatorGuideCreateParameter);
            return this.create(generatorGuideCreateParameter);
        }
        else{
            GeneratorGuideUpdateParameter generatorGuideUpdateParameter = new GeneratorGuideUpdateParameter();
            BeanUtils.copyProperties(parameter, generatorGuideUpdateParameter);
            generatorGuideUpdateParameter.setId(generatorGuidePo.getId());
            return this.update(generatorGuideUpdateParameter);
        }
    }

}
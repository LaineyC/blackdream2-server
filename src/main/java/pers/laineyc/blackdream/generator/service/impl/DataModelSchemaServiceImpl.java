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
import pers.laineyc.blackdream.generator.service.DataModelSchemaService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.DataModelSchemaServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.DataModelSchema;
import pers.laineyc.blackdream.generator.dao.po.DataModelSchemaPo;
import pers.laineyc.blackdream.generator.dao.query.DataModelSchemaQuery;
import pers.laineyc.blackdream.generator.dao.DataModelSchemaDao;
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
 * 生成器数据模型模式ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class DataModelSchemaServiceImpl extends BaseService implements DataModelSchemaService {

    @Autowired
    private DataModelSchemaServiceTool dataModelSchemaServiceTool;

    @Autowired
    private DataModelSchemaDao dataModelSchemaDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private SequenceService sequenceService;

    public DataModelSchemaServiceImpl() {

	}

    /**
     * 生成器数据模型模式创建
     */
    @Transactional
    public DataModelSchema create(DataModelSchemaCreateParameter parameter) {
        dataModelSchemaServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();
    
        DataModelSchemaPo dataModelSchemaPo = new DataModelSchemaPo();

        dataModelSchemaPo.setId(id);
        
        dataModelSchemaPo.setUserId(authUserId);

        Long generatorId = parameter.getGeneratorId();
        dataModelSchemaPo.setGeneratorId(generatorId);

        String name = parameter.getName();
        dataModelSchemaPo.setName(name);

        String description = parameter.getDescription();
        dataModelSchemaPo.setDescription(description);

        dataModelSchemaPo.setIsDeleted(false);

        dataModelSchemaPo.setCreateTime(now);

        String script = parameter.getScript();
        dataModelSchemaPo.setScript(script);

        dataModelSchemaDao.insert(dataModelSchemaPo);

        DataModelSchema dataModelSchema = new DataModelSchema();
        dataModelSchema.setId(dataModelSchemaPo.getId());

        return dataModelSchema;
    }

    /**
     * 生成器数据模型模式删除
     */
    @Transactional
    public DataModelSchema delete(DataModelSchemaDeleteParameter parameter) {
        dataModelSchemaServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        DataModelSchemaPo dataModelSchemaPo = dataModelSchemaDao.selectById(id);
        if(dataModelSchemaPo == null){
            throw new BusinessException("生成器数据模型模式不存在");
        }
        if(!dataModelSchemaPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据模型模式不存在");
        }

        DataModelSchemaPo dataModelSchemaPoUpdate = new DataModelSchemaPo();
        dataModelSchemaPoUpdate.setId(id);
        dataModelSchemaPoUpdate.setUpdateTime(now);
        dataModelSchemaPoUpdate.setIsDeleted(true);
        dataModelSchemaDao.updateSelective(dataModelSchemaPoUpdate);

        DataModelSchema dataModelSchema = new DataModelSchema();
        dataModelSchema.setId(id);

        return dataModelSchema;
    }
    
    /**
     * 生成器数据模型模式修改
     */
    @Transactional
    public DataModelSchema update(DataModelSchemaUpdateParameter parameter) {
        dataModelSchemaServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        DataModelSchemaPo dataModelSchemaPo = dataModelSchemaDao.selectById(id);
        if(dataModelSchemaPo == null){
            throw new BusinessException("生成器数据模型模式不存在");
        }
        if(!dataModelSchemaPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据模型模式不存在");
        }

        String name = parameter.getName();
        dataModelSchemaPo.setName(name);

        String description = parameter.getDescription();
        dataModelSchemaPo.setDescription(description);

        dataModelSchemaPo.setUpdateTime(now);

        String script = parameter.getScript();
        dataModelSchemaPo.setScript(script);

        dataModelSchemaDao.update(dataModelSchemaPo);

        DataModelSchema dataModelSchema = new DataModelSchema();
        dataModelSchema.setId(id);

        return dataModelSchema;
    }
    
    /**
     * 生成器数据模型模式单个查询
     */
    //@Transactional(readOnly = true)
    public DataModelSchema get(DataModelSchemaGetParameter parameter) {
        dataModelSchemaServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        Long parameterGeneratorId = parameter.getGeneratorId();
        DataModelSchemaPo dataModelSchemaPo = null;
        if(id != null){
            dataModelSchemaPo = dataModelSchemaDao.selectById(id);
        }
        else if(parameterGeneratorId != null){
            DataModelSchemaQuery dataModelSchemaQuery = new DataModelSchemaQuery();
            dataModelSchemaQuery.setGeneratorId(parameterGeneratorId);
            dataModelSchemaPo = dataModelSchemaDao.selectOne(dataModelSchemaQuery);
        }

        if(dataModelSchemaPo == null) {
            return null;
        }

        DataModelSchema dataModelSchema = new DataModelSchema();
        
        dataModelSchema.setId(dataModelSchemaPo.getId());

        Long userId = dataModelSchemaPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                dataModelSchema.setUser(user);
            }
        }

        Long generatorId = dataModelSchemaPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                dataModelSchema.setGenerator(generator);
            }
        }

        dataModelSchema.setName(dataModelSchemaPo.getName());

        dataModelSchema.setDescription(dataModelSchemaPo.getDescription());

        dataModelSchema.setCreateTime(dataModelSchemaPo.getCreateTime());

        dataModelSchema.setUpdateTime(dataModelSchemaPo.getUpdateTime());

        dataModelSchema.setScript(dataModelSchemaPo.getScript());

        return dataModelSchema;
    }

    /**
     * 生成器数据模型模式多个查询
     */
    //@Transactional(readOnly = true)
    public List<DataModelSchema> query(DataModelSchemaQueryParameter parameter) {
        dataModelSchemaServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        DataModelSchemaQuery dataModelSchemaQuery = new DataModelSchemaQuery();
        dataModelSchemaQuery.setIsDeleted(false);
        dataModelSchemaQuery.setUserId(parameter.getUserId());
        dataModelSchemaQuery.setGeneratorId(parameter.getGeneratorId());
        dataModelSchemaQuery.setName(parameter.getName());

        List<DataModelSchemaPo> dataModelSchemaPoList = dataModelSchemaDao.selectList(dataModelSchemaQuery);

        List<DataModelSchema> dataModelSchemaList = new ArrayList<>();
        if(dataModelSchemaPoList.isEmpty()){
            return dataModelSchemaList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        dataModelSchemaPoList.forEach(po -> {
            DataModelSchema dataModelSchema = new DataModelSchema();
            
            dataModelSchema.setId(po.getId());

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
                dataModelSchema.setUser(user);
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
                dataModelSchema.setGenerator(generator);
            }

            dataModelSchema.setName(po.getName());

            dataModelSchema.setDescription(po.getDescription());

            dataModelSchema.setCreateTime(po.getCreateTime());

            dataModelSchema.setUpdateTime(po.getUpdateTime());

            dataModelSchemaList.add(dataModelSchema);
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

        return dataModelSchemaList;
    }

    /**
     * 生成器数据模型模式分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<DataModelSchema> search(DataModelSchemaSearchParameter parameter) {
        dataModelSchemaServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<DataModelSchema> pageResult = new PageResult<>();
        List<DataModelSchema> records = pageResult.getRecords();

        DataModelSchemaQuery dataModelSchemaQuery = new DataModelSchemaQuery();
        dataModelSchemaQuery.setIsDeleted(false);
        dataModelSchemaQuery.setUserId(parameter.getUserId());
        dataModelSchemaQuery.setGeneratorId(parameter.getGeneratorId());
        dataModelSchemaQuery.setName(parameter.getName());
        dataModelSchemaQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<DataModelSchemaPo> dataModelSchemaPoPageResult = dataModelSchemaDao.selectPage(dataModelSchemaQuery);
        pageResult.setTotal(dataModelSchemaPoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        dataModelSchemaPoPageResult.getRecords().forEach(po -> {
            DataModelSchema dataModelSchema = new DataModelSchema();
            
            dataModelSchema.setId(po.getId());

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
                dataModelSchema.setUser(user);
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
                dataModelSchema.setGenerator(generator);
            }

            dataModelSchema.setName(po.getName());

            dataModelSchema.setDescription(po.getDescription());

            dataModelSchema.setCreateTime(po.getCreateTime());

            dataModelSchema.setUpdateTime(po.getUpdateTime());

            records.add(dataModelSchema);
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
    public DataModelSchema save(DataModelSchemaSaveParameter parameter) {
        dataModelSchemaServiceTool.saveValidate(parameter);

        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long generatorId = parameter.getGeneratorId();

        DataModelSchemaQuery dataModelSchemaQuery = new DataModelSchemaQuery();
        dataModelSchemaQuery.setGeneratorId(generatorId);
        DataModelSchemaPo dataModelSchemaPo = dataModelSchemaDao.selectOne(dataModelSchemaQuery);

        if(dataModelSchemaPo == null) {
            DataModelSchemaCreateParameter dataModelSchemaCreateParameter = new DataModelSchemaCreateParameter();
            BeanUtils.copyProperties(parameter, dataModelSchemaCreateParameter);
            return this.create(dataModelSchemaCreateParameter);
        }
        else{
            DataModelSchemaUpdateParameter dataModelSchemaUpdateParameter = new DataModelSchemaUpdateParameter();
            BeanUtils.copyProperties(parameter, dataModelSchemaUpdateParameter);
            dataModelSchemaUpdateParameter.setId(dataModelSchemaPo.getId());
            return this.update(dataModelSchemaUpdateParameter);
        }
    }

}
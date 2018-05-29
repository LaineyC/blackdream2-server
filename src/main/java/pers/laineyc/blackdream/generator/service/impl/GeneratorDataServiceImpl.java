package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.foundation.service.SequenceService;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.FileUtil;
import pers.laineyc.blackdream.framework.util.JsonUtil;
import pers.laineyc.blackdream.generator.service.GeneratorDataService;
import pers.laineyc.blackdream.generator.tool.GeneratorDataServiceTool;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.service.domain.GeneratorData;
import pers.laineyc.blackdream.generator.dao.po.GeneratorDataPo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorDataQuery;
import pers.laineyc.blackdream.generator.dao.GeneratorDataDao;
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
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;
import pers.laineyc.blackdream.generator.dao.query.DataModelQuery;
import pers.laineyc.blackdream.generator.dao.DataModelDao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map; 
import java.util.HashMap; 
import java.util.Date; 
import java.util.ArrayList; 

/**
 * 生成器数据ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class GeneratorDataServiceImpl extends BaseService implements GeneratorDataService {

    @Autowired
    private GeneratorDataServiceTool generatorDataServiceTool;

    @Autowired
    private GeneratorDataDao generatorDataDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private DataModelDao dataModelDao;

    @Autowired
    private SequenceService sequenceService;

    public GeneratorDataServiceImpl() {

	}

    /**
     * 生成器数据创建
     */
    @Transactional
    public GeneratorData create(GeneratorDataCreateParameter parameter) {
        generatorDataServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = sequenceService.nextId();
    
        GeneratorDataPo generatorDataPo = new GeneratorDataPo();

        generatorDataPo.setId(id);
        
        generatorDataPo.setUserId(authUserId);

        Long generatorInstanceId = parameter.getGeneratorInstanceId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null){
            throw new BusinessException("所属生成器实例不存在");
        }
        generatorDataPo.setGeneratorInstanceId(generatorInstanceId);
        generatorDataPo.setGeneratorId(generatorInstancePo.getGeneratorId());

        Long dataModelId = parameter.getDataModelId();
        generatorDataPo.setDataModelId(dataModelId);

        String name = parameter.getName();
        generatorDataPo.setName(name);

        Boolean isExpanded = parameter.getIsExpanded();
        generatorDataPo.setIsExpanded(isExpanded);

        generatorDataPo.setDisplayOrder(1000);

        Long parentId = parameter.getParentId();
        generatorDataPo.setParentId(parentId);

        generatorDataPo.setIsDeleted(false);

        generatorDataPo.setCreateTime(now);

        generatorDataPo.setProperty(parameter.getProperty());

        generatorDataPo.setRecordList(parameter.getRecordList());

        generatorDataDao.insert(generatorDataPo);

        GeneratorData generatorData = new GeneratorData();
        generatorData.setId(generatorDataPo.getId());

        return generatorData;
    }

    /**
     * 生成器数据删除
     */
    @Transactional
    public GeneratorData delete(GeneratorDataDeleteParameter parameter) {
        generatorDataServiceTool.deleteValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
               
        Long id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null){
            throw new BusinessException("生成器数据不存在");
        }

        if(!generatorDataPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例设置不存在");
        }

        GeneratorDataPo generatorDataPoUpdate = new GeneratorDataPo();
        generatorDataPoUpdate.setId(id);
        generatorDataPoUpdate.setUpdateTime(now);
        generatorDataPoUpdate.setIsDeleted(true);
        generatorDataDao.updateSelective(generatorDataPoUpdate);

        GeneratorData generatorData = new GeneratorData();
        generatorData.setId(id);

        return generatorData;
    }
    
    /**
     * 生成器数据修改
     */
    @Transactional
    public GeneratorData update(GeneratorDataUpdateParameter parameter) {
        generatorDataServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();

        Long id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null){
            throw new BusinessException("生成器数据不存在");
        }
        if(!generatorDataPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例设置不存在");
        }

        String name = parameter.getName();
        generatorDataPo.setName(name);

        Boolean isExpanded = parameter.getIsExpanded();
        generatorDataPo.setIsExpanded(isExpanded);

        Long parentId = parameter.getParentId();
        generatorDataPo.setParentId(parentId);

        generatorDataPo.setUpdateTime(now);

        generatorDataPo.setProperty(parameter.getProperty());

        generatorDataPo.setRecordList(parameter.getRecordList());

        generatorDataDao.update(generatorDataPo);

        GeneratorData generatorData = new GeneratorData();
        generatorData.setId(id);

        return generatorData;
    }
    
    /**
     * 生成器数据单个查询
     */
    //@Transactional(readOnly = true)
    public GeneratorData get(GeneratorDataGetParameter parameter) {
        generatorDataServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        Long id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null) {
            throw new BusinessException("生成器数据不存在");
        }

        GeneratorData generatorData = new GeneratorData();
        
        generatorData.setId(generatorDataPo.getId());

        Long userId = generatorDataPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                generatorData.setUser(user);
            }
        }

        Long generatorId = generatorDataPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                generatorData.setGenerator(generator);
            }
        }

        Long generatorInstanceId = generatorDataPo.getGeneratorInstanceId();
        if(generatorInstanceId != null){
            GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
            if(generatorInstancePo != null){
                GeneratorInstance generatorInstance = new GeneratorInstance();
                generatorInstance.setId(generatorInstancePo.getId());
                generatorData.setGeneratorInstance(generatorInstance);
            }
        }

        Long dataModelId = generatorDataPo.getDataModelId();
        if(dataModelId != null){
            DataModelPo dataModelPo = dataModelDao.selectById(dataModelId);
            if(dataModelPo != null){
                DataModel dataModel = new DataModel();
                dataModel.setId(dataModelPo.getId());
                generatorData.setDataModel(dataModel);
            }
        }

        generatorData.setName(generatorDataPo.getName());

        generatorData.setIsExpanded(generatorDataPo.getIsExpanded());

        generatorData.setDisplayOrder(generatorDataPo.getDisplayOrder());

        Long parentId = generatorDataPo.getParentId();
        if(parentId != null){
            GeneratorDataPo parentPo = generatorDataDao.selectById(parentId);
            if(parentPo != null){
                GeneratorData parent = new GeneratorData();
                parent.setId(parentPo.getId());
                generatorData.setParent(parent);
            }
        }

        generatorData.setCreateTime(generatorDataPo.getCreateTime());

        generatorData.setUpdateTime(generatorDataPo.getUpdateTime());

        generatorData.setProperty(generatorDataPo.getProperty());

        generatorData.setRecordList(generatorDataPo.getRecordList());

        return generatorData;
    }

    /**
     * 生成器数据多个查询
     */
    //@Transactional(readOnly = true)
    public List<GeneratorData> query(GeneratorDataQueryParameter parameter) {
        generatorDataServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setUserId(parameter.getUserId());
        generatorDataQuery.setGeneratorId(parameter.getGeneratorId());
        generatorDataQuery.setGeneratorInstanceId(parameter.getGeneratorInstanceId());
        generatorDataQuery.setDataModelId(parameter.getDataModelId());
        generatorDataQuery.setName(parameter.getName());
        generatorDataQuery.setParentId(parameter.getParentId());

        List<GeneratorDataPo> generatorDataPoList = generatorDataDao.selectList(generatorDataQuery);

        List<GeneratorData> generatorDataList = new ArrayList<>();
        if(generatorDataPoList.isEmpty()){
            return generatorDataList;
        }
        
        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        Map<Long, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        Map<Long, DataModel> dataModelMap = new HashMap<>();
        Map<Long, GeneratorData> parentMap = new HashMap<>();
        generatorDataPoList.forEach(po -> {
            GeneratorData generatorData = new GeneratorData();
            
            generatorData.setId(po.getId());

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
                generatorData.setUser(user);
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
                generatorData.setGenerator(generator);
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
                generatorData.setGeneratorInstance(generatorInstance);
            }

            Long dataModelId = po.getDataModelId();
            if(dataModelId != null) {
                DataModel dataModel;
                if(dataModelMap.containsKey(dataModelId)) {
                    dataModel = dataModelMap.get(dataModelId);
                }
                else {
                    dataModel = new DataModel();
                    dataModel.setId(dataModelId);
                    dataModelMap.put(dataModelId, dataModel);
                }
                generatorData.setDataModel(dataModel);
            }

            generatorData.setName(po.getName());

            generatorData.setIsExpanded(po.getIsExpanded());

            generatorData.setDisplayOrder(po.getDisplayOrder());

            Long parentId = po.getParentId();
            if(parentId != null) {
                GeneratorData parent;
                if(parentMap.containsKey(parentId)) {
                    parent = parentMap.get(parentId);
                }
                else {
                    parent = new GeneratorData();
                    parent.setId(parentId);
                    parentMap.put(parentId, parent);
                }
                generatorData.setParent(parent);
            }

            generatorData.setCreateTime(po.getCreateTime());

            generatorData.setUpdateTime(po.getUpdateTime());

            generatorDataList.add(generatorData);
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

        if(!generatorInstanceMap.isEmpty()){
            GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
            generatorInstanceQuery.setIdList(new ArrayList<>(generatorInstanceMap.keySet()));
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectList(generatorInstanceQuery);
            generatorInstancePos.forEach(po -> {
                Long id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        if(!dataModelMap.isEmpty()){
            DataModelQuery dataModelQuery = new DataModelQuery();
            dataModelQuery.setIdList(new ArrayList<>(dataModelMap.keySet()));
            List<DataModelPo> dataModelPos = dataModelDao.selectList(dataModelQuery);
            dataModelPos.forEach(po -> {
                Long id = po.getId();
                DataModel dataModel = dataModelMap.get(id);
                dataModel.setId(id);
            });
        }

        return generatorDataList;
    }

    /**
     * 生成器数据分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<GeneratorData> search(GeneratorDataSearchParameter parameter) {
        generatorDataServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<GeneratorData> pageResult = new PageResult<>();
        List<GeneratorData> records = pageResult.getRecords();

        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setUserId(parameter.getUserId());
        generatorDataQuery.setGeneratorId(parameter.getGeneratorId());
        generatorDataQuery.setGeneratorInstanceId(parameter.getGeneratorInstanceId());
        generatorDataQuery.setDataModelId(parameter.getDataModelId());
        generatorDataQuery.setName(parameter.getName());
        generatorDataQuery.setParentId(parameter.getParentId());
        generatorDataQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorDataPo> generatorDataPoPageResult = generatorDataDao.selectPage(generatorDataQuery);
        pageResult.setTotal(generatorDataPoPageResult.getTotal());

        Map<Long, User> userMap = new HashMap<>();
        Map<Long, Generator> generatorMap = new HashMap<>();
        Map<Long, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        Map<Long, DataModel> dataModelMap = new HashMap<>();
        Map<Long, GeneratorData> parentMap = new HashMap<>();
        generatorDataPoPageResult.getRecords().forEach(po -> {
            GeneratorData generatorData = new GeneratorData();
            
            generatorData.setId(po.getId());

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
                generatorData.setUser(user);
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
                generatorData.setGenerator(generator);
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
                generatorData.setGeneratorInstance(generatorInstance);
            }

            Long dataModelId = po.getDataModelId();
            if(dataModelId != null) {
                DataModel dataModel;
                if(dataModelMap.containsKey(dataModelId)) {
                    dataModel = dataModelMap.get(dataModelId);
                }
                else {
                    dataModel = new DataModel();
                    dataModel.setId(dataModelId);
                    dataModelMap.put(dataModelId, dataModel);
                }
                generatorData.setDataModel(dataModel);
            }

            generatorData.setName(po.getName());

            generatorData.setIsExpanded(po.getIsExpanded());

            generatorData.setDisplayOrder(po.getDisplayOrder());

            Long parentId = po.getParentId();
            if(parentId != null) {
                GeneratorData parent;
                if(parentMap.containsKey(parentId)) {
                    parent = parentMap.get(parentId);
                }
                else {
                    parent = new GeneratorData();
                    parent.setId(parentId);
                    parentMap.put(parentId, parent);
                }
                generatorData.setParent(parent);
            }

            generatorData.setCreateTime(po.getCreateTime());

            generatorData.setUpdateTime(po.getUpdateTime());

            records.add(generatorData);
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

        if(!generatorInstanceMap.isEmpty()){
            GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
            generatorInstanceQuery.setIdList(new ArrayList<>(generatorInstanceMap.keySet()));
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectList(generatorInstanceQuery);
            generatorInstancePos.forEach(po -> {
                Long id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        if(!dataModelMap.isEmpty()){
            DataModelQuery dataModelQuery = new DataModelQuery();
            dataModelQuery.setIdList(new ArrayList<>(dataModelMap.keySet()));
            List<DataModelPo> dataModelPos = dataModelDao.selectList(dataModelQuery);
            dataModelPos.forEach(po -> {
                Long id = po.getId();
                DataModel dataModel = dataModelMap.get(id);
                dataModel.setId(id);
            });
        }

        return pageResult;
    }

    /**
     * 生成器数据树形查询
     */
    //@Transactional(readOnly = true)
    public List<GeneratorData> tree(GeneratorDataTreeParameter parameter) {
        generatorDataServiceTool.treeValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        Long authUserId = auth.getUserId();
        
        List<GeneratorData> generatorDataList = new ArrayList<>();

        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setUserId(authUserId);
        List<GeneratorDataPo> generatorDataPoList = generatorDataDao.selectList(generatorDataQuery);

        Map<Long, GeneratorData> index = new HashMap<>();
        for(GeneratorDataPo generatorDataPo : generatorDataPoList){
            GeneratorData generatorData = new GeneratorData();
            generatorData.setId(generatorDataPo.getId());

            User user = new User();
            user.setId(generatorDataPo.getUserId());
            generatorData.setUser(user);

            Generator generator = new Generator();
            generator.setId(generatorDataPo.getGeneratorId());
            generatorData.setGenerator(generator);

            GeneratorInstance generatorInstance = new GeneratorInstance();
            generatorInstance.setId(generatorDataPo.getGeneratorInstanceId());
            generatorData.setGeneratorInstance(generatorInstance);

            DataModel dataModel = new DataModel();
            dataModel.setId(generatorDataPo.getDataModelId());
            generatorData.setDataModel(dataModel);
            generatorData.setName(generatorDataPo.getName());
            generatorData.setIsExpanded(generatorDataPo.getIsExpanded());
            generatorData.setDisplayOrder(generatorDataPo.getDisplayOrder());
            if(generatorDataPo.getParentId() == null || generatorDataPo.getParentId() == 0){
                generatorDataList.add(generatorData);
            }
            else{
                GeneratorData parent = new GeneratorData();
                parent.setId(generatorDataPo.getParentId());
                generatorData.setParent(parent);
            }
            generatorData.setCreateTime(generatorDataPo.getCreateTime());
            generatorData.setUpdateTime(generatorDataPo.getUpdateTime());

            index.put(generatorDataPo.getId(), generatorData);
        }
        
        generatorDataPoList.forEach(generatorDataPo -> {
            GeneratorData generatorData = index.get(generatorDataPo.getId());
            GeneratorData parent = generatorData.getParent();
            if(parent != null) {
                parent = index.get(parent.getId());
                parent.getChildren().add(generatorData);
            }
        });

        return generatorDataList;
    }
    
    /**
     * 生成器数据排序
     */
    @Transactional
    public GeneratorData sort(GeneratorDataSortParameter parameter) {
        generatorDataServiceTool.sortValidate(parameter);
    
        Auth auth = parameter.getAuth();

        GeneratorData generatorData = new GeneratorData();

        return generatorData;
    }
    
}
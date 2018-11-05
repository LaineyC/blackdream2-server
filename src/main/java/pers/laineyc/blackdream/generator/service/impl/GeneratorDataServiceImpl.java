package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.framework.dao.query.Order;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.generator.constant.GeneratorStatusEnum;
import pers.laineyc.blackdream.generator.exception.ErrorCodes;
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
        String authUserId = auth.getUserId();
    
        GeneratorDataPo generatorDataPo = new GeneratorDataPo();
        
        generatorDataPo.setUserId(authUserId);

        String generatorInstanceId = parameter.getGeneratorInstanceId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !authUserId.equals(generatorInstancePo.getUserId())){
            throw new BusinessException("所属生成器实例不存在");
        }

        String generatorId = generatorInstancePo.getGeneratorId();
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }
        if(!generatorInstancePo.getReleaseVersion().equals(generatorPo.getReleaseVersion())){
            throw new BusinessException(ErrorCodes.EC_020001);
        }
        if (generatorPo.getStatus() == GeneratorStatusEnum.DEVELOP.getCode() && !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException(ErrorCodes.EC_020002);
        }
        generatorDataPo.setGeneratorInstanceId(generatorInstanceId);
        generatorDataPo.setGeneratorId(generatorId);

        String dataModelId = parameter.getDataModelId();
        generatorDataPo.setDataModelId(dataModelId);

        String name = parameter.getName();
        generatorDataPo.setName(name);

        Boolean isExpanded = parameter.getIsExpanded();
        generatorDataPo.setIsExpanded(isExpanded);

        generatorDataPo.setDisplayOrder(1000);

        String parentId = parameter.getParentId();
        generatorDataPo.setParentId(parentId);

        generatorDataPo.setIsDeleted(false);

        generatorDataPo.setCreateTime(now);

        generatorDataPo.setUpdateTime(now);

        generatorDataPo.setProperties(parameter.getProperties());

        generatorDataPo.setTupleList(parameter.getTupleList());

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
        String authUserId = auth.getUserId();

        List<String> idList = parameter.getIdList();
        String id = parameter.getId();
        if(StringUtils.hasText(id)){
            idList.add(id);
        }
        String generatorId = null;
        String generatorInstanceId = null;
        for(String item : idList){
            GeneratorDataPo generatorDataPo = generatorDataDao.selectById(item);
            if (generatorDataPo == null || generatorDataPo.getIsDeleted() || !generatorDataPo.getUserId().equals(authUserId)) {
                throw new BusinessException("生成器数据不存在");
            }

            if(generatorId == null){
                generatorId = generatorDataPo.getGeneratorId();
            }
            else if(!generatorId.equals(generatorDataPo.getGeneratorId())){
                throw new BusinessException("不属于同一个生成器");
            }

            if(generatorInstanceId == null){
                generatorInstanceId = generatorDataPo.getGeneratorInstanceId();
            }
            else if(!generatorInstanceId.equals(generatorDataPo.getGeneratorInstanceId())){
                throw new BusinessException("不属于同一个生成器实例");
            }
        }

        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !authUserId.equals(generatorInstancePo.getUserId())){
            throw new BusinessException("所属生成器实例不存在");
        }

        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }

        if(!generatorInstancePo.getReleaseVersion().equals(generatorPo.getReleaseVersion())){
            throw new BusinessException(ErrorCodes.EC_020001);
        }
        if (generatorPo.getStatus() == GeneratorStatusEnum.DEVELOP.getCode() && !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException(ErrorCodes.EC_020002);
        }

        for(String item : idList){
            GeneratorDataPo generatorDataPoUpdate = new GeneratorDataPo();
            generatorDataPoUpdate.setId(item);
            generatorDataPoUpdate.setUpdateTime(now);
            generatorDataPoUpdate.setIsDeleted(true);
            generatorDataDao.updateSelective(generatorDataPoUpdate);
        }

        GeneratorData generatorData = new GeneratorData();

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
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null || generatorDataPo.getIsDeleted() || !generatorDataPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据不存在");
        }

        String generatorInstanceId = generatorDataPo.getGeneratorInstanceId();
        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !authUserId.equals(generatorInstancePo.getUserId())){
            throw new BusinessException("所属生成器实例不存在");
        }

        String generatorId = generatorInstancePo.getGeneratorId();
        GeneratorPo generatorPo = generatorDao.selectById(generatorId);
        if(generatorPo == null || generatorPo.getIsDeleted()){
            throw new BusinessException("所属生成器不存在");
        }
        if(!generatorInstancePo.getReleaseVersion().equals(generatorPo.getReleaseVersion())){
            throw new BusinessException(ErrorCodes.EC_020001);
        }
        if (generatorPo.getStatus() == GeneratorStatusEnum.DEVELOP.getCode() && !generatorPo.getUserId().equals(authUserId)){
            throw new BusinessException(ErrorCodes.EC_020002);
        }

        String name = parameter.getName();
        generatorDataPo.setName(name);

        Boolean isExpanded = parameter.getIsExpanded();
        generatorDataPo.setIsExpanded(isExpanded);

        String parentId = parameter.getParentId();
        generatorDataPo.setParentId(parentId);

        generatorDataPo.setUpdateTime(now);

        generatorDataPo.setProperties(parameter.getProperties());

        generatorDataPo.setTupleList(parameter.getTupleList());

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
        
        String id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null || generatorDataPo.getIsDeleted()){
            throw new BusinessException("生成器数据不存在");
        }

        GeneratorData generatorData = new GeneratorData();
        
        generatorData.setId(generatorDataPo.getId());

        String userId = generatorDataPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                generatorData.setUser(user);
            }
        }

        String generatorId = generatorDataPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                generatorData.setGenerator(generator);
            }
        }

        String generatorInstanceId = generatorDataPo.getGeneratorInstanceId();
        if(generatorInstanceId != null){
            GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
            if(generatorInstancePo != null){
                GeneratorInstance generatorInstance = new GeneratorInstance();
                generatorInstance.setId(generatorInstancePo.getId());
                generatorData.setGeneratorInstance(generatorInstance);
            }
        }

        String dataModelId = generatorDataPo.getDataModelId();
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

        String parentId = generatorDataPo.getParentId();
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

        generatorData.setProperties(generatorDataPo.getProperties());

        generatorData.setTupleList(generatorDataPo.getTupleList());

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
        
        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        Map<String, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        Map<String, DataModel> dataModelMap = new HashMap<>();
        Map<String, GeneratorData> parentMap = new HashMap<>();
        generatorDataPoList.forEach(po -> {
            GeneratorData generatorData = new GeneratorData();
            
            generatorData.setId(po.getId());

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
                generatorData.setUser(user);
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
                generatorData.setGenerator(generator);
            }

            String generatorInstanceId = po.getGeneratorInstanceId();
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

            String dataModelId = po.getDataModelId();
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

            String parentId = po.getParentId();
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

        if(!generatorInstanceMap.isEmpty()){
            GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
            generatorInstanceQuery.setIdList(new ArrayList<>(generatorInstanceMap.keySet()));
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectList(generatorInstanceQuery);
            generatorInstancePos.forEach(po -> {
                String id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        if(!dataModelMap.isEmpty()){
            DataModelQuery dataModelQuery = new DataModelQuery();
            dataModelQuery.setIdList(new ArrayList<>(dataModelMap.keySet()));
            List<DataModelPo> dataModelPos = dataModelDao.selectList(dataModelQuery);
            dataModelPos.forEach(po -> {
                String id = po.getId();
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

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        Map<String, GeneratorInstance> generatorInstanceMap = new HashMap<>();
        Map<String, DataModel> dataModelMap = new HashMap<>();
        Map<String, GeneratorData> parentMap = new HashMap<>();
        generatorDataPoPageResult.getRecords().forEach(po -> {
            GeneratorData generatorData = new GeneratorData();
            
            generatorData.setId(po.getId());

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
                generatorData.setUser(user);
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
                generatorData.setGenerator(generator);
            }

            String generatorInstanceId = po.getGeneratorInstanceId();
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

            String dataModelId = po.getDataModelId();
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

            String parentId = po.getParentId();
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

        if(!generatorInstanceMap.isEmpty()){
            GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
            generatorInstanceQuery.setIdList(new ArrayList<>(generatorInstanceMap.keySet()));
            List<GeneratorInstancePo> generatorInstancePos = generatorInstanceDao.selectList(generatorInstanceQuery);
            generatorInstancePos.forEach(po -> {
                String id = po.getId();
                GeneratorInstance generatorInstance = generatorInstanceMap.get(id);
                generatorInstance.setId(id);
            });
        }

        if(!dataModelMap.isEmpty()){
            DataModelQuery dataModelQuery = new DataModelQuery();
            dataModelQuery.setIdList(new ArrayList<>(dataModelMap.keySet()));
            List<DataModelPo> dataModelPos = dataModelDao.selectList(dataModelQuery);
            dataModelPos.forEach(po -> {
                String id = po.getId();
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
        String authUserId = auth.getUserId();
        
        List<GeneratorData> generatorDataList = new ArrayList<>();

        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setUserId(authUserId);
        generatorDataQuery.setGeneratorInstanceId(parameter.getGeneratorInstanceId());
        generatorDataQuery.orderByDisplayOrder(Order.Direction.ASC);
        List<GeneratorDataPo> generatorDataPoList = generatorDataDao.selectList(generatorDataQuery);

        Map<String, GeneratorData> index = new HashMap<>();
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
            if(generatorDataPo.getParentId() == null){
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

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null || generatorDataPo.getIsDeleted() || !generatorDataPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据不存在");
        }

        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setGeneratorInstanceId(generatorDataPo.getGeneratorInstanceId());
        generatorDataQuery.setParentId(generatorDataPo.getParentId());
        generatorDataQuery.orderByDisplayOrder(Order.Direction.ASC);
        List<GeneratorDataPo> generatorDataPoList = generatorDataDao.selectList(generatorDataQuery);

        int fromIndex = parameter.getFromIndex();
        int toIndex = parameter.getToIndex();
        int size = generatorDataPoList.size();
        if(size == 0 || toIndex > size - 1 || fromIndex > size - 1){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }

        GeneratorDataPo generatorDataPoRemove = generatorDataPoList.remove(fromIndex);
        if(generatorDataPoRemove == null || !id.equals(generatorDataPoRemove.getId())){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }
        generatorDataPoList.add(toIndex, generatorDataPoRemove);

        int displayOrder = 1;
        for(GeneratorDataPo po : generatorDataPoList){
            String poId = po.getId();
            if(po.getDisplayOrder() != displayOrder) {
                GeneratorDataPo generatorDataPoUpdate = new GeneratorDataPo();
                generatorDataPoUpdate.setId(poId);
                generatorDataPoUpdate.setDisplayOrder(displayOrder);
                generatorDataPoUpdate.setUpdateTime(now);
                generatorDataDao.updateSelective(generatorDataPoUpdate);
            }
            displayOrder++;
        }

        GeneratorData generatorData = new GeneratorData();

        return generatorData;
    }
    
}
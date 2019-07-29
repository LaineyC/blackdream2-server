package pers.laineyc.blackdream.generator.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.framework.dao.query.Order;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.generator.dao.GeneratorDataDao;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import pers.laineyc.blackdream.generator.dao.po.GeneratorInstancePo;
import pers.laineyc.blackdream.generator.dao.query.GeneratorDataQuery;
import pers.laineyc.blackdream.generator.dao.query.GeneratorInstanceQuery;
import pers.laineyc.blackdream.generator.service.DataModelService;
import pers.laineyc.blackdream.generator.service.GeneratorService;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.DataModelServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.service.domain.DataModel;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;
import pers.laineyc.blackdream.generator.dao.query.DataModelQuery;
import pers.laineyc.blackdream.generator.dao.DataModelDao;
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
 * 生成器数据模型ServiceImpl
 * @author LaineyC
 */
@Primary
@Service
public class DataModelServiceImpl extends BaseService implements DataModelService {

    @Autowired
    private DataModelServiceTool dataModelServiceTool;

    @Autowired
    private DataModelDao dataModelDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GeneratorDao generatorDao;

    @Autowired
    private GeneratorInstanceDao generatorInstanceDao;

    @Autowired
    private GeneratorDataDao generatorDataDao;

    @Autowired
    private GeneratorService generatorService;

    public DataModelServiceImpl() {

	}

    /**
     * 生成器数据模型创建
     */
    @Transactional
    public DataModel create(DataModelCreateParameter parameter) {
        dataModelServiceTool.createValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        DataModelPo dataModelPo = new DataModelPo();
        
        dataModelPo.setUserId(authUserId);

        String generatorId = parameter.getGeneratorId();
        dataModelPo.setGeneratorId(generatorId);

        String name = parameter.getName();
        dataModelPo.setName(name);

        String code = ObjectId.get().toString();
        dataModelPo.setCode(code);

        String iconStyle = parameter.getIconStyle();
        dataModelPo.setIconStyle(iconStyle);

        Integer displayOrder = parameter.getDisplayOrder();
        dataModelPo.setDisplayOrder(displayOrder);

        String description = parameter.getDescription();
        dataModelPo.setDescription(description);

        dataModelPo.setIsDeleted(false);

        dataModelPo.setCreateTime(now);

        dataModelPo.setUpdateTime(now);

        dataModelPo.setPropertyList(parameter.getPropertyList());

        dataModelPo.setFieldList(parameter.getFieldList());

        dataModelDao.insert(dataModelPo);

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(generatorId);
        generatorService.develop(generatorDevelopParameter);

        DataModel dataModel = new DataModel();
        dataModel.setId(dataModelPo.getId());
        dataModel.setCode(dataModelPo.getCode());

        return dataModel;
    }

    /**
     * 生成器数据模型删除
     */
    @Transactional
    public DataModel delete(DataModelDeleteParameter parameter) {
        dataModelServiceTool.deleteValidate(parameter);

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
            DataModelPo dataModelPo = dataModelDao.selectById(item);
            if (dataModelPo == null || dataModelPo.getIsDeleted() || !dataModelPo.getUserId().equals(authUserId)) {
                throw new BusinessException("生成器数据模型不存在");
            }

            if(generatorId == null){
                generatorId = dataModelPo.getGeneratorId();
            }
            else if(!generatorId.equals(dataModelPo.getGeneratorId())){
                throw new BusinessException("不属于同一个生成器");
            }
/*
            GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
            generatorDataQuery.setDataModelId(item);
            generatorDataQuery.setIsDeleted(false);
            int generatorDataCount = generatorDataDao.selectCount(generatorDataQuery);
            if(generatorDataCount > 0){
                throw new BusinessException("生成器数据模型已被应用不能删除");
            }
*/
        }

        GeneratorInstanceQuery generatorInstanceQuery = new GeneratorInstanceQuery();
        generatorInstanceQuery.setIsDeleted(false);
        generatorInstanceQuery.setGeneratorId(generatorId);
        List<GeneratorInstancePo> generatorInstancePoList = generatorInstanceDao.selectList(generatorInstanceQuery);
        generatorInstancePoList.forEach(generatorInstancePo -> {
            if(!authUserId.equals(generatorInstancePo.getUserId())){
                throw new BusinessException("生成器数据模型已被应用不能删除");
            }
        });

        for(String item : idList){
            DataModelPo dataModelPoUpdate = new DataModelPo();
            dataModelPoUpdate.setId(item);
            dataModelPoUpdate.setUpdateTime(now);
            dataModelPoUpdate.setIsDeleted(true);
            dataModelDao.updateSelective(dataModelPoUpdate);
        }

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(generatorId);
        generatorService.develop(generatorDevelopParameter);

        DataModel dataModel = new DataModel();

        return dataModel;
    }

    /**
     * 生成器数据模型修改
     */
    @Transactional
    public DataModel update(DataModelUpdateParameter parameter) {
        dataModelServiceTool.updateValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        DataModelPo dataModelPo = dataModelDao.selectById(id);
        if(dataModelPo == null || dataModelPo.getIsDeleted() || !dataModelPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据模型不存在");
        }

        String name = parameter.getName();
        dataModelPo.setName(name);
/*
        String code = parameter.getCode();
        if(!StringUtils.hasText(code)){
            code = id.toString();
        }
        dataModelPo.setCode(code);
*/
        String iconStyle = parameter.getIconStyle();
        dataModelPo.setIconStyle(iconStyle);

        String description = parameter.getDescription();
        dataModelPo.setDescription(description);

        dataModelPo.setUpdateTime(now);

        dataModelPo.setPropertyList(parameter.getPropertyList());

        dataModelPo.setFieldList(parameter.getFieldList());

        dataModelDao.update(dataModelPo);

        GeneratorDevelopParameter generatorDevelopParameter = new GeneratorDevelopParameter();
        generatorDevelopParameter.setAuth(auth);
        generatorDevelopParameter.setId(dataModelPo.getGeneratorId());
        generatorDevelopParameter.setIsResetReleaseVersion(true);
        generatorService.develop(generatorDevelopParameter);

        DataModel dataModel = new DataModel();
        dataModel.setId(id);

        return dataModel;
    }
    
    /**
     * 生成器数据模型单个查询
     */
    //@Transactional(readOnly = true)
    public DataModel get(DataModelGetParameter parameter) {
        dataModelServiceTool.getValidate(parameter);
        
        Auth auth = parameter.getAuth();
        
        String id = parameter.getId();
        DataModelPo dataModelPo = dataModelDao.selectById(id);
        if(dataModelPo == null || dataModelPo.getIsDeleted()){
            throw new BusinessException("生成器数据模型不存在");
        }

        DataModel dataModel = new DataModel();
        
        dataModel.setId(dataModelPo.getId());

        String userId = dataModelPo.getUserId();
        if(userId != null){
            UserPo userPo = userDao.selectById(userId);
            if(userPo != null){
                User user = new User();
                user.setId(userPo.getId());
                dataModel.setUser(user);
            }
        }

        String generatorId = dataModelPo.getGeneratorId();
        if(generatorId != null){
            GeneratorPo generatorPo = generatorDao.selectById(generatorId);
            if(generatorPo != null){
                Generator generator = new Generator();
                generator.setId(generatorPo.getId());
                dataModel.setGenerator(generator);
            }
        }

        dataModel.setName(dataModelPo.getName());

        dataModel.setCode(dataModelPo.getCode());

        dataModel.setIconStyle(dataModelPo.getIconStyle());

        dataModel.setDisplayOrder(dataModelPo.getDisplayOrder());

        dataModel.setDescription(dataModelPo.getDescription());

        dataModel.setCreateTime(dataModelPo.getCreateTime());

        dataModel.setUpdateTime(dataModelPo.getUpdateTime());

        dataModel.setPropertyList(dataModelPo.getPropertyList());

        dataModel.setFieldList(dataModelPo.getFieldList());

        return dataModel;
    }

    /**
     * 生成器数据模型多个查询
     */
    //@Transactional(readOnly = true)
    public List<DataModel> query(DataModelQueryParameter parameter) {
        dataModelServiceTool.queryValidate(parameter);
    
        Auth auth = parameter.getAuth();
        
        DataModelQuery dataModelQuery = new DataModelQuery();
        dataModelQuery.setIsDeleted(false);
        dataModelQuery.setUserId(parameter.getUserId());
        dataModelQuery.setGeneratorId(parameter.getGeneratorId());
        dataModelQuery.setName(parameter.getName());
        dataModelQuery.setCode(parameter.getCode());
        dataModelQuery.setIconStyle(parameter.getIconStyle());
        Boolean fetchLazy = parameter.getFetchLazy();
        dataModelQuery.fetchLazy(fetchLazy == null || fetchLazy);

        List<DataModelPo> dataModelPoList = dataModelDao.selectList(dataModelQuery);

        List<DataModel> dataModelList = new ArrayList<>();
        if(dataModelPoList.isEmpty()){
            return dataModelList;
        }
        
        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        dataModelPoList.forEach(po -> {
            DataModel dataModel = new DataModel();
            
            dataModel.setId(po.getId());

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
                dataModel.setUser(user);
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
                dataModel.setGenerator(generator);
            }

            dataModel.setName(po.getName());

            dataModel.setCode(po.getCode());

            dataModel.setIconStyle(po.getIconStyle());

            dataModel.setDisplayOrder(po.getDisplayOrder());

            dataModel.setDescription(po.getDescription());

            dataModel.setCreateTime(po.getCreateTime());

            dataModel.setUpdateTime(po.getUpdateTime());

            dataModel.setPropertyList(po.getPropertyList());

            dataModel.setFieldList(po.getFieldList());

            dataModelList.add(dataModel);
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

        return dataModelList;
    }

    /**
     * 生成器数据模型分页查询
     */
    //@Transactional(readOnly = true)
    public PageResult<DataModel> search(DataModelSearchParameter parameter) {
        dataModelServiceTool.searchValidate(parameter);
    
        Auth auth = parameter.getAuth();

        Integer page = parameter.getPage();

        Integer pageSize = parameter.getPageSize();
        
        PageResult<DataModel> pageResult = new PageResult<>();
        List<DataModel> records = pageResult.getRecords();

        DataModelQuery dataModelQuery = new DataModelQuery();
        dataModelQuery.setIsDeleted(false);
        dataModelQuery.setUserId(parameter.getUserId());
        dataModelQuery.setGeneratorId(parameter.getGeneratorId());
        dataModelQuery.setName(parameter.getName());
        dataModelQuery.setCode(parameter.getCode());
        dataModelQuery.setIconStyle(parameter.getIconStyle());
        dataModelQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<DataModelPo> dataModelPoPageResult = dataModelDao.selectPage(dataModelQuery);
        pageResult.setTotal(dataModelPoPageResult.getTotal());

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        dataModelPoPageResult.getRecords().forEach(po -> {
            DataModel dataModel = new DataModel();
            
            dataModel.setId(po.getId());

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
                dataModel.setUser(user);
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
                dataModel.setGenerator(generator);
            }

            dataModel.setName(po.getName());

            dataModel.setCode(po.getCode());

            dataModel.setIconStyle(po.getIconStyle());

            dataModel.setDisplayOrder(po.getDisplayOrder());

            dataModel.setDescription(po.getDescription());

            dataModel.setCreateTime(po.getCreateTime());

            dataModel.setUpdateTime(po.getUpdateTime());

            records.add(dataModel);
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
     * 生成器数据模型排序
     */
    @Transactional
    public DataModel sort(DataModelSortParameter parameter) {
        dataModelServiceTool.sortValidate(parameter);

        Date now = new Date();
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        DataModelPo dataModelPo = dataModelDao.selectById(id);
        if(dataModelPo == null || dataModelPo.getIsDeleted() || !dataModelPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据模型不存在");
        }

        DataModelQuery dataModelQuery = new DataModelQuery();
        dataModelQuery.setIsDeleted(false);
        dataModelQuery.setGeneratorId(dataModelPo.getGeneratorId());
        dataModelQuery.orderByDisplayOrder(Order.Direction.ASC);
        List<DataModelPo> dataModelPoList = dataModelDao.selectList(dataModelQuery);

        int fromIndex = parameter.getFromIndex();
        int toIndex = parameter.getToIndex();
        int size = dataModelPoList.size();
        if(size == 0 || toIndex > size - 1 || fromIndex > size - 1){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }

        DataModelPo dataModelPoRemove = dataModelPoList.remove(fromIndex);
        if(dataModelPoRemove == null || !id.equals(dataModelPoRemove.getId())){
            throw new BusinessException("请保存并刷新数据，重新操作！");
        }
        dataModelPoList.add(toIndex, dataModelPoRemove);

        int displayOrder = 1;
        for(DataModelPo po : dataModelPoList){
            String poId = po.getId();
            if(po.getDisplayOrder() != displayOrder) {
                DataModelPo dataModelPoUpdate = new DataModelPo();
                dataModelPoUpdate.setId(poId);
                dataModelPoUpdate.setDisplayOrder(displayOrder);
                dataModelPoUpdate.setUpdateTime(now);
                dataModelDao.updateSelective(dataModelPoUpdate);
            }
            displayOrder++;
        }

        DataModel dataModel = new DataModel();

        return dataModel;
    }

    /**
     * 生成器数据模型多个查询
     */
    //@Transactional(readOnly = true)
    public List<DataModel> infoQuery(DataModelInfoQueryParameter parameter) {
        dataModelServiceTool.infoQueryValidate(parameter);

        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        DataModelQueryParameter dataModelQueryParameter = new DataModelQueryParameter();
        BeanUtils.copyProperties(parameter, dataModelQueryParameter);
        dataModelQueryParameter.setUserId(authUserId);

        return this.query(dataModelQueryParameter);
    }

    @Transactional
    @Override
    public List<DataModel> createFrom(DataModelCreateFromParameter parameter) {
        Auth auth = parameter.getAuth();
        List<DataModel> domainList = new ArrayList<>();

        String generatorId = parameter.getGeneratorId();
        String fromGeneratorId = parameter.getFromGeneratorId();

        DataModelQuery dataModelQuery = new DataModelQuery();
        dataModelQuery.setIsDeleted(false);
        dataModelQuery.setGeneratorId(fromGeneratorId);
        dataModelQuery.fetchLazy(false);
        List<DataModelPo> dataModelPoList = dataModelDao.selectList(dataModelQuery);
        if (CollectionUtils.isEmpty(dataModelPoList)) {
            return domainList;
        }

        dataModelPoList.forEach(dataModelPo -> {
            DataModelCreateParameter dataModelCreateParameter = new DataModelCreateParameter();
            dataModelCreateParameter.setCode(dataModelPo.getCode());
            dataModelCreateParameter.setDescription(dataModelPo.getDescription());
            dataModelCreateParameter.setGeneratorId(generatorId);
            dataModelCreateParameter.setIconStyle(dataModelPo.getIconStyle());
            dataModelCreateParameter.setName(dataModelPo.getName());
            dataModelCreateParameter.setFieldList(dataModelPo.getFieldList());
            dataModelCreateParameter.setPropertyList(dataModelPo.getPropertyList());
            dataModelCreateParameter.setDisplayOrder(dataModelPo.getDisplayOrder());
            dataModelCreateParameter.setAuth(auth);
            domainList.add(create(dataModelCreateParameter));
        });

        return domainList;
    }
}
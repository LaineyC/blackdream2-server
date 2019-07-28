package pers.laineyc.blackdream.generator.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.laineyc.blackdream.configuration.tool.PathTool;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.framework.service.BaseService;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.util.BeanUtils;
import pers.laineyc.blackdream.generator.constant.DataModelAttributeDataTypeEnum;
import pers.laineyc.blackdream.generator.constant.GeneratorStatusEnum;
import pers.laineyc.blackdream.generator.dao.*;
import pers.laineyc.blackdream.generator.dao.po.*;
import pers.laineyc.blackdream.generator.dao.query.*;
import pers.laineyc.blackdream.generator.exception.ErrorCodes;
import pers.laineyc.blackdream.generator.service.GeneratorInstanceService;
import pers.laineyc.blackdream.generator.service.TemplateFileService;
import pers.laineyc.blackdream.generator.service.domain.*;
import pers.laineyc.blackdream.generator.service.parameter.*;
import pers.laineyc.blackdream.generator.tool.GeneratorInstanceServiceTool;
import pers.laineyc.blackdream.framework.model.PageResult;
import pers.laineyc.blackdream.generator.tool.CreationStrategyScriptTool;
import pers.laineyc.blackdream.generator.tool.TemplateFileServiceTool;
import pers.laineyc.blackdream.usercenter.service.domain.User;
import pers.laineyc.blackdream.usercenter.dao.po.UserPo;
import pers.laineyc.blackdream.usercenter.dao.query.UserQuery;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private CreationStrategyDao creationStrategyDao;

    @Autowired
    private TemplateFileDao templateFileDao;

    @Autowired
    private GeneratorDataDao generatorDataDao;

    @Autowired
    private DataModelDao dataModelDao;

    @Autowired
    private TemplateFileServiceTool templateFileServiceTool;

    @Autowired
    private PathTool pathTool;

    @Autowired
    private TemplateFileService templateFileService;

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

        generatorInstancePo.setUpdateTime(now);

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
            if (userId != null) {
                User user;
                if (userMap.containsKey(userId)) {
                    user = userMap.get(userId);
                } else {
                    user = new User();
                    user.setId(userId);
                    userMap.put(userId, user);
                }
                generatorInstance.setUser(user);
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
        generatorInstanceQuery.setNameLike(parameter.getName());
        generatorInstanceQuery.limit((page - 1) * pageSize, pageSize);
        
        PageResult<GeneratorInstancePo> generatorInstancePoPageResult = generatorInstanceDao.selectPage(generatorInstanceQuery);
        pageResult.setTotal(generatorInstancePoPageResult.getTotal());

        Map<String, User> userMap = new HashMap<>();
        Map<String, Generator> generatorMap = new HashMap<>();
        generatorInstancePoPageResult.getRecords().forEach(po -> {
            GeneratorInstance generatorInstance = new GeneratorInstance();

            generatorInstance.setId(po.getId());

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
                generatorInstance.setUser(user);
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
                user.setUsername(po.getUsername());
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
                generator.setName(po.getName());
                generator.setStatus(po.getStatus());
                User user = new User();
                user.setId(po.getUserId());
                generator.setUser(user);
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

    private GeneratorInstanceMakeResult make(Auth auth, String generatorInstanceId, String creationStrategyId, List<String> generatorDataIdList, boolean isTest) {
        Date now = new Date();
        String authUserId = auth.getUserId();

        GeneratorInstanceMakeResult generatorInstanceMakeResult = new GeneratorInstanceMakeResult();

        GeneratorInstancePo generatorInstancePo = generatorInstanceDao.selectById(generatorInstanceId);
        if(generatorInstancePo == null || generatorInstancePo.getIsDeleted() || !generatorInstancePo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器实例不存在");
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

        TemplateFileQuery templateFileQuery = new TemplateFileQuery();
        templateFileQuery.setIsDeleted(false);
        templateFileQuery.setGeneratorId(generatorId);
        List<TemplateFilePo> templateFilePoList = templateFileDao.selectList(templateFileQuery);
        List<TemplateFile> templateFileList = new ArrayList<>();
        templateFilePoList.forEach(templateFilePo -> {
            TemplateFile templateFile = new TemplateFile();
            templateFile.setCode(templateFilePo.getCode());
            templateFile.setEngineType(templateFilePo.getEngineType());
            templateFileList.add(templateFile);
        });

        CreationStrategyPo creationStrategyPo = creationStrategyDao.selectById(creationStrategyId);
        if(creationStrategyPo == null || creationStrategyPo.getIsDeleted()){
            throw new BusinessException("生成器生成策略不存在");
        }

        DataModelQuery dataModelQuery = new DataModelQuery();
        dataModelQuery.setIsDeleted(false);
        dataModelQuery.setGeneratorId(generatorId);
        dataModelQuery.fetchLazy(false);
        List<DataModelPo> dataModelPoList = dataModelDao.selectList(dataModelQuery);
        //
        Map<String, DataModel> dataModelCache = new HashMap<>();
        Map<String, DataModelPo> dataModelPoCache = new HashMap<>();
        dataModelPoList.forEach(dataModelPo -> {
            String dataModelPoId = dataModelPo.getId();
            DataModel dataModel = new DataModel();
            dataModel.setId(dataModelPoId);
            dataModel.setCode(dataModelPo.getCode());
            dataModelCache.put(dataModelPoId, dataModel);
            dataModelPoCache.put(dataModelPoId, dataModelPo);
        });

        GeneratorDataQuery generatorDataQuery = new GeneratorDataQuery();
        generatorDataQuery.setIsDeleted(false);
        generatorDataQuery.setGeneratorId(generatorId);
        generatorDataQuery.setGeneratorInstanceId(generatorInstanceId);
        generatorDataQuery.fetchLazy(false);
        List<GeneratorDataPo> generatorDataPoList = generatorDataDao.selectList(generatorDataQuery);

        Map<String, GeneratorDataPo> generatorDataPoCache = new HashMap<>();
        Map<String, TemplateFileContextData> templateFileContextDataCache = new HashMap<>();
        generatorDataPoList.forEach(generatorDataPo -> {
            String generatorDataPoId = generatorDataPo.getId();
            if(!generatorDataIdList.contains(generatorDataPoId)){
                return;
            }
            TemplateFileContextData templateFileContextData = new TemplateFileContextData();
            templateFileContextData.setId(generatorDataPoId);
            templateFileContextData.setName(generatorDataPo.getName());
            templateFileContextData.setDataModel(dataModelCache.get(generatorDataPo.getDataModelId()));

            generatorDataPoCache.put(generatorDataPoId, generatorDataPo);
            templateFileContextDataCache.put(generatorDataPoId, templateFileContextData);
        });

        List<TemplateFileContextData> templateFileContextDataList = templateFileContextDataCache.values().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<TemplateFileContextData> templateFileContextDataTree = new ArrayList<>();
        templateFileContextDataList.forEach(templateFileContextData -> {
            String generatorDataPoId = templateFileContextData.getId();
            GeneratorDataPo generatorDataPo = generatorDataPoCache.get(generatorDataPoId);
            if(generatorDataPo == null){
                return;
            }

            String dataModelPoId = generatorDataPo.getDataModelId();
            DataModelPo dataModelPo = dataModelPoCache.get(dataModelPoId);
            if(dataModelPo == null){
                return;
            }

            List<DataModelAttribute> propertyList = dataModelPo.getPropertyList();
            Map<String, GeneratorDataAttributeControl> poProperties = generatorDataPo.getProperties();
            Map<String, Object> properties = templateFileContextData.getProperties();
            propertyList.forEach(property -> {
                String name = property.getName();
                GeneratorDataAttributeControl control = poProperties.get(name);
                if(control == null){
                    return;
                }
                Object objectValue = control.getValue();
                if(objectValue == null){
                    properties.put(name, null);
                }
                else{
                    Integer dataType = control.getDataType();
                    if(dataType == null){
                        properties.put(name, null);
                    }
                    else if(DataModelAttributeDataTypeEnum.NONE.getCode() == dataType){
                        properties.put(name, null);
                    }
                    else if(DataModelAttributeDataTypeEnum.BOOLEAN.getCode() == dataType){
                        properties.put(name, Boolean.valueOf(objectValue.toString()));
                    }
                    else if(DataModelAttributeDataTypeEnum.INTEGER.getCode() == dataType){
                        if(!objectValue.toString().isEmpty()){
                            properties.put(name, new BigInteger(objectValue.toString()));
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.DECIMAL.getCode() == dataType){
                        if(!objectValue.toString().isEmpty()){
                            properties.put(name, new BigDecimal(objectValue.toString()));
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.STRING.getCode() == dataType){
                        properties.put(name, objectValue.toString());
                    }
                    else if(DataModelAttributeDataTypeEnum.DATE.getCode() == dataType){
                        try {
                            properties.put(name, dateFormat.parse(objectValue.toString()));
                        }
                        catch (Exception e){

                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.TIME.getCode() == dataType){
                        try {
                            properties.put(name, timeFormat.parse(objectValue.toString()));
                        }
                        catch (Exception e){

                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.DATETIME.getCode() == dataType){
                        try {
                            properties.put(name, dateTimeFormat.parse(objectValue.toString()));
                        }
                        catch (Exception e){

                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.MODEL_REF.getCode() == dataType){
                        String dataId = objectValue.toString();
                        TemplateFileContextData data = templateFileContextDataCache.get(dataId);
                        properties.put(name, data);
                    }
                    else{
                        properties.put(name, null);
                    }
                }
            });

            List<DataModelAttribute> fieldList = dataModelPo.getFieldList();
            List<Map<String, Object>> tupleList = templateFileContextData.getTupleList();
            generatorDataPo.getTupleList().forEach(poTuple -> {
                Map<String, Object> tuple = new LinkedHashMap<>();

                fieldList.forEach(field -> {
                    String name = field.getName();
                    GeneratorDataAttributeControl control = poTuple.get(name);
                    if(control == null){
                        return;
                    }
                    Object objectValue = control.getValue();
                    if(objectValue == null){
                        tuple.put(name, null);
                    }
                    else{
                        Integer dataType = control.getDataType();
                        if(dataType == null){
                            tuple.put(name, null);
                        }
                        else if(DataModelAttributeDataTypeEnum.NONE.getCode() == dataType){
                            tuple.put(name, null);
                        }
                        else if(DataModelAttributeDataTypeEnum.BOOLEAN.getCode() == dataType){
                            tuple.put(name, Boolean.valueOf(objectValue.toString()));
                        }
                        else if(DataModelAttributeDataTypeEnum.INTEGER.getCode() == dataType){
                            if(!objectValue.toString().isEmpty()) {
                                tuple.put(name, new BigInteger(objectValue.toString()));
                            }
                        }
                        else if(DataModelAttributeDataTypeEnum.DECIMAL.getCode() == dataType){
                            if(!objectValue.toString().isEmpty()) {
                                tuple.put(name, new BigDecimal(objectValue.toString()));
                            }
                        }
                        else if(DataModelAttributeDataTypeEnum.STRING.getCode() == dataType){
                            tuple.put(name, objectValue.toString());
                        }
                        else if(DataModelAttributeDataTypeEnum.DATE.getCode() == dataType){
                            try {
                                tuple.put(name, dateFormat.parse(objectValue.toString()));
                            }
                            catch (Exception e){

                            }
                        }
                        else if(DataModelAttributeDataTypeEnum.TIME.getCode() == dataType){
                            try {
                                tuple.put(name, timeFormat.parse(objectValue.toString()));
                            }
                            catch (Exception e){

                            }
                        }
                        else if(DataModelAttributeDataTypeEnum.DATETIME.getCode() == dataType){
                            try {
                                tuple.put(name, dateTimeFormat.parse(objectValue.toString()));
                            }
                            catch (Exception e){

                            }
                        }
                        else if(DataModelAttributeDataTypeEnum.MODEL_REF.getCode() == dataType){
                            String dataId = objectValue.toString();
                            TemplateFileContextData data = templateFileContextDataCache.get(dataId);
                            tuple.put(name, data);
                        }
                        else{
                            tuple.put(name, null);
                        }
                    }
                });
                tupleList.add(tuple);
            });

            String parentId = generatorDataPo.getParentId();
            TemplateFileContextData parent = templateFileContextDataCache.get(parentId);
            templateFileContextData.setParent(parent);
            if(parent == null){
                templateFileContextDataTree.add(templateFileContextData);
            }
            else{
                parent.getChildren().add(templateFileContextData);
            }
        });

        String generateId = UUID.randomUUID().toString();

        TemplateFileContextGlobal global = new TemplateFileContextGlobal();

        global.setGenerateId(generateId);

        UserPo userPo = userDao.selectById(authUserId);
        User user = new User();
        user.setId(userPo.getId());
        user.setUsername(userPo.getUsername());
        global.setUser(user);

        UserPo developerPo = userDao.selectById(authUserId);
        User developer = new User();
        developer.setId(developerPo.getId());
        developer.setUsername(developerPo.getUsername());
        global.setDeveloper(developer);

        Generator generator = new Generator();
        generator.setId(generatorPo.getId());
        generator.setName(generatorPo.getName());
        global.setGenerator(generator);

        GeneratorInstance generatorInstance = new GeneratorInstance();
        generatorInstance.setId(generatorInstancePo.getId());
        generatorInstance.setName(generatorInstancePo.getName());
        global.setGeneratorInstance(generatorInstance);

        CreationStrategy creationStrategy = new CreationStrategy();
        creationStrategy.setId(creationStrategyPo.getId());
        creationStrategy.setName(creationStrategyPo.getName());
        global.setCreationStrategy(creationStrategy);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        String templateRootPath = templateFileServiceTool.getTemplateRootPath(generatorId);

        String outputRootPath = generatorInstanceServiceTool.getOutputRootPath() + File.separator +
            authUserId + File.separator + generatorInstance.getName() + "(" + generateId + ")";

        CreationStrategyScriptTool tool = new CreationStrategyScriptTool(new File(templateRootPath), new File(outputRootPath), templateFileList);
        engine.put("$tool", tool);
        engine.put("$global", global);
        engine.put("$dataTree", templateFileContextDataTree);
        try {
            engine.eval(creationStrategyPo.getScript());
            if(isTest){
                List<GeneratorInstanceMakeResultFile> messageList = tool.makeTest();
                generatorInstanceMakeResult.setResultFileTree(messageList);
            }
            else{
                tool.make();
                generatorInstanceMakeResult.setUrl(authUserId + "/" + generatorInstance.getName() + "(" + generateId + ").zip");
                generatorInstanceMakeResult.setFileName(generatorInstance.getName() + "(" + generateId + ").zip");
            }
        }
        catch (Throwable e){
            List<String> messageList = new ArrayList<>();
            LinkedList<Throwable> exceptionStack = new LinkedList<>();
            exceptionStack.push(e);
            while (!exceptionStack.isEmpty()) {
                Throwable exception = exceptionStack.pop();
                messageList.add(exception.toString());
                if(exception.getCause() != null){
                    exceptionStack.push(exception.getCause());
                }
            }
            generatorInstanceMakeResult.setErrorMessageList(messageList);
            return generatorInstanceMakeResult;
        }

        return generatorInstanceMakeResult;
    }
    
    /**
     * 生成器实例生成
     */
    @Transactional
    public GeneratorInstanceMakeResult make(GeneratorInstanceMakeParameter parameter) {
        generatorInstanceServiceTool.makeValidate(parameter);
        return this.make(parameter.getAuth(), parameter.getId(), parameter.getCreationStrategyId(), parameter.getGeneratorDataIdList(), false);
    }

    /**
     * 生成器实例生成测试
     */
    @Transactional
    public GeneratorInstanceMakeResult makeTest(GeneratorInstanceMakeTestParameter parameter) {
        generatorInstanceServiceTool.makeTestValidate(parameter);
        return this.make(parameter.getAuth(), parameter.getId(), parameter.getCreationStrategyId(), parameter.getGeneratorDataIdList(), true);
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

        String generatorReleaseVersion = generatorPo.getReleaseVersion();
        if(!generatorInstancePo.getReleaseVersion().equals(generatorReleaseVersion)){
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
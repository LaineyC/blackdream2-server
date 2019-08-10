package pers.laineyc.blackdream.generator.tool;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pers.laineyc.blackdream.configuration.constant.SystemConstant;
import pers.laineyc.blackdream.framework.exception.BusinessException;
import pers.laineyc.blackdream.framework.model.Auth;
import pers.laineyc.blackdream.generator.constant.DataModelAttributeDataTypeEnum;
import pers.laineyc.blackdream.generator.service.domain.DataModelAttribute;
import pers.laineyc.blackdream.generator.service.domain.DataModelAttributeDataValidator;
import pers.laineyc.blackdream.generator.service.domain.DataModelAttributeEnumItem;
import pers.laineyc.blackdream.generator.service.domain.GeneratorDataAttributeControl;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataCreateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataDeleteParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataUpdateParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataGetParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataQueryParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSearchParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataTreeParameter;
import pers.laineyc.blackdream.generator.service.parameter.GeneratorDataSortParameter;
import pers.laineyc.blackdream.generator.dao.po.GeneratorDataPo;
import pers.laineyc.blackdream.generator.dao.GeneratorDataDao;
import pers.laineyc.blackdream.usercenter.dao.UserDao;
import pers.laineyc.blackdream.generator.dao.GeneratorDao;
import pers.laineyc.blackdream.generator.dao.GeneratorInstanceDao;
import pers.laineyc.blackdream.generator.dao.po.DataModelPo;
import pers.laineyc.blackdream.generator.dao.DataModelDao;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 生成器数据ServiceTool
 * @author LaineyC
 */
@Component
public class GeneratorDataServiceTool{

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
    private GeneratorInstanceServiceTool generatorInstanceServiceTool;

    public GeneratorDataServiceTool() {

    }

    public String getBodyPath(String generatorInstanceId, String id){
        return generatorInstanceServiceTool.getGeneratorInstancePath(generatorInstanceId) + File.separator + SystemConstant.GENERATOR_INSTANCE_CONFIG_PATH_NAME + File.separator + id + ".data";
    }

    private void attributeValidate(Map<String, GeneratorDataAttributeControl> tuple, Map<String, DataModelAttribute> attributeCache, Integer index){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        tuple.forEach((key, control) -> {
            Integer dataType = control.getDataType();
            Object value = control.getValue();
            DataModelAttribute attribute = attributeCache.get(key);
            if(attribute != null){
                String indexMessage = index == null ? "" : ("第" + (index + 1) + "行");
                String nameMessage = indexMessage + "【" + attribute.getComment() + "】";

                if(!DataModelAttributeDataTypeEnum.hasCode(dataType)){
                    throw new BusinessException(nameMessage + "数据类型不存在");
                }

                Map<Integer, DataModelAttributeDataValidator> dataValidatorMap = attribute.getDataValidatorMap();
                DataModelAttributeDataValidator dataValidator = dataValidatorMap.get(dataType);
                if(dataValidator != null){
                    if(DataModelAttributeDataTypeEnum.NONE.getCode() == dataType){
                        //
                    }
                    else if(DataModelAttributeDataTypeEnum.BOOLEAN.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof Boolean)){
                                throw new BusinessException(nameMessage + "必须布尔");
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.INTEGER.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof Integer)){
                                // 前端传空字符串忽略
                                if ("".equals(value)) {
                                    control.setValue(null);
                                    Boolean isRequired = dataValidator.getIsRequired();
                                    if(Boolean.TRUE.equals(isRequired)){
                                        throw new BusinessException(nameMessage + "必输项");
                                    }
                                    else {
                                        return;
                                    }
                                }
                                throw new BusinessException(nameMessage + "必须整型");
                            }
                            Integer integerValue = (Integer)value;
                            Integer minValue  = (Integer)dataValidator.getMinValue();
                            if(minValue != null && integerValue < minValue){
                                throw new BusinessException(nameMessage + "最小" + minValue);
                            }

                            Integer maxValue  = (Integer)dataValidator.getMaxValue();
                            if(maxValue != null && integerValue > maxValue){
                                throw new BusinessException(nameMessage + "最大" + maxValue);
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.DECIMAL.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof Number)){
                                // 前端传空字符串忽略
                                if ("".equals(value)) {
                                    control.setValue(null);
                                    Boolean isRequired = dataValidator.getIsRequired();
                                    if(Boolean.TRUE.equals(isRequired)){
                                        throw new BusinessException(nameMessage + "必输项");
                                    }
                                    else {
                                        return;
                                    }
                                }
                                throw new BusinessException(nameMessage + "必须数字");
                            }
                            Number numberValue = (Number)value;
                            Number minValue  = (Number)dataValidator.getMinValue();
                            if(minValue != null && numberValue.doubleValue() < minValue.doubleValue()){
                                throw new BusinessException(nameMessage + "最小" + minValue);
                            }

                            Number maxValue  = (Number)dataValidator.getMaxValue();
                            if(maxValue != null && numberValue.doubleValue() > maxValue.doubleValue()){
                                throw new BusinessException(nameMessage + "最大" + maxValue);
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.STRING.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof String)){
                                throw new BusinessException(nameMessage + "必须字符");
                            }
                            String stringValue = (String)value;
                            Integer length  = dataValidator.getLength();
                            if(length != null && stringValue.length() != length){
                                throw new BusinessException(nameMessage + "长度" + length);
                            }

                            Integer minLength  = dataValidator.getMinLength();
                            if(minLength != null && stringValue.length() < minLength){
                                throw new BusinessException(nameMessage + "最短" + minLength);
                            }

                            Integer maxLength  = dataValidator.getMaxLength();
                            if(maxLength != null && stringValue.length() > maxLength){
                                throw new BusinessException(nameMessage + "最长" + maxLength);
                            }

                            String regex = dataValidator.getRegex();
                            if(StringUtils.hasText(regex) && !Pattern.matches(regex, stringValue)){
                                String message = dataValidator.getRegexMessage() == null ? ("格式不匹配【" + regex + "】") : dataValidator.getRegexMessage();
                                throw new BusinessException(nameMessage + "" + message);
                            }

                            Boolean isEnum = dataValidator.getIsEnum();
                            if(Boolean.TRUE.equals(isEnum)){
                                List<DataModelAttributeEnumItem> enumList = dataValidator.getEnumList();
                                Optional<DataModelAttributeEnumItem> enumItem = enumList.stream().filter(item -> value.equals(item.getValue())).findAny();
                                if(!enumItem.isPresent()){
                                    throw new BusinessException(nameMessage + "值超过范围");
                                }
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.DATE.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof String)){
                                throw new BusinessException(nameMessage + "必须日期格式");
                            }
                            String stringValue = (String)value;
                            try {
                                dateFormat.parse(stringValue);
                            }
                            catch (Exception e){
                                throw new BusinessException(nameMessage + "必须日期格式");
                            }

                            String minValue  = (String)dataValidator.getMinValue();
                            if(minValue != null && stringValue.compareTo(minValue) < 0){
                                throw new BusinessException(nameMessage + "最小" + minValue);
                            }

                            String maxValue  = (String)dataValidator.getMaxValue();
                            if(maxValue != null && stringValue.compareTo(maxValue) > 0){
                                throw new BusinessException(nameMessage + "最大" + maxValue);
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.TIME.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof String)){
                                throw new BusinessException(nameMessage + "必须时间");
                            }
                            String stringValue = (String)value;
                            try {
                                timeFormat.parse(stringValue);
                            }
                            catch (Exception e){
                                throw new BusinessException(nameMessage + "必须时间格式");
                            }

                            String minValue  = (String)dataValidator.getMinValue();
                            if(minValue != null && stringValue.compareTo(minValue) < 0){
                                throw new BusinessException(nameMessage + "最小" + minValue);
                            }

                            String maxValue  = (String)dataValidator.getMaxValue();
                            if(maxValue != null && stringValue.compareTo(maxValue) > 0){
                                throw new BusinessException(nameMessage + "最大" + maxValue);
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.DATETIME.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof String)){
                                throw new BusinessException(nameMessage + "必须日期时间");
                            }
                            String stringValue = (String)value;
                            try {
                                dateTimeFormat.parse(stringValue);
                            }
                            catch (Exception e){
                                throw new BusinessException(nameMessage + "必须日期时间格式");
                            }

                            String minValue  = (String)dataValidator.getMinValue();
                            if(minValue != null && stringValue.compareTo(minValue) < 0){
                                throw new BusinessException(nameMessage + "最小" + minValue);
                            }

                            String maxValue  = (String)dataValidator.getMaxValue();
                            if(maxValue != null && stringValue.compareTo(maxValue) > 0){
                                throw new BusinessException(nameMessage + "最大" + maxValue);
                            }
                        }
                    }
                    else if(DataModelAttributeDataTypeEnum.MODEL_REF.getCode() == dataType){
                        if(value == null){
                            Boolean isRequired = dataValidator.getIsRequired();
                            if(Boolean.TRUE.equals(isRequired)){
                                throw new BusinessException(nameMessage + "必输项");
                            }
                        }
                        else{
                            if(!(value instanceof String)){
                                throw new BusinessException(nameMessage + "必须模型");
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * 生成器数据创建Validate
     */
    public void createValidate(GeneratorDataCreateParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null){
            throw new BusinessException("缺少所属生成器实例");
        }

        String dataModelId = parameter.getDataModelId();
        if(dataModelId == null){
            throw new BusinessException("缺少所属生成器数据模型");
        }
        DataModelPo dataModelPo = dataModelDao.selectById(dataModelId);
        if(dataModelPo == null || dataModelPo.getIsDeleted()){
            throw new BusinessException("所属生成器数据模型不存在");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        String parentId = parameter.getParentId();
        if(parentId != null){
            GeneratorDataPo parentPo = generatorDataDao.selectById(parentId);
            if(parentPo == null){
                throw new BusinessException("父节点不存在");
            }
        }

        Map<String, GeneratorDataAttributeControl> properties = parameter.getProperties();
        if(!CollectionUtils.isEmpty(properties)){
            List<DataModelAttribute> propertyList = dataModelPo.getPropertyList();
            Map<String, DataModelAttribute> propertyCache = propertyList.stream().collect(Collectors.toMap(DataModelAttribute::getName, property -> property));
            attributeValidate(properties, propertyCache, null);
        }

        List<Map<String, GeneratorDataAttributeControl>> tupleList = parameter.getTupleList();
        if(!CollectionUtils.isEmpty(tupleList)){
            List<DataModelAttribute> fieldList = dataModelPo.getFieldList();
            Map<String, DataModelAttribute> fieldCache = fieldList.stream().collect(Collectors.toMap(DataModelAttribute::getName, field -> field));
            for(int i = 0 ; i < tupleList.size() ; i++){
                Map<String, GeneratorDataAttributeControl> tuple = tupleList.get(i);
                attributeValidate(tuple, fieldCache, i);
            }
        }
    }

    /**
     * 生成器数据删除Validate
     */
    public void deleteValidate(GeneratorDataDeleteParameter parameter) {
        String id = parameter.getId();
        List<String> idList = parameter.getIdList();
        if(id == null && idList.isEmpty()){
            throw new BusinessException("缺少主键");
        }
    }
    
    /**
     * 生成器数据修改Validate
     */
    public void updateValidate(GeneratorDataUpdateParameter parameter) {
        Auth auth = parameter.getAuth();
        String authUserId = auth.getUserId();

        String id = parameter.getId();
        if(id == null){
            throw new BusinessException("缺少主键");
        }

        GeneratorDataPo generatorDataPo = generatorDataDao.selectById(id);
        if(generatorDataPo == null || generatorDataPo.getIsDeleted() || !generatorDataPo.getUserId().equals(authUserId)){
            throw new BusinessException("生成器数据不存在");
        }

        String name = parameter.getName();
        if(!StringUtils.hasText(name)){
            throw new BusinessException("缺少名称");
        }
        if(name.length() > 255){
            throw new BusinessException("名称长度不能大于255");
        }

        Boolean isExpanded = parameter.getIsExpanded();
        if(isExpanded == null){
            parameter.setIsExpanded(false);
        }

        String parentId = parameter.getParentId();
        if(parentId != null){
            GeneratorDataPo parentPo = generatorDataDao.selectById(parentId);
            if(parentPo == null || parentPo.getIsDeleted()){
                throw new BusinessException("父节点不存在");
            }
        }

        String dataModelId = generatorDataPo.getDataModelId();
        DataModelPo dataModelPo = dataModelDao.selectById(dataModelId);

        Map<String, GeneratorDataAttributeControl> properties = parameter.getProperties();
        if(!CollectionUtils.isEmpty(properties)){
            List<DataModelAttribute> propertyList = dataModelPo.getPropertyList();
            Map<String, DataModelAttribute> propertyCache = propertyList.stream().collect(Collectors.toMap(DataModelAttribute::getName, property -> property));
            attributeValidate(properties, propertyCache, null);
        }

        List<Map<String, GeneratorDataAttributeControl>> tupleList = parameter.getTupleList();
        if(!CollectionUtils.isEmpty(tupleList)){
            List<DataModelAttribute> fieldList = dataModelPo.getFieldList();
            Map<String, DataModelAttribute> fieldCache = fieldList.stream().collect(Collectors.toMap(DataModelAttribute::getName, field -> field));
            for(int i = 0 ; i < tupleList.size() ; i++){
                Map<String, GeneratorDataAttributeControl> tuple = tupleList.get(i);
                attributeValidate(tuple, fieldCache, i);
            }
        }
    }
    
    /**
     * 生成器数据单个查询Validate
     */
    public void getValidate(GeneratorDataGetParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }
    }

    /**
     * 生成器数据多个查询Validate
     */
    public void queryValidate(GeneratorDataQueryParameter parameter) {

    }

    /**
     * 生成器数据分页查询Validate
     */
    public void searchValidate(GeneratorDataSearchParameter parameter) {
        Integer page = parameter.getPage();
        if(page == null || page < 1){
            throw new BusinessException("页数不合法");
        }

        Integer pageSize = parameter.getPageSize();
        if(pageSize == null || pageSize < 1 || pageSize > 100){
            throw new BusinessException("每页数量不合法");
        }
    }

    /**
     * 生成器数据树形查询Validate
     */
    public void treeValidate(GeneratorDataTreeParameter parameter) {
        String generatorInstanceId = parameter.getGeneratorInstanceId();
        if(generatorInstanceId == null) {
            throw new BusinessException("缺少所属生成器实例");
        }
    }
    
    /**
     * 生成器数据排序Validate
     */
    public void sortValidate(GeneratorDataSortParameter parameter) {
        String id = parameter.getId();
        if(id == null) {
            throw new BusinessException("缺少主键");
        }

        Integer fromIndex = parameter.getFromIndex();
        if(fromIndex == null) {
            throw new BusinessException("缺少移动前的位置");
        }

        Integer toIndex = parameter.getToIndex();
        if(toIndex == null) {
            throw new BusinessException("缺少移动后的位置");
        }
    }
    
}
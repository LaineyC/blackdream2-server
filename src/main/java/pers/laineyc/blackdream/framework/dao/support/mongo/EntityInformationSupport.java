package pers.laineyc.blackdream.framework.dao.support.mongo;

import org.springframework.data.annotation.Id;
import pers.laineyc.blackdream.framework.dao.po.Po;
import pers.laineyc.blackdream.framework.util.ReflectionUtil;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * EntityInformation
 *
 * @author LaineyC
 */
public class EntityInformationSupport {

    public static final Map<Class<?>, EntityInformation> entityInformationCache = new HashMap<>();

    public static <E extends Po, K extends Comparable<? super K>> EntityInformation<E, K> getEntityInformation(Class<E> entityClass){
        EntityInformation<E, K> entityInformation = entityInformationCache.get(entityClass);
        if(entityInformation == null){
            entityInformation = createEntityInformation(entityClass);
            entityInformationCache.put(entityClass, entityInformation);
        }
        return entityInformation;
    }

    private static <E extends Po, K extends Comparable<? super K>> EntityInformation<E, K> createEntityInformation(Class<E> entityClass){
        PropertyInformation<K> idPropertyInformation = null;
        Map<String, PropertyInformation> propertyInformationCache = new LinkedHashMap<>();

        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(entityClass);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Method getMethod = pd.getReadMethod();
                Method setMethod = pd.getWriteMethod();
                String fieldName = pd.getName();
                if (getMethod == null || setMethod == null) {
                    continue;
                }
                Field field = ReflectionUtil.getField(entityClass, fieldName);
                if(field == null){
                    continue;
                }
                field.setAccessible(true);

                String propertyName = fieldName;
                String propertyAlias = fieldName;
                Class<K> propertyType = (Class<K>)field.getType();
                Field propertyField = field;

                org.springframework.data.mongodb.core.mapping.Field mongodbField = field.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);
                if(mongodbField != null){
                    propertyAlias = mongodbField.value();
                }

                PropertyInformation propertyInformation = new PropertyInformation<>(propertyName, propertyAlias, propertyType, propertyField);
                propertyInformationCache.put(propertyName, propertyInformation);

                Id id = field.getAnnotation(Id.class);
                if(id != null){
                    idPropertyInformation = propertyInformation;
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new EntityInformation<>(idPropertyInformation, propertyInformationCache);
    }

}

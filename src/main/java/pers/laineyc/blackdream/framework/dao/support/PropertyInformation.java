package pers.laineyc.blackdream.framework.dao.support;

import java.lang.reflect.Field;

/**
 * PropertyInformation
 *
 * @author LaineyC
 */
public class PropertyInformation<K extends Comparable<? super K>> {

    private String propertyName;

    private String propertyAlias;

    private Class<K> propertyType;

    private Field propertyField;

    private Boolean isPrimaryKey;

    private Boolean isLazyLoad;

    public PropertyInformation(String propertyName, Class<K> propertyType, Field propertyField) {
        this(propertyName, propertyName, propertyType, propertyField);
    }

    public PropertyInformation(String propertyName, String propertyAlias, Class<K> propertyType, Field propertyField) {
      this(propertyName, propertyAlias, propertyType, propertyField, false, false);
    }

    public PropertyInformation(String propertyName, String propertyAlias, Class<K> propertyType, Field propertyField, Boolean isPrimaryKey, Boolean isLazyLoad) {
        this.propertyName = propertyName;
        this.propertyAlias = propertyAlias;
        this.propertyType = propertyType;
        this.propertyField = propertyField;
        this.isPrimaryKey = isPrimaryKey;
        this.isLazyLoad = isLazyLoad;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Class<K> getPropertyType() {
        return propertyType;
    }

    public Field getPropertyField() {
        return propertyField;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public Boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }

    public Boolean getIsLazyLoad() {
        return isLazyLoad;
    }
}

package pers.laineyc.blackdream.framework.dao.support.mongo;

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

    public PropertyInformation(String propertyName, Class<K> propertyType, Field propertyField) {
        this.propertyName = propertyName;
        this.propertyAlias = propertyName;
        this.propertyType = propertyType;
        this.propertyField = propertyField;
    }

    public PropertyInformation(String propertyName, String propertyAlias, Class<K> propertyType, Field propertyField) {
        this.propertyName = propertyName;
        this.propertyAlias = propertyAlias;
        this.propertyType = propertyType;
        this.propertyField = propertyField;
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

}

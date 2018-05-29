package pers.laineyc.blackdream.framework.dao.support;

import pers.laineyc.blackdream.framework.dao.po.Po;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * EntityInformation
 *
 * @author LaineyC
 */
public class EntityInformation<E extends Po, K extends Comparable<? super K>> {

    private PropertyInformation<K> idPropertyInformation;

    private List<PropertyInformation<K>> propertyInformationList = new ArrayList<>();

    public EntityInformation(List<PropertyInformation<K>> propertyInformationList) {
        this.propertyInformationList = propertyInformationList;
        propertyInformationList.forEach(propertyInformation -> {
            if(propertyInformation.getIsPrimaryKey()){
                idPropertyInformation = propertyInformation;
            }
        });
    }

    public PropertyInformation getIdPropertyInformation() {
        return idPropertyInformation;
    }

    public List<PropertyInformation<K>> getPropertyInformationList() {
        return propertyInformationList;
    }
}

package pers.laineyc.blackdream.framework.dao.support.mongo;

import pers.laineyc.blackdream.framework.dao.po.Po;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * EntityInformation
 *
 * @author LaineyC
 */
public class EntityInformation<E extends Po, K extends Comparable<? super K>> {

    private PropertyInformation<K> idPropertyInformation;

    private Map<String, PropertyInformation> propertyInformationCache = new LinkedHashMap<>();

    public EntityInformation(PropertyInformation<K> idPropertyInformation) {
        this.idPropertyInformation = idPropertyInformation;
    }

    public EntityInformation(PropertyInformation<K> idPropertyInformation, Map<String, PropertyInformation> propertyInformationCache) {
        this.idPropertyInformation = idPropertyInformation;
        this.propertyInformationCache = propertyInformationCache;
    }

    public PropertyInformation getIdPropertyInformation() {
        return idPropertyInformation;
    }

    public Map<String, PropertyInformation> getPropertyInformationCache() {
        return propertyInformationCache;
    }

}

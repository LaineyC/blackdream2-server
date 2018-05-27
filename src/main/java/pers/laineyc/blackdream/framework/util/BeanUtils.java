package pers.laineyc.blackdream.framework.util;

import org.springframework.cglib.beans.BeanCopier;

/**
 * @author LaineyC
 */
public final class BeanUtils {

    public static void copyProperties(Object source, Object target) {
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target, null);
    }

}
package pers.laineyc.blackdream.framework.dao.support;

import java.lang.annotation.*;

/**
 * @author LaineyC
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LazyLoad {

}
package pers.laineyc.blackdream.configuration.config;

import pers.laineyc.blackdream.configuration.constant.AccessLevelEnum;

import java.lang.annotation.*;

/**
 * @author LaineyC
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Security {

    AccessLevelEnum accessLevel() default AccessLevelEnum.PROTECTED;

}
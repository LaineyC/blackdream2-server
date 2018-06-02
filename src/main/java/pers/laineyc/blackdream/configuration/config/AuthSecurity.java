package pers.laineyc.blackdream.configuration.config;

import java.lang.annotation.*;

/**
 * @author LaineyC
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthSecurity {

    boolean notNull() default false;

    boolean developer() default false;

}
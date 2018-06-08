package pers.laineyc.blackdream.configuration.config;

import java.lang.annotation.*;

/**
 * @author LaineyC
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthSecurity {

    boolean notNull() default true;

    boolean developer() default false;

}
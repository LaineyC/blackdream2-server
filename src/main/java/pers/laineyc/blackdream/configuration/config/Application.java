package pers.laineyc.blackdream.configuration.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.lang.annotation.*;

/**
 * @author LaineyC
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

@ComponentScan
@EnableAsync
@EnableAspectJAutoProxy
//@EnableTransactionManagement
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 4 * 60 * 60)

@SpringBootApplication
public @interface Application {

}
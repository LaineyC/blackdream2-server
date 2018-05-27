package pers.laineyc.blackdream.configuration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import pers.laineyc.blackdream.configuration.component.RunLogInterceptor;
import pers.laineyc.blackdream.configuration.component.SecurityInterceptor;
import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.impl.RunLogMongoServiceImpl;
import pers.laineyc.blackdream.framework.util.JsonObjectMapper;
import javax.servlet.MultipartConfigElement;

/**
 * @author LaineyC
 */

@Configuration
public class Config {

    @Bean
    public ObjectMapper objectMapper(){
        return new JsonObjectMapper();
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1024KB");
        factory.setMaxRequestSize("1024KB");
        return factory.createMultipartConfig();
    }

    @Autowired
    public MongoTemplate setMongoTemplate(MongoTemplate mongoTemplate){
        ((MappingMongoConverter)mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));
        return mongoTemplate;
    }

    @Bean
    public RunLogService runLogMongoServiceImpl() {
        return new RunLogMongoServiceImpl();
    }

    @Bean
    public RunLogInterceptor runLogInterceptor() {
        return new RunLogInterceptor();
    }

    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

}
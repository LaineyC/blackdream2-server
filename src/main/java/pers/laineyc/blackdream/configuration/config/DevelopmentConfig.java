package pers.laineyc.blackdream.configuration.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import pers.laineyc.blackdream.foundation.service.RunLogService;
import pers.laineyc.blackdream.foundation.service.impl.RunLogConsoleServiceImpl;
import pers.laineyc.blackdream.foundation.service.impl.RunLogMongoServiceImpl;
import pers.laineyc.blackdream.foundation.service.impl.RunLogMultipleServiceImpl;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author LaineyC
 */
@EnableSwagger2
@Configuration
@Profile({ "dev" })
public class DevelopmentConfig {

    @Bean
    public RunLogService runLogConsoleServiceImpl() {
        return new RunLogConsoleServiceImpl();
    }

    @Bean
    public RunLogService runLogMongoServiceImpl() {
        return new RunLogMongoServiceImpl();
    }

    @Bean
    @Primary
    public RunLogService runLogMultipleServiceImpl(RunLogService runLogConsoleServiceImpl, RunLogService runLogMongoServiceImpl) {
        return new RunLogMultipleServiceImpl(runLogConsoleServiceImpl, runLogMongoServiceImpl);
    }

    @Bean
    public Docket webApiDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("BlackDream接口文档")
                .version("1.0.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("BlackDream接口文档")
                .alternateTypeRules()
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/web.*"))
                .build()
                .apiInfo(apiInfo);
    }

}
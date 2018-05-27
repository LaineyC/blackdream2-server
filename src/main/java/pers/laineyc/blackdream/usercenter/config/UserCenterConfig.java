package pers.laineyc.blackdream.usercenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.laineyc.blackdream.usercenter.component.TokenSignInInterceptor;

/**
 * @author LaineyC
 */

@Configuration
public class UserCenterConfig {

    @Bean
    public TokenSignInInterceptor tokenSignInInterceptor() {
        return new TokenSignInInterceptor();
    }

}
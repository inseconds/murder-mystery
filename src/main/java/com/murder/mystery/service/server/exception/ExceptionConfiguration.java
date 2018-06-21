package com.murder.mystery.service.server.exception;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by james on 2018/5/14.
 */
@Configuration
public class ExceptionConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(RestExceptionResolver.class)
    public RestExceptionResolver getRestExceptionResolver() {
        return new RestExceptionResolver();
    }

}

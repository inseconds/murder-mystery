package com.murder.mystery.service.server.logger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(RequestVoAdvice.class)
    public RequestVoAdvice getRequestVoAdvice() {
        return new RequestVoAdvice();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(ResponseVoAdvice.class)
    public ResponseVoAdvice getResponseVoAdvice() {
        return new ResponseVoAdvice();
    }
}

package com.gaohj.springdemo.config;

import com.gaohj.springdemo.service.MsgService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(MsgService.class)
@EnableConfigurationProperties(MsgProperties.class)
public class MsgAutoConfiguration {

    @Resource
    private MsgProperties msgProperties;

    @Bean
    @ConditionalOnMissingBean(MsgService.class)
    @ConditionalOnProperty(prefix = "msg", value = "enabled", havingValue = "true")
    public MsgService msgService(){
        MsgService msgService = new MsgService(msgProperties.getUrl(), msgProperties.getKeyId(), msgProperties.getSecret());
        return msgService;
    }
}

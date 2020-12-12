package com.gaohj.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean("writeDb")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource write(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("readDb1")
    @ConfigurationProperties(prefix = "spring.datasource.read1")
    public DataSource read1(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("readDb2")
    @ConfigurationProperties(prefix = "spring.datasource.read2")
    public DataSource read2(){
        return DruidDataSourceBuilder.create().build();
    }
}

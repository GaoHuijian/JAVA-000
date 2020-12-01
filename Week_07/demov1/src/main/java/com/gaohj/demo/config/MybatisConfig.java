package com.gaohj.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MybatisConfig {

    @Bean("writeDb")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.write")
    public DataSource write(){
        return DataSourceBuilder.create().build();
    }

    @Bean("readDb1")
    @ConfigurationProperties(prefix = "spring.datasource.read1")
    public DataSource read1(){
        return DataSourceBuilder.create().build();
    }

    @Bean("readDb2")
    @ConfigurationProperties(prefix = "spring.datasource.read2")
    public DataSource read2(){
        return DataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put("write", write());
        dataSourceMap.put("read1", read1());
        dataSourceMap.put("read2", read2());
        // 将 master 数据源作为默认指定的数据源
        dynamicDataSource.setDefaultDataSource(write());
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}

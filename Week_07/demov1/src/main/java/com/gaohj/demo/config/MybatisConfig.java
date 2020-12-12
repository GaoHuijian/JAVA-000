package com.gaohj.demo.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@AutoConfigureAfter({DataSourceConfig.class})
@MapperScan(basePackages= "com.gaohj.demo.dao", sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisConfig extends MybatisAutoConfiguration {


    @Resource(name="writeDb")
    private DataSource writeDb;

    @Resource(name="readDb1")
    private DataSource readDb1;

    @Resource(name="readDb2")
    private DataSource readDb2;

    public MybatisConfig(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    public AbstractRoutingDataSource roundRobinDataSourceProxy() {
        DynamicDataSource proxy = new DynamicDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataBaseContextHoldle.DataBaseType.WRITE, writeDb);
        targetDataSource.put(DataBaseContextHoldle.DataBaseType.READ1, readDb1);
         targetDataSource.put(DataBaseContextHoldle.DataBaseType.READ2, readDb2);
        //默认数据源
        proxy.setDefaultTargetDataSource(writeDb);
        //装入两个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        proxy.afterPropertiesSet();
        return proxy;
    }

    @Bean(name="sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }
}

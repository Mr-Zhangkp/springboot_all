package com.zhang.autoConfig;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.C3P0PooledConnection;
import com.mchange.v2.c3p0.impl.C3P0PooledConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

/**
 * @author xiaomi
 * @date 2022/5/30
 */
@SpringBootConfiguration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceAutoConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    /**
     * 装配Druid连接池
     * @return druidDataSource
     */
    @Bean
    //这里是说,当yml中配置了spring.jdbc.datasource.type并且值为druid时候,才会装配这个bean

    @ConditionalOnProperty(value = "spring.jdbc.datasource.type", havingValue = "druid")
    public DataSource createDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        System.out.println("druid");
        return druidDataSource;
    }

    /**
     * 装配C3P0连接池
     * @return C3P0DataSource
     * @throws PropertyVetoException
     */
    @Bean
    //这里是说,当yml中配置了spring.jdbc.datasource.type并且值为c3p0时候,才会装配这个bean

    @ConditionalOnProperty(value = "spring.jdbc.datasource.type", havingValue = "c3p0")
    public DataSource creatC3P0DataSource() throws PropertyVetoException {
        ComboPooledDataSource C3P0DataSource = new ComboPooledDataSource();
        C3P0DataSource.setUser(dataSourceProperties.getUsername());
        C3P0DataSource.setPassword(dataSourceProperties.getPassword());
        C3P0DataSource.setJdbcUrl(dataSourceProperties.getUrl());
        C3P0DataSource.setDriverClass(dataSourceProperties.getDriverClassName());

        System.out.println("c3p0");

        return C3P0DataSource;
    }
}

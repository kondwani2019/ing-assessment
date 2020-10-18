package com.ing.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@EntityScan(basePackages = "com.ing.model.domain")
@Configuration
public class DBConfig {

    @Value("${datasource.db.username}")
    private String username;

    @Value("${datasource.db.password}")
    private String password;

    @Value("${datasource.db.minPool}")
    private Integer minPoolSize;

    @Value("${datasource.db.maxPool}")
    private Integer maxPoolSize;
    
    @Value("${datasource.db.jdbcUrl}")
    private String jdbcUrl;
    
    @Value("${datasource.db.driverClassName}")
    private String driverClassName;

    @Bean(name = "DataSource.domain.IngUserManagementDS")
    public DataSource dataSource() {
    	DataSource dataSource = DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(jdbcUrl)
                .driverClassName(driverClassName)
                .build();
        
		return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

package com.adweak.reference.hibernate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author : xuzhaole
 * @date : 2021/4/26
 */

@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource imgdbDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "JdbcTemplate")
    public JdbcTemplate imgdbJdbcTemplate(@Qualifier("DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

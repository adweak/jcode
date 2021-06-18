package com.adweak.reference.hibernate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : xuzhaole
 * @date : 2021/6/2
 */

@Configuration
public class HibernateConfig {

    @Bean(name = "hibernateDemoSessionFactory")
    @Primary
    public LocalSessionFactoryBean localSessionFactoryBean(@Qualifier("DataSource") DataSource dataSource) {
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com.adweak.reference.*.domain");
        bean.setHibernateProperties(hibernateProperties());
        return bean;
    }

    @Value("${hibernate.dialect:org.hibernate.dialect.MySQL5Dialect}")
    private String dialect;
    @Value("${hibernate.showSql:false}")
    private String showSql;
    @Value("${hibernate.formatSql:true}")
    private String formatSql;

    @Bean(name = "hibernateDemoHibernateProperties")
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect",dialect);
        properties.setProperty("hibernate.show_sql",showSql);
        properties.setProperty("hibernate.format_sql",formatSql);
        return properties;
    }

}

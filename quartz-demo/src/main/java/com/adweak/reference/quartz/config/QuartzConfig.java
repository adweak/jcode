package com.adweak.reference.quartz.config;

import com.zaxxer.hikari.HikariDataSource;
import org.quartz.spi.JobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

import static com.adweak.reference.quartz.constants.CommonConstants.*;

/**
 * @author : xuzhaole
 * @date : 2020/11/30
 */

@Configuration
public class QuartzConfig {
    private Logger logger = LoggerFactory.getLogger(QuartzConfig.class);

    @Value("${quartz.config}")
    private String quartzConfig;

    //quartz 数据库（DataSource）配置
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.quartz")
    public DataSourceProperties quartzDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.quartz.configuration")
    public DataSource quartzDataSource() {
        logger.info("quartzDataSource inited");
        return quartzDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    //quartz属性配置
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new FileSystemResource(quartzConfig));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    //quartz 任务（Job）工厂配置
    @Bean
    public JobFactory scheduleJobFactory(ApplicationContext applicationContext) {
        AutoWiredSpringBeanToJobFactory jobFactory = new AutoWiredSpringBeanToJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    //quartz 调度器（Schedule）配置
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory scheduleJobFactory) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setSchedulerName(SCHEDULER_NAME);// 设置调度器名称，用于集群中区别不同调度器
        factory.setBeanName(BEAN_NAME);// 设置bean名称
        factory.setJobFactory(scheduleJobFactory);// 设置任务（Job）工厂
        factory.setOverwriteExistingJobs(true);// 设置QuartzScheduler 启动时更新己存在的Job
        factory.setAutoStartup(true); // 设置自行启动
        factory.setQuartzProperties(quartzProperties());// 设置quartz属性参数
        factory.setDataSource(quartzDataSource()); //设置quartz使用的数据库
        return factory;
    }

}

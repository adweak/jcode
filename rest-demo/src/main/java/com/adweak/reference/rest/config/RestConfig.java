package com.adweak.reference.rest.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author : xuzhaole
 * @date : 2020/12/24
 */

@Configuration
public class RestConfig {

    //可在启动类中注入，在此处注入是要配置其他属性
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(@Qualifier(value = "simpleFactory") ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean(name = "simpleFactory")
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(5000);//ms
        return factory;
    }

}

package com.adweak.reference.hibernate.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : xuzhaole
 * @date : 2021/1/7
 */

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

    private static final String TITLE = "Hibernate说明文档";
    private static final String DESCRIPTION = "Hibernate接口说明文档";
    private static final String VERSION = "1.0";

    private static final String NAME = "XZL";
    private static final String URL = "http://www.baidu.com/s?ie=UTF-8&wd=桔雨禾";
    private static final String EMAIL = "adweak@icloud.com";

    @Value("${swagger.enabled:false}")
    private boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.adweak.reference.hibernate.controller"))
                .paths(PathSelectors.any())
                .build()
                .enable(enabled)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(NAME, URL, EMAIL))
                .termsOfServiceUrl("http://www.baidu.com/s?ie=UTF-8&wd=桔雨禾")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}

package com.adweak.reference.gateway.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xuzhaole
 * @date : 2021/1/7
 */

@Configuration
@EnableSwagger2
@Primary
@Slf4j
public class SwaggerConfig implements SwaggerResourcesProvider {

    private static final String TITLE = "说明文档";
    private static final String DESCRIPTION = "接口说明文档";
    private static final String VERSION = "1.0";
    // 此处对应Swagger2的版本，禁止修改。
    private static final String DISPLAY_VERSION = "v2/api-docs";

    private static final String NAME = "XZL";
    private static final String URL = "http://www.baidu.com/s?ie=UTF-8&wd=桔雨禾";
    private static final String EMAIL = "adweak@icloud.com";

    @Autowired
    RouteLocator routeLocator;

    @Value("${swagger.enabled:false}")
    private boolean enabled;

    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
        if (enabled) {
            routeLocator.getRoutes().forEach(route -> {
                resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", DISPLAY_VERSION), VERSION));
                log.info("swagger id:{}, path:{}", route.getId(), route.getFullPath().replace("**", DISPLAY_VERSION));
            });
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(version);
        return resource;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.none())
                .paths(PathSelectors.none())
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

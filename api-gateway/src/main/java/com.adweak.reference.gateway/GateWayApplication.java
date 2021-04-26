package com.adweak.reference.gateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author : xuzhaole
 * @date : 2020/12/22
 */

@SpringCloudApplication
@EnableZuulProxy
public class GateWayApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("now start run api-gateway ...");
    }
}

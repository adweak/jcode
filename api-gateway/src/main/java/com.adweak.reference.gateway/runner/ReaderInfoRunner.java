package com.adweak.reference.gateway.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 配置启动时加载
 * @author : xuzhaole
 * @date : 2021/1/12
 */

@Component
@Order(2)
public class ReaderInfoRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("...");
    }
}

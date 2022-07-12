package com.goat.calvin.service.provider;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiefei15
 */
@SpringBootApplication( exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan("com.goat.calvin.service.shared.model.entity")
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
package com.muguang.ebusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author muguang
 * @date 2017-3-7 22:48
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class EbusinessCloudShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudShopApplication.class, args);
    }
}

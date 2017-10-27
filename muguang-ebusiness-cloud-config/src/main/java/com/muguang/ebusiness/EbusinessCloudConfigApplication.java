package com.muguang.ebusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author muguang
 * @date 2017/3/6 15:42.
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class EbusinessCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudConfigApplication.class, args);
    }
}

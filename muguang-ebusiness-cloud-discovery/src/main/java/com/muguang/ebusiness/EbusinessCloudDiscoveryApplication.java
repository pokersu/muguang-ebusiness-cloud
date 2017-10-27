package com.muguang.ebusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务发现 eureka 服务器
 * @author Chen Xiang
 * @date 2017/3/6 13:17.
 */
@SpringBootApplication
@EnableEurekaServer
public class EbusinessCloudDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudDiscoveryApplication.class, args);
    }
}

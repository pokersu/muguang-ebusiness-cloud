package com.muguang.ebusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author muguang
 * @date 2017-3-7 22:46
 */
@EnableZipkinServer
@SpringBootApplication
public class EbusinessCloudZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudZipkinApplication.class, args);
    }
}

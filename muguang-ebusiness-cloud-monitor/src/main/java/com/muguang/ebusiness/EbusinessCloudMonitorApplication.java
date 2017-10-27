package com.muguang.ebusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author muguang
 * @date 2017/3/7 12:32.
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class EbusinessCloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudMonitorApplication.class, args);
    }
}

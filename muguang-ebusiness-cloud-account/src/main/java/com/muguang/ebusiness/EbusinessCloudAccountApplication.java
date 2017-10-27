package com.muguang.ebusiness;

import com.muguang.ebusiness.stream.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author muguang
 * @date 2017/3/6 11:43.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableBinding(Sink.class)
public class EbusinessCloudAccountApplication {

    private static Logger logger = LoggerFactory.getLogger(EbusinessCloudAccountApplication.class);
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(EbusinessCloudAccountApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void sinkMessage(Object message){
        logger.info("received message: "+message);
    }
}

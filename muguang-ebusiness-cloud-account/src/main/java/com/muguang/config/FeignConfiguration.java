package com.muguang.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author muguang
 * @date 2017/3/10 9:48.
 */
@Configuration
public class FeignConfiguration {

    /**
     * 使用Feign 原生契约   详见:https://github.com/OpenFeign/feign
     */
    /*@Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }*/

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

}

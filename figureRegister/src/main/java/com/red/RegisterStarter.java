package com.red;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:42 2022-07-26
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterStarter {

    public static void main(String[] args) {
        SpringApplication.run(RegisterStarter.class, args);
    }
}

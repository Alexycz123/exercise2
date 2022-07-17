package com.ycz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync//开启异步线程支持
public class MypoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypoiApplication.class, args);
    }

}

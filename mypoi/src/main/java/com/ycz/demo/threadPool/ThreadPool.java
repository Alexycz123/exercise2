package com.ycz.demo.threadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-10-18:11
 * @Version: V1.0
 **/
@Configuration
public class ThreadPool {

    @Bean
    public ExecutorService getExecutorService(){
        return Executors.newFixedThreadPool(30);
    }

}

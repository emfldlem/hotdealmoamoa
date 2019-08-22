package com.emfldlem.hotdeal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan("com.emfldlem.*")
public class HotdealApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotdealApplication.class, args);
    }

/*
    @Bean
    public TaskScheduler taskScheduler1() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    public TaskScheduler taskScheduler2() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }*/


}

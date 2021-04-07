package com.example.maka;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRabbit
@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class MakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MakaApplication.class, args);
    }

}

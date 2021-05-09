package com.aqualen.kafka.streams.hogwarts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class HogwartsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HogwartsApplication.class, args);
    }
}

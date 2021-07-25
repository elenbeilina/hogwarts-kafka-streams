package com.aqualen.kafka.streams.hogwarts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
@SpringBootApplication
public class HogwartsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HogwartsApplication.class, args);
    }
}

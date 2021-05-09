package com.aqualen.kafka.streams.hogwarts.kafka;

import com.aqualen.kafka.streams.hogwarts.config.HousesTopicConfig;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final HousesTopicConfig topicConfig;

    @EventListener(ApplicationStartedEvent.class)
    public void produce() {
        var harryPotter = new Faker().harryPotter();
        for (var i = 1; i < 30; i++) {
            kafkaTemplate.send(topicConfig.getName(), harryPotter.house(), harryPotter.character());
        }

        System.exit(0);
    }
}
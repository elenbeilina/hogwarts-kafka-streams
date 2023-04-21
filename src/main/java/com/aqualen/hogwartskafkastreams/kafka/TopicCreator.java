package com.aqualen.hogwartskafkastreams.kafka;

import com.aqualen.hogwartskafkastreams.config.HousesTopicConfig;
import com.aqualen.hogwartskafkastreams.config.TopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Slf4j
@Configuration
public class TopicCreator {
    @Bean
    NewTopic transactionSuccess(HousesTopicConfig topicConfig) {
        return createTopic(topicConfig);
    }

    private NewTopic createTopic(TopicConfig topicConfig) {
        log.info("Creating topic {}...", topicConfig.getName());
        return TopicBuilder.name(topicConfig.getName())
                .partitions(topicConfig.getPartitions())
                .replicas(topicConfig.getReplicationFactor())
                .compact()
                .build();
    }
}

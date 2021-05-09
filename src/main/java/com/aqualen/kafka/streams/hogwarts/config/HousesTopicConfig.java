package com.aqualen.kafka.streams.hogwarts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("topics.houses")
public class HousesTopicConfig extends TopicConfig {
}

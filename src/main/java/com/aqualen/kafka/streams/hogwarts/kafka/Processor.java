package com.aqualen.kafka.streams.hogwarts.kafka;

import com.aqualen.kafka.streams.hogwarts.config.HousesTopicConfig;
import com.aqualen.kafka.streams.hogwarts.config.SpellCasterTopicConfig;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Processor {

    private final SpellCasterTopicConfig casterTopicConfig;
    private final HousesTopicConfig topicConfig;

    @Autowired
    public void process(StreamsBuilder builder) {
        Serde<String> serde = Serdes.String();
        var harryPotter = new Faker().harryPotter();
        builder.stream(topicConfig.getName(), Consumed.with(serde, serde))
                .flatMapValues(value -> List.of(value + " casts the " + harryPotter.spell() + " charm"))
                .to(casterTopicConfig.getName(), Produced.with(serde, serde));
    }
}

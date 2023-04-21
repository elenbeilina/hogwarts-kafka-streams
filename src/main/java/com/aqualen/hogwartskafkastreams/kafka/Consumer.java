package com.aqualen.hogwartskafkastreams.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "students_consumer", topics = "#{@spellCasterTopicConfig.getName()}")
    public void consumer(ConsumerRecord<String, String> myRecord) {
        System.out.println("Student " + myRecord.value() + " is from " + myRecord.key());
    }
}

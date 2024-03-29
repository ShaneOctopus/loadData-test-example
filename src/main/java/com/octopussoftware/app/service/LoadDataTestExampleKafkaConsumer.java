package com.octopussoftware.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoadDataTestExampleKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(LoadDataTestExampleKafkaConsumer.class);
    private static final String TOPIC = "topic_loaddatatestexample";

    @KafkaListener(topics = "topic_loaddatatestexample", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}

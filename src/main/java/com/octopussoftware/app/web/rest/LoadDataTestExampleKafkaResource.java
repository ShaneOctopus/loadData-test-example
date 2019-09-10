package com.octopussoftware.app.web.rest;

import com.octopussoftware.app.service.LoadDataTestExampleKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/load-data-test-example-kafka")
public class LoadDataTestExampleKafkaResource {

    private final Logger log = LoggerFactory.getLogger(LoadDataTestExampleKafkaResource.class);

    private LoadDataTestExampleKafkaProducer kafkaProducer;

    public LoadDataTestExampleKafkaResource(LoadDataTestExampleKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}

package com.octopussoftware.app.web.rest;

import com.octopussoftware.app.LoadDataTestExampleApp;
import com.octopussoftware.app.service.LoadDataTestExampleKafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = LoadDataTestExampleApp.class)
public class LoadDataTestExampleKafkaResourceIT {

    @Autowired
    private LoadDataTestExampleKafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        LoadDataTestExampleKafkaResource kafkaResource = new LoadDataTestExampleKafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/load-data-test-example-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}

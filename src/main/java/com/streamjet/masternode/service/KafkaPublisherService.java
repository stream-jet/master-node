package com.streamjet.masternode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.streamjet.masternode.dto.JobDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${spring.kafka.template.default-topic}")
    public String taskTopic;

    public KafkaPublisherService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void publishNewTask(JobDTO jobDTO) throws JsonProcessingException {
        String jobJSON = objectMapper.writeValueAsString(jobDTO);
        kafkaTemplate.send(taskTopic, jobJSON);
    }

}

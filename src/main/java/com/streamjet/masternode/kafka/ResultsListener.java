package com.streamjet.masternode.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.streamjet.masternode.dto.WorkerResponseDTO;
import com.streamjet.masternode.service.JobService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ResultsListener {

    private final ObjectMapper objectMapper;

    private final JobService jobService;

    public ResultsListener(ObjectMapper objectMapper, JobService jobService) {
        this.objectMapper = objectMapper;
        this.jobService = jobService;
    }

    @KafkaListener(topics = "results", containerFactory = "kafkaListenerContainerFactory")
    public void listenWithFilter(String message) throws JsonProcessingException {
        WorkerResponseDTO response = objectMapper.readValue(message, WorkerResponseDTO.class);

        jobService.processResponseFromListener(response);
        //todo: notify here user that job status changed
    }
}

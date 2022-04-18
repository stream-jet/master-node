package com.streamjet.masternode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final JobService jobService;

    public TaskController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/publish")
    public void publishTask(@RequestBody JobDTO jobDTO) throws JsonProcessingException {
        jobService.publishTask(jobDTO);
    }

}

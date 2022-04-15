package com.streamjet.masternode.service;

import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.dto.WorkerResponseDTO;
import com.streamjet.masternode.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WorkerCommunicationService {

    @Autowired
    private JobService jobService;

     public void processWorkerResponse(WorkerResponseDTO workerResponse){
         JobDTO jobDTO = jobService.findJobById(workerResponse.getJobId());
         jobDTO.setJobStatus(workerResponse.getJobStatus());

         jobService.updateJob(jobDTO);
         //todo: notify user with details and job status
     }
}

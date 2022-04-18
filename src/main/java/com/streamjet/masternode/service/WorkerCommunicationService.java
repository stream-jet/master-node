package com.streamjet.masternode.service;

import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.dto.WorkerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerCommunicationService {

    private final JobService jobService;

    public WorkerCommunicationService(JobService jobService) {
        this.jobService = jobService;
    }

    public void processWorkerResponse(WorkerResponseDTO workerResponse) {
        JobDTO jobDTO = jobService.findJobById(workerResponse.getJobId());
        jobDTO.setJobStatus(workerResponse.getJobStatus());

        jobService.updateJob(jobDTO);
        //todo: notify user with details and job status
    }
}

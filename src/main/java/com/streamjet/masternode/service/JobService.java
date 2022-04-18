package com.streamjet.masternode.service;

import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.dto.WorkerResponseDTO;
import com.streamjet.masternode.entity.Job;
import com.streamjet.masternode.mappers.JobMapper;
import com.streamjet.masternode.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobService {

    private final KafkaPublisherService kafkaPublisherService;
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository, KafkaPublisherService kafkaPublisherService) {
        this.jobRepository = jobRepository;
        this.kafkaPublisherService = kafkaPublisherService;
    }

    public void saveJob(JobDTO jobDTO) {
        Job job = JobMapper.INSTANCE.convertToEntity(jobDTO);
        job.setCreatedAt(LocalDateTime.now());
        job.setUpdatedAt(LocalDateTime.now());
        jobRepository.save(job);
    }

    public void updateJob(JobDTO jobDTO) {
        Job job = JobMapper.INSTANCE.convertToEntity(jobDTO);
        job.setUpdatedAt(LocalDateTime.now());
        jobRepository.save(job);
    }

    public JobDTO findJobById(long id){
        Job job = jobRepository.findById(id).orElseThrow(RuntimeException::new);
        return JobMapper.INSTANCE.convertToDTO(job);
    }

    public void processResponseFromListener(WorkerResponseDTO listenerResponse){
        JobDTO jobDTO = findJobById(listenerResponse.getJobId());
        jobDTO.setJobStatus(listenerResponse.getJobStatus());
        jobDTO.setLogs(listenerResponse.getDetails());

        updateJob(jobDTO);
    }

    public void publishTask(JobDTO jobDTO) throws JsonProcessingException {
        kafkaPublisherService.publishNewTask(jobDTO);
        saveJob(jobDTO);
    }
}

package com.streamjet.masternode.service;

import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.entity.Job;
import com.streamjet.masternode.mappers.JobMapper;
import com.streamjet.masternode.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
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
}

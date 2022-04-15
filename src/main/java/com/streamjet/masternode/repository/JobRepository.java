package com.streamjet.masternode.repository;

import com.streamjet.masternode.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@EnableMongoRepositories
public interface JobRepository extends MongoRepository<Job, Long> {

    Optional<Job> findById(long Id);

    Optional<Job> findByUserId(long Id);
}
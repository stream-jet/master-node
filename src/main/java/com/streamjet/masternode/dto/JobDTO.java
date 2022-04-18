package com.streamjet.masternode.dto;

import com.streamjet.masternode.entity.JobDetails;
import com.streamjet.masternode.entity.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class JobDTO {

    private long id;

    private long userId;

    private JobStatus jobStatus;

    private JobDetails jobDetails;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String logs;

}

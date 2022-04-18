package com.streamjet.masternode.dto;

import com.streamjet.masternode.entity.JobStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerResponseDTO {

    private long userId;

    private String jobId;

    private JobStatus jobStatus;

    private String details;
}

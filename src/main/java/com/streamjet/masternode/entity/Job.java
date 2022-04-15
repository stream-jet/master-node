package com.streamjet.masternode.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Document("job")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {

    @Id
    @Indexed(unique = true)
    @NotBlank
    private long Id;

    @Field
    @Indexed
    @NotBlank
    private long userId;

    @Field
    private JobStatus jobStatus;

    @Field
    @NotBlank
    private JobDetails jobDetails;

    @Field
    private LocalDateTime createdAt;

    @Field
    private LocalDateTime updatedAt;

}

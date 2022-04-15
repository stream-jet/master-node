package com.streamjet.masternode.mappers;

import com.streamjet.masternode.dto.JobDTO;
import com.streamjet.masternode.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobDTO convertToDTO(Job job);

    Job convertToEntity(JobDTO jobDTO);
}

package com.healthconnection.application.output.mapper.impl;

import com.healthconnection.application.output.mapper.MapperEntity;
import com.healthconnection.application.output.model.PatientEntity;
import com.healthconnection.domain.PatientDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapperEntity extends MapperEntity<PatientEntity, PatientDomain> {
		
    PatientDomain toDomain(PatientEntity entity);
    
    PatientEntity toEntity(PatientDomain domain);
    

}

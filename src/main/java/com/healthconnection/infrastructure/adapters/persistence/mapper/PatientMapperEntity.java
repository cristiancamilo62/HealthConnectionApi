package com.healthconnection.infrastructure.adapters.persistence.mapper;

import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.infrastructure.entities.PatientEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
@Component
public interface PatientMapperEntity {
		
    PatientDomain toDomain(PatientEntity entity);
    
    PatientEntity toEntity(PatientDomain domain);

    List<PatientDomain> toListDomain(List<PatientEntity> entities);

    Optional<PatientDomain> toOptionalDomain(Optional<PatientEntity> entities);
    

}

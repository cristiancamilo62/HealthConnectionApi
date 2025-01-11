package com.healthconnection.application.mapper;

import com.healthconnection.application.dto.PatientDTO;
import com.healthconnection.domain.model.patient.PatientDomain;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PatientMapperDTO {
   
	PatientDomain toDomain(PatientDTO dto);
	
    PatientDTO toDTO(PatientDomain domain);

    List<PatientDTO> toDTOList(List<PatientDomain> domains);
}

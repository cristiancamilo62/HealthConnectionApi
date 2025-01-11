package com.healthconnection.application.mapper;

import com.healthconnection.application.dto.IdentificationTypeDTO;
import com.healthconnection.domain.model.identificationtype.IdentificationTypeDomain;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface IdentificationTypeMapperDTO {
	
	IdentificationTypeDTO toDTO(IdentificationTypeDomain domain);
	
	IdentificationTypeDomain toDomain(IdentificationTypeDTO dto);

}

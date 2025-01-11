package com.healthconnection.application.mapper;

import com.healthconnection.application.dto.EpsDTO;
import com.healthconnection.domain.model.eps.EpsDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EpsMapperDTO{
	
	EpsDTO toDTO(EpsDomain domain);
	
	EpsDomain toDomain(EpsDTO dto);

}

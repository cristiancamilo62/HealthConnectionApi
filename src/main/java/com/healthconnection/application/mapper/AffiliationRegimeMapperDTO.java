package com.healthconnection.application.mapper;

import com.healthconnection.application.dto.AffiliationRegimeDTO;
import com.healthconnection.domain.model.affiliationregime.AffiliationRegimeDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AffiliationRegimeMapperDTO{
	
	AffiliationRegimeDomain toDomain(AffiliationRegimeDTO dto);
	
	AffiliationRegimeDTO toDTO(AffiliationRegimeDomain domain);

}

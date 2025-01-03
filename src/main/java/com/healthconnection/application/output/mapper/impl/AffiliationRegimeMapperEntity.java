package com.healthconnection.application.output.mapper.impl;

import com.healthconnection.application.output.mapper.MapperEntity;
import com.healthconnection.application.output.model.AffiliationRegimeEntity;
import com.healthconnection.domain.AffiliationRegimeDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AffiliationRegimeMapperEntity extends MapperEntity<AffiliationRegimeEntity, AffiliationRegimeDomain> {

	AffiliationRegimeDomain toDomain(AffiliationRegimeEntity entity);
	
	AffiliationRegimeEntity toEntity(AffiliationRegimeDomain domain);
	
}

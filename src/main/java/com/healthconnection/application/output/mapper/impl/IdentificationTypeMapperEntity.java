package com.healthconnection.application.output.mapper.impl;

import com.healthconnection.application.output.mapper.MapperEntity;
import com.healthconnection.application.output.model.IdentificationTypeEntity;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdentificationTypeMapperEntity extends MapperEntity<IdentificationTypeEntity, IdentificationTypeDomain> {

	IdentificationTypeEntity toEntity(IdentificationTypeDomain domain);
	
	IdentificationTypeDomain toDomain(IdentificationTypeEntity entity);
	
}

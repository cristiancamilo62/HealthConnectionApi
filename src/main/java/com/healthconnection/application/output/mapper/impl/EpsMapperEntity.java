package com.healthconnection.application.output.mapper.impl;

import com.healthconnection.application.output.mapper.MapperEntity;
import com.healthconnection.application.output.model.EpsEntity;
import com.healthconnection.domain.EpsDomain;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EpsMapperEntity extends MapperEntity<EpsEntity, EpsDomain> {
	
	EpsEntity toEntity(EpsDomain domain);
	
	EpsDomain toDomain(EpsEntity entity);

}

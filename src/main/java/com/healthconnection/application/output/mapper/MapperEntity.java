package com.healthconnection.application.output.mapper;

import org.springframework.stereotype.Component;

@Component
public interface MapperEntity<E,D> {
	
	D toDomain(E entity);
	
	E toEntity(D domain);

}

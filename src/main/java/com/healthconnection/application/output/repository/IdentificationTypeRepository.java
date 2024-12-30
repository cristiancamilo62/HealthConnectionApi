package com.healthconnection.application.output.repository;

import com.healthconnection.application.output.model.IdentificationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeEntity, UUID>{
	
	IdentificationTypeEntity findByCode(String code);

}

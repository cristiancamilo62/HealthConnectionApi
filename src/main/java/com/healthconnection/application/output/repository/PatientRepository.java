package com.healthconnection.application.output.repository;

import com.healthconnection.application.output.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
	
	List<PatientEntity> findByIdentification(String identification);
	
	boolean existsByEmail(String email);
	
	boolean existsByEmailAndPassword(String user, String password);
	
	Optional<PatientEntity> findByEmail(String email);

}


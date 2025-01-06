package com.healthconnection.infrastructure.repositories;

import com.healthconnection.infrastructure.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientJpaRepository extends JpaRepository<PatientEntity, UUID> {

    Optional<PatientEntity> findByIdentification(String identification);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String user, String password);

    Optional<PatientEntity> findByEmail(String email);

}

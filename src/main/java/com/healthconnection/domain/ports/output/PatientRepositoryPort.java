package com.healthconnection.domain.ports.output;

import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.infrastructure.entities.PatientEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepositoryPort {

    PatientDomain save(PatientDomain patient);

    Optional<PatientDomain> findById(UUID id);

    List<PatientDomain> findAll();

    List<PatientDomain> findAllExample(PatientDomain patient);

    void deleteById(UUID id);

    boolean existsById(UUID id);

    Optional<PatientDomain> findByIdentification(String identification);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String user, String password);

    Optional<PatientDomain> findByEmail(String email);

}

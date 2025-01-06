package com.healthconnection.domain.ports.input;


import com.healthconnection.domain.model.patient.PatientDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientServicePort {

    PatientDomain createPatient(PatientDomain patient);

    Optional<PatientDomain> getPatientById(UUID id);

    List<PatientDomain> getAllPatients();

    PatientDomain updatePatient(PatientDomain patient);

    void deletePatient(UUID id);

    boolean existsById(UUID id);
}

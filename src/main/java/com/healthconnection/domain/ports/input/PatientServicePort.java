package com.healthconnection.domain.ports.input;


import com.healthconnection.application.dto.PatientDTO;
import com.healthconnection.domain.model.patient.PatientDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientServicePort {

    void createPatient(PatientDomain patient);

    Optional<PatientDTO> getPatientById(UUID id);

    List<PatientDTO> getAllPatients();

    void updatePatient(PatientDomain patient);

    void deletePatient(UUID id);

}

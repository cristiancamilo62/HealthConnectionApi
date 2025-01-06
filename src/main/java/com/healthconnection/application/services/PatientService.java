package com.healthconnection.application.services;

import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.domain.model.patient.rules.executor.ValidationsRuleExecutor;
import com.healthconnection.domain.ports.input.PatientServicePort;
import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PatientService implements PatientServicePort {

    private final PatientRepositoryPort patientRepository;

    private final ValidationsRuleExecutor validationsRuleExecutor;


    @Override
    public PatientDomain createPatient(PatientDomain patient) {
        return new PatientDomain();
    }

    @Override
    public Optional<PatientDomain> getPatientById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<PatientDomain> getAllPatients() {
        return List.of();
    }

    @Override
    public PatientDomain updatePatient(PatientDomain patient) {
        return null;
    }

    @Override
    public void deletePatient(UUID id) {

    }

    @Override
    public boolean existsById(UUID id) {
        return false;
    }
}

package com.healthconnection.application.services;

import com.healthconnection.application.dto.PatientDTO;
import com.healthconnection.application.mapper.PatientMapperDTO;
import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.domain.model.patient.rules.executor.ValidationsRuleExecutor;
import com.healthconnection.domain.ports.input.PatientServicePort;
import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import com.healthconnection.infrastructure.adapters.messaging.service.RabbitMQAdapter;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
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

    private final PatientMapperDTO patientMapperDTO;

    private final RabbitMQAdapter rabbitMQAdapter;

    private final GenericValidationDataStructure genericValidationDataStructure;

    private static final String EXCHANGE = "patient.exchange";



    @Override
    public void createPatient(PatientDomain patient) {

        validationsRuleExecutor.validate(patient);

        rabbitMQAdapter.execute(patient,patient.getId(),EXCHANGE,"patient.create","create");

    }

    @Override
    public Optional<PatientDTO> getPatientById(UUID id) {

        genericValidationDataStructure.validateDataNotNullOrEmpty(id,"Id Patient");

        return patientRepository.findById(id).map(patientMapperDTO::toDTO);
    }

    @Override
    public List<PatientDTO> getAllPatients() {

        return patientMapperDTO.toDTOList(patientRepository.findAll());
    }

    @Override
    public void updatePatient(PatientDomain patient) {

       validationsRuleExecutor.validate(patient);

       rabbitMQAdapter.execute(patient,patient.getId(),EXCHANGE,"patient.update","update");

    }

    @Override
    public void deletePatient(UUID id) {

        genericValidationDataStructure.validateDataNotNullOrEmpty(id,"Id Patient");

        rabbitMQAdapter.execute(id,id,EXCHANGE,"patient.delete","delete");

    }

}

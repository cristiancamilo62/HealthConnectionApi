package com.healthconnection.application.usecase.patient.impl;

import com.healthconnection.application.output.mapper.impl.PatientMapperEntity;
import com.healthconnection.application.output.repository.PatientRepository;
import com.healthconnection.application.usecase.patient.RegisterPatientUseCase;
import com.healthconnection.application.usecase.patient.rules.executor.ValidationsRuleExecutor;
import com.healthconnection.domain.PatientDomain;

import java.util.UUID;


public class RegisterPatientUseCaseImpl implements RegisterPatientUseCase {

    private final PatientRepository patientRepository;

    private final ValidationsRuleExecutor validationsRuleExecutor;

    private final PatientMapperEntity patientMapperEntity;

    public RegisterPatientUseCaseImpl(PatientRepository patientRepository, ValidationsRuleExecutor validationsRuleExecutor, PatientMapperEntity patientMapperEntity) {
        this.patientRepository = patientRepository;
        this.validationsRuleExecutor = validationsRuleExecutor;
        this.patientMapperEntity = patientMapperEntity;
    }


    @Override
    public void execute(PatientDomain patientDomain) {

        patientDomain.setId(UUID.randomUUID());

        valida


    }

}

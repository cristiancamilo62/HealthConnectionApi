package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import com.healthconnection.domain.model.patient.exceptions.PatientEmailAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
import org.springframework.stereotype.Component;

@Component
public class PatientEmailAlreadyExistBusinessRule implements ValidationRule<String> {

	private final PatientRepositoryPort patientRepositoryPort;

	public PatientEmailAlreadyExistBusinessRule(PatientRepositoryPort patientRepository) {
		this.patientRepositoryPort = patientRepository;
	}

	@Override
    public void validate(String email) {
        if (patientRepositoryPort.existsByEmail(email)) {
            throw new PatientEmailAlreadyExistException();
        }
    }
}


package com.healthconnection.application.usecase.patient.rules.business;

import com.healthconnection.application.output.repository.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientEmailAlreadyExistException;
import com.healthconnection.application.usecase.ValidationRule;
import org.springframework.stereotype.Service;

@Service
public class PatientEmailAlreadyExistBusinessRule implements ValidationRule<String> {

	private final PatientRepository patientRepository;

	public PatientEmailAlreadyExistBusinessRule(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
    public void validate(String email) {
        if (patientRepository.existsByEmail(email)) {
            throw new PatientEmailAlreadyExistException();
        }
    }
}


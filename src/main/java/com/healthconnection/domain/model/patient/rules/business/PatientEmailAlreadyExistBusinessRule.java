package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.ports.output.repository.PatientRepository;
import com.healthconnection.domain.model.patient.exceptions.PatientEmailAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
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


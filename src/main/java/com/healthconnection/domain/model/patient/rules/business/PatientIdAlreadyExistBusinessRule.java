package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.ports.output.repository.PatientRepository;
import com.healthconnection.domain.model.patient.exceptions.PatientIdAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PatientIdAlreadyExistBusinessRule implements ValidationRule<UUID> {

	private final PatientRepository patientRepository;
	
	public PatientIdAlreadyExistBusinessRule(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public void validate(UUID id) {
		if(patientRepository.findById(id).isPresent()) {
			throw new PatientIdAlreadyExistException();
		}
	}
}

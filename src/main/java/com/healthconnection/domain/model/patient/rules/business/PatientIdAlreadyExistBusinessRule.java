package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.model.patient.exceptions.PatientIdAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PatientIdAlreadyExistBusinessRule implements ValidationRule<UUID> {

	private final PatientRepositoryPort patientRepositoryPort;
	
	public PatientIdAlreadyExistBusinessRule(PatientRepositoryPort patientRepository) {
		this.patientRepositoryPort = patientRepository;
	}

	@Override
	public void validate(UUID id) {
		if(patientRepositoryPort.findById(id).isPresent()) {
			throw new PatientIdAlreadyExistException();
		}
	}
}

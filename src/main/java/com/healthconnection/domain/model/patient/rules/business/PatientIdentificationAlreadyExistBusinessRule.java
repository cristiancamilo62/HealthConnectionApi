package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import com.healthconnection.domain.model.patient.exceptions.PatientIdentificationAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
import org.springframework.stereotype.Service;

@Service
public class PatientIdentificationAlreadyExistBusinessRule implements ValidationRule<String> {
	
	private final PatientRepositoryPort patientRepositoryPort;
	
	public PatientIdentificationAlreadyExistBusinessRule(PatientRepositoryPort patientRepository) {
		this.patientRepositoryPort = patientRepository;
	}

	@Override
	public void validate(String identification) {

        if (patientRepositoryPort.findByIdentification(identification).isPresent()) {
            throw new PatientIdentificationAlreadyExistException();
        }

    }
		

}

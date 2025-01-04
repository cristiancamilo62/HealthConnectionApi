package com.healthconnection.domain.model.patient.rules.business;

import com.healthconnection.domain.ports.output.repository.PatientRepository;
import com.healthconnection.domain.model.patient.exceptions.PatientIdentificationAlreadyExistException;
import com.healthconnection.domain.model.ValidationRule;
import org.springframework.stereotype.Service;

@Service
public class PatientIdentificationAlreadyExistBusinessRule implements ValidationRule<String> {
	
	private final PatientRepository patientRepository;
	
	public PatientIdentificationAlreadyExistBusinessRule(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public void validate(String identification) {

        if (!patientRepository.findByIdentification(identification).isEmpty()) {
            throw new PatientIdentificationAlreadyExistException();
        }

    }
		

}

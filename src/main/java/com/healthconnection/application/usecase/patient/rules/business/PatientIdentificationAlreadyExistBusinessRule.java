package com.healthconnection.application.usecase.patient.rules.business;

import com.healthconnection.application.output.repository.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientIdentificationAlreadyExistException;
import com.healthconnection.application.usecase.ValidationRule;
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

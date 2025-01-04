package com.healthconnection.domain.model.patient.rules.validation;

import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class IdPatientRuleValidator implements ValidationRule<UUID> {

	public static final String FIELD_NAME_ID_PATIENT = "id Patient";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public IdPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(UUID idPatient) {

		genericValidationDataStructure.validateDataNotNullOrEmpty(idPatient,FIELD_NAME_ID_PATIENT);

		genericValidationDataStructure.validateUuidDefault(idPatient,FIELD_NAME_ID_PATIENT);
	}
}

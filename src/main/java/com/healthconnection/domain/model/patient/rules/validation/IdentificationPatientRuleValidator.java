package com.healthconnection.domain.model.patient.rules.validation;

import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class IdentificationPatientRuleValidator implements ValidationRule<String> {

	public static final String FIELD_NAME_IDENTIFICATION = "Identification";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public IdentificationPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String identification) {

		genericValidationDataStructure.validateDataNotNullOrEmpty(identification, FIELD_NAME_IDENTIFICATION);

		genericValidationDataStructure.validateLengthDataRange(identification,8,10,FIELD_NAME_IDENTIFICATION);

		genericValidationDataStructure.validateFormatDataOnlyDigits(identification,FIELD_NAME_IDENTIFICATION);
		
	}

}

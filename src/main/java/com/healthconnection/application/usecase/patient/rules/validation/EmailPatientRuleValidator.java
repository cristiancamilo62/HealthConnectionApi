package com.healthconnection.application.usecase.patient.rules.validation;

import com.healthconnection.application.usecase.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class EmailPatientRuleValidator implements ValidationRule<String> {

	public static final String FIELD_NAME_EMAIL = "Email";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public EmailPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String email) {

		genericValidationDataStructure.validateDataNotNullOrEmpty(email,FIELD_NAME_EMAIL);

		genericValidationDataStructure.validateLengthDataRange(email,11,40,FIELD_NAME_EMAIL);

		genericValidationDataStructure.validateFormatDataOnlyLettersAndDigitsAtDomain(email,FIELD_NAME_EMAIL);
	}
}

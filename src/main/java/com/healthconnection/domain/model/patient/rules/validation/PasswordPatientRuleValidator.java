package com.healthconnection.domain.model.patient.rules.validation;

import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class PasswordPatientRuleValidator implements ValidationRule<String> {

	public static final String FIELD_NAME_PASSWORD = "password";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public PasswordPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String password) {

		genericValidationDataStructure.validateDataNotNullOrEmpty(password, FIELD_NAME_PASSWORD);

		genericValidationDataStructure.validateLengthDataRange(password,8,60,FIELD_NAME_PASSWORD);

		genericValidationDataStructure.validateFormatPassword(password, FIELD_NAME_PASSWORD);
	}
}

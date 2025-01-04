package com.healthconnection.domain.model.patient.rules.validation;

import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberPatientRuleValidator implements ValidationRule<String> {

	public static final String FIELD_NAME_PHONE_NUMBER = "phone number";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public PhoneNumberPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String phoneNumber) {

		genericValidationDataStructure.validateLengthDataOptional(phoneNumber,10,FIELD_NAME_PHONE_NUMBER);

		genericValidationDataStructure.validateFormatDataOptional(phoneNumber,FIELD_NAME_PHONE_NUMBER);
	}
}

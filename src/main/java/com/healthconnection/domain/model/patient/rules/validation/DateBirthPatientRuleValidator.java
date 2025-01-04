package com.healthconnection.domain.model.patient.rules.validation;


import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.shared.validators.structure.GenericValidationDataStructure;
import org.springframework.stereotype.Service;

@Service
public class DateBirthPatientRuleValidator implements ValidationRule<String> {

	public static final String FIELD_NAME_DATE_BIRTH = "date birth";
	private final GenericValidationDataStructure genericValidationDataStructure;

    public DateBirthPatientRuleValidator(GenericValidationDataStructure genericValidationDataStructure) {
        this.genericValidationDataStructure = genericValidationDataStructure;
    }

    @Override
	public void validate(String dateBirth) {

		genericValidationDataStructure.validateDataNotNullOrEmpty(dateBirth,FIELD_NAME_DATE_BIRTH);

		genericValidationDataStructure.validateFormatDataDateTime(dateBirth,FIELD_NAME_DATE_BIRTH);
	}
	//TODO: VALIDAR QUE SEA ANTES QUE LA FECHA ACTUAL EN DOMAIN Y VALIDAR TMABIEN QUE LA CEDULA AÑO CON TIPO DE DOCUMENTO

}

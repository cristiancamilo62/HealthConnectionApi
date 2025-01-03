package com.healthconnection.application.usecase.patient.rules.executor;

import com.healthconnection.application.usecase.ValidationRule;
import com.healthconnection.application.usecase.patient.rules.business.PatientEmailAlreadyExistBusinessRule;
import com.healthconnection.application.usecase.patient.rules.business.PatientIdAlreadyExistBusinessRule;
import com.healthconnection.application.usecase.patient.rules.business.PatientIdentificationAlreadyExistBusinessRule;
import com.healthconnection.application.usecase.patient.rules.validation.*;
import com.healthconnection.domain.PatientDomain;
import org.springframework.stereotype.Service;

@Service
public class ValidationsRuleExecutor implements ValidationRule<PatientDomain> {

    private final IdPatientRuleValidator idPatientRuleValidator;

    private final NamePatientRuleValidator namePatientRuleValidator;

    private final IdentificationPatientRuleValidator identificationPatientRuleValidator;

    private final EmailPatientRuleValidator emailPatientRuleValidator;

    private final PasswordPatientRuleValidator passwordPatientRuleValidator;

    private final PhoneNumberPatientRuleValidator phoneNumberPatientRuleValidator;

   private final PatientIdAlreadyExistBusinessRule patientIdAlreadyExistBusinessRule;

   private final PatientIdentificationAlreadyExistBusinessRule patientIdentificationAlreadyExistBusinessRule;

   private final PatientEmailAlreadyExistBusinessRule patientEmailAlreadyExistBusinessRule;

    public ValidationsRuleExecutor(IdPatientRuleValidator idPatientRuleValidator, NamePatientRuleValidator namePatientRuleValidator, IdentificationPatientRuleValidator identificationPatientRuleValidator, EmailPatientRuleValidator emailPatientRuleValidator, PasswordPatientRuleValidator passwordPatientRuleValidator, PhoneNumberPatientRuleValidator phoneNumberPatientRuleValidator, PatientIdAlreadyExistBusinessRule patientIdAlreadyExistBusinessRule, PatientIdentificationAlreadyExistBusinessRule patientIdentificationAlreadyExistBusinessRule, PatientEmailAlreadyExistBusinessRule patientEmailAlreadyExistBusinessRule) {
        this.idPatientRuleValidator = idPatientRuleValidator;
        this.namePatientRuleValidator = namePatientRuleValidator;
        this.identificationPatientRuleValidator = identificationPatientRuleValidator;
        this.emailPatientRuleValidator = emailPatientRuleValidator;
        this.passwordPatientRuleValidator = passwordPatientRuleValidator;
        this.phoneNumberPatientRuleValidator = phoneNumberPatientRuleValidator;
        this.patientIdAlreadyExistBusinessRule = patientIdAlreadyExistBusinessRule;
        this.patientIdentificationAlreadyExistBusinessRule = patientIdentificationAlreadyExistBusinessRule;
        this.patientEmailAlreadyExistBusinessRule = patientEmailAlreadyExistBusinessRule;
    }


    @Override
    public void validate(PatientDomain patientDomain) {

        idPatientRuleValidator.validate(patientDomain.getId());

        namePatientRuleValidator.validate(patientDomain);

        identificationPatientRuleValidator.validate(patientDomain.getIdentification());

        emailPatientRuleValidator.validate(patientDomain.getEmail());

        passwordPatientRuleValidator.validate(patientDomain.getPassword());

        phoneNumberPatientRuleValidator.validate(patientDomain.getPhoneNumber());

        patientIdAlreadyExistBusinessRule.validate(patientDomain.getId());

        patientIdentificationAlreadyExistBusinessRule.validate(patientDomain.getIdentification());

        patientEmailAlreadyExistBusinessRule.validate(patientDomain.getEmail());
    }
}

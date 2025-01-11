package com.healthconnection.domain.model.patient.rules.executor;

import com.healthconnection.domain.model.ValidationRule;
import com.healthconnection.domain.model.patient.rules.business.PatientEmailAlreadyExistBusinessRule;
import com.healthconnection.domain.model.patient.rules.business.PatientIdAlreadyExistBusinessRule;
import com.healthconnection.domain.model.patient.rules.business.PatientIdentificationAlreadyExistBusinessRule;
import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.domain.model.patient.rules.validation.*;
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

        patientIdAlreadyExistBusinessRule.validate(patientDomain.getId());

        namePatientRuleValidator.validate(patientDomain);

        identificationPatientRuleValidator.validate(patientDomain.getIdentification());

        emailPatientRuleValidator.validate(patientDomain.getEmail());

        passwordPatientRuleValidator.validate(patientDomain.getPassword());

        phoneNumberPatientRuleValidator.validate(patientDomain.getPhoneNumber());

        patientIdentificationAlreadyExistBusinessRule.validate(patientDomain.getIdentification());

        patientEmailAlreadyExistBusinessRule.validate(patientDomain.getEmail());
    }
}

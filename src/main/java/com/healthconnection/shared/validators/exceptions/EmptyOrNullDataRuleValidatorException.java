package com.healthconnection.shared.validators.exceptions;

import com.healthconnection.shared.exception.custom.SharedHealthException;

public class EmptyOrNullDataRuleValidatorException extends SharedHealthException {

    public EmptyOrNullDataRuleValidatorException(String message) {
        super(message);
    }
}

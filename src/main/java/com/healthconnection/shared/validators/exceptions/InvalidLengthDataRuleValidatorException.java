package com.healthconnection.shared.validators.exceptions;

import com.healthconnection.shared.exception.custom.SharedHealthException;

public class InvalidLengthDataRuleValidatorException extends SharedHealthException {

    public InvalidLengthDataRuleValidatorException(String userMessage) {
        super(userMessage);
    }
}

package com.healthconnection.shared.validators.exceptions;

import com.healthconnection.shared.exception.custom.SharedHealthException;

public class DefaultDataRuleValidatorException extends SharedHealthException {

    public DefaultDataRuleValidatorException(String userMessage) {
        super(userMessage);
    }
}

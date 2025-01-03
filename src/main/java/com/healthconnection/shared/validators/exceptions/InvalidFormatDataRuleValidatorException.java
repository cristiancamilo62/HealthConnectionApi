package com.healthconnection.shared.validators.exceptions;

import com.healthconnection.shared.exception.custom.SharedHealthException;
import com.healthconnection.shared.messages.MessageCatalog;
import com.healthconnection.shared.messages.enums.MessageCode;

public class InvalidFormatDataRuleValidatorException extends SharedHealthException {

    public InvalidFormatDataRuleValidatorException(String message) {
        super(message);
    }
}

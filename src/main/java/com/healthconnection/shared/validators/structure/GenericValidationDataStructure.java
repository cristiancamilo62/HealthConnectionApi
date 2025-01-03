package com.healthconnection.shared.validators.structure;

import com.healthconnection.shared.helper.ObjectHelper;
import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import com.healthconnection.shared.messages.MessageCatalog;
import com.healthconnection.shared.messages.enums.MessageCode;
import com.healthconnection.shared.validators.exceptions.DefaultDataRuleValidatorException;
import com.healthconnection.shared.validators.exceptions.EmptyOrNullDataRuleValidatorException;
import com.healthconnection.shared.validators.exceptions.InvalidFormatDataRuleValidatorException;
import com.healthconnection.shared.validators.exceptions.InvalidLengthDataRuleValidatorException;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public final class GenericValidationDataStructure {

    private GenericValidationDataStructure() {
        super();
    }

    public void validateDataNotNullOrEmpty(Object value, String dataName){
        if(TextHelper.isNullOrEmpty((String) value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000004);
            throw  new EmptyOrNullDataRuleValidatorException(userMessage);
        }
    }

    public void validateFormatDataOnlyDigits(String value, String dataName){
        if(TextHelper.containsOnlyDigits(value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000005);
            throw new InvalidFormatDataRuleValidatorException(userMessage);
        }
    }

    public void validateFormatDataDateTime(String value, String dataName) {
        if (TextHelper.containsOnlyLettersDigits(value)) {
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000006);
            throw new InvalidFormatDataRuleValidatorException(userMessage);
        }
    }

    public void validateFormatDataOnlyLettersAndDigits(String value, String dataName) {
        if(!TextHelper.isValidDateTime(value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000007);
            throw new InvalidFormatDataRuleValidatorException(userMessage);
        }
    }

    public void validateFormatDataOnlyLettersAndDigitsAtDomain(String value, String dataName) {
        if(TextHelper.containsOnlyLettersDigitsAtDomain(value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000008);
            throw new InvalidFormatDataRuleValidatorException(userMessage);
        }
    }

    public void validateFormatPassword(String value, String dataName) {
        if(!TextHelper.isValidPassword(value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000009);
            throw new InvalidFormatDataRuleValidatorException(userMessage);
        }
    }
    public void validateFormatDataOptional(String value, String dataName) {
        switch (dataName){
            case "phone number":
                validateFormatDataOnlyDigits(value, dataName);
                break;
            case "middle name", "middle last name":
                validateFormatDataOnlyLettersAndDigits(value, dataName);
                break;
        }
    }
    public void validateLengthDataRange(String value, int minLength, int maxLength, String dataName) {
        if(!TextHelper.isValidLength(value, minLength, maxLength)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000010) + minLength + " and " + maxLength;
            throw new InvalidLengthDataRuleValidatorException(userMessage);
        }
    }
    public void validateLengthDataExact(String value, int length, String dataName) {
        if(!TextHelper.isExactLength(value, length)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000011) + length ;
            throw new InvalidLengthDataRuleValidatorException(userMessage);
        }
    }

    public void validateLengthDataOptional(String value,int length, String dataName) {
        switch (dataName){
            case "phone number":
                validateLengthDataExact(value,length,dataName);
                break;
            case "middle name", "middle last name":
                validateLengthDataRange(value,0,length,dataName);
                break;
        }
    }

    public void validateUuidDefault(UUID value, String dataName) {
        if(UuidHelper.isDefault(value)){
            String userMessage = dataName + MessageCatalog.getContentMessage(MessageCode.M0000012);
            throw new DefaultDataRuleValidatorException(userMessage);
        }
    }
}

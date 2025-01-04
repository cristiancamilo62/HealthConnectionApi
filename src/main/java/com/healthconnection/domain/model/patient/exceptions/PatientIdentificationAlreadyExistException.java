package com.healthconnection.domain.model.patient.exceptions;

import com.healthconnection.shared.exception.custom.UseCaseHealthException;
import com.healthconnection.shared.messages.MessageCatalog;
import com.healthconnection.shared.messages.enums.MessageCode;

public class PatientIdentificationAlreadyExistException extends UseCaseHealthException {

	public PatientIdentificationAlreadyExistException() {

		super(MessageCatalog.getContentMessage(MessageCode.M0000015));
	}

}

package com.healthconnection.application.usecase.patient.exceptions;

import com.healthconnection.shared.exception.custom.UseCaseHealthException;
import com.healthconnection.shared.messages.MessageCatalog;
import com.healthconnection.shared.messages.enums.MessageCode;

public class PatientIdAlreadyExistException extends UseCaseHealthException {

	public PatientIdAlreadyExistException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000014),MessageCatalog.getContentMessage(MessageCode.M0000003));
	}

}

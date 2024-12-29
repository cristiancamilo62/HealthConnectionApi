package com.healthconnection.shared.exception.custom;


import com.healthconnection.shared.exception.HealthException;
import com.healthconnection.shared.exception.enums.LocationException;

import java.io.Serial;

public class ControllerHealthException extends HealthException {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.CONTROLLER;

	public ControllerHealthException(final String userMessage) {
		super(userMessage, location);
	}

	public ControllerHealthException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public ControllerHealthException(final String technicalMessage, final String userMessage,
			final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}

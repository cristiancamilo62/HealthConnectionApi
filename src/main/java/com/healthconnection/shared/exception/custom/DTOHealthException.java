package com.healthconnection.shared.exception.custom;


import com.healthconnection.shared.exception.enums.LocationException;

import java.io.Serial;

public class DTOHealthException extends com.healthconnection.shared.exception.HealthException {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.DTO;

	public DTOHealthException(final String userMessage) {
		super(userMessage, location);
	}

	public DTOHealthException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public DTOHealthException(final String technicalMessage, final String userMessage,
			final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}

package com.healthconnection.shared.exception.custom;


import com.healthconnection.shared.exception.HealthException;
import com.healthconnection.shared.exception.enums.LocationException;

import java.io.Serial;

public class EntityHealthException extends HealthException {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.ENTITY;
	
	public EntityHealthException(final String userMessage) {
		super(userMessage, location);
	}

	public EntityHealthException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public EntityHealthException(final String technicalMessage, final String userMessage,
			final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}

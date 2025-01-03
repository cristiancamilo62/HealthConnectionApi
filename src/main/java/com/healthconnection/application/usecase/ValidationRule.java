package com.healthconnection.application.usecase;

import org.springframework.stereotype.Service;

@Service
public interface ValidationRule<T> {
	
	void validate(T data);

}

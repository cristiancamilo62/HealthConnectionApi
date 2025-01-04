package com.healthconnection.domain.model;

public interface ValidationRule<T> {
	
	void validate(T data);

}

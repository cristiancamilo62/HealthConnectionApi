package com.healthconnection.application.input.handler;

public interface HandlerWithoutReturn<D> {
	
	void execute(D data);

}

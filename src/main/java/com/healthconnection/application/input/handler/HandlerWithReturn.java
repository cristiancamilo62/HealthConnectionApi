package com.healthconnection.application.input.handler;

public interface HandlerWithReturn<D,R> {
	
	R execute(D data);

}

package com.ul.project.interceptor;

public class UnmarshalRequest implements IUnmarshalRequest {

	private Exception exception;
	private String className;
	
	@Override
	public Exception getException() {
		return this.exception;
	}

	@Override
	public void setException(Exception exception) {
		this.exception = exception;			
	}

	@Override
	public void setClassName(String className) {
		this.className = className;			
		
	}

	@Override
	public String getClassName() {
		return this.className;
	}
}

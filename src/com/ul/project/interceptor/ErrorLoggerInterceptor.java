package com.ul.project.interceptor;

public class ErrorLoggerInterceptor implements ClientInterceptor {

	@Override
	public void preMarshlling(IUnmarshalRequest request) {
		System.out.println("Exception occured for "+request.getClassName()+
				" and exception type is "+request.getException().toString());
	}

	@Override
	public void postMarshlling(MarshalRequest request) {

	}

}

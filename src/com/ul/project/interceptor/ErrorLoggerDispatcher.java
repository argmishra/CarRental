package com.ul.project.interceptor;

public class ErrorLoggerDispatcher implements ILoggerDispatcher {
	public ErrorLoggerDispatcher() {
	}

	@Override
	public void dispatching(IUnmarshalRequest request) {
		ErrorLoggerInterceptor interceptor = new ErrorLoggerInterceptor();
		interceptor.preMarshlling(request);
	}
}

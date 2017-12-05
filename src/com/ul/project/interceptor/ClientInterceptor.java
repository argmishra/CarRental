package com.ul.project.interceptor;

public interface ClientInterceptor {
	     void preMarshlling(IUnmarshalRequest request);
	     void postMarshlling(MarshalRequest request);
	 }

package com.ul.project.interceptor;

public interface IUnmarshalRequest {
	public void setException(Exception exception);
	public Exception getException();
	public void setClassName(String className);
	public String getClassName();
}

package com.ul.project.interceptor;

public class InfoLogger implements ILogger {

	@Override
	public void logging() {
		System.out.println("Write log statement for info");
		
	}

}

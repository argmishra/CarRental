package com.ul.project.interceptor;

public class Client {
	LoggerManager loggerManager;
	public void setLoggerManager(LoggerManager loggerManager){
		this.loggerManager = loggerManager;
	}
	public void saveLog(){
		loggerManager.loggerRequest();
	}
}

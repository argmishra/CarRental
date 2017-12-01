package com.ul.project.interceptor;

public class LoggerManager {

	LoggerChain loggerChain;

	public LoggerManager(){
		loggerChain = new LoggerChain();
		
	}
	public void setLogger(ILogger logger){
		loggerChain.addLogger(logger);
	}

	public void loggerRequest(){
		loggerChain.logging();
	}
}

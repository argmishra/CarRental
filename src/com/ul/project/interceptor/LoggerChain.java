package com.ul.project.interceptor;

import java.util.ArrayList;
import java.util.List;

public class LoggerChain {
	private List<ILogger> loggers= new ArrayList<ILogger>();

	public void addLogger(ILogger logger){
		loggers.add(logger);
	}

	public void logging(){
		for (ILogger logger : loggers) {
			logger.logging();
		}
	}

}

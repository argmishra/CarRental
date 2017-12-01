package com.ul.project.utilities;

import com.ul.project.interceptor.Client;
import com.ul.project.interceptor.ErrorLogger;
import com.ul.project.interceptor.LoggerManager;
import com.ul.project.threads.ThreadSendMail;

// TODO: Auto-generated Javadoc
/**
 * The Class CarRentalUtilities.
 */
public class CarRentalUtilities {
	
public static void loggingError() {
	LoggerManager loggerManager = new LoggerManager();
	loggerManager.setLogger(new ErrorLogger());
	//loggerManager.setLogger(new InfoLogger());
	Client client = new Client();
	client.setLoggerManager(loggerManager);
	client.saveLog();
}

public static void sendingEmail(int id, String to, String type) throws Exception{
	ThreadSendMail send=new ThreadSendMail(id,to,type);
	Thread t=new Thread(send);
	t.start();
}
}

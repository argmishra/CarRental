package com.ul.project.utilities;

import com.ul.project.interceptor.IUnmarshalRequest;
import com.ul.project.interceptor.ErrorLoggerDispatcher;
import com.ul.project.interceptor.UnmarshalRequest;
import com.ul.project.threads.ThreadSendMail;

// TODO: Auto-generated Javadoc
/**
 * The Class CarRentalUtilities.
 */
public class CarRentalUtilities {

	/**
	 * Sending email.
	 *
	 * @param id the id
	 * @param to the to
	 * @param type the type
	 * @throws Exception the exception
	 */
	public static void sendingEmail(int id, String to, String type) throws Exception{
		ThreadSendMail send=new ThreadSendMail(id,to,type);
		Thread t=new Thread(send);
		t.start();
	}

	public static void loggingError(Exception exception, String className) {
		IUnmarshalRequest userIUnmarshaledRequest = new UnmarshalRequest();
		userIUnmarshaledRequest.setException(exception); 
		userIUnmarshaledRequest.setClassName(className); 
		ErrorLoggerDispatcher dispatcher = new ErrorLoggerDispatcher();
		dispatcher.dispatching(userIUnmarshaledRequest);
	}

}

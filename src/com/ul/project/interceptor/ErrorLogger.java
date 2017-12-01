package com.ul.project.interceptor;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class ErrorLogger implements ILogger {
	final static Logger l = Logger.getLogger(ErrorLogger.class);

	@Override
	public void logging() {
		
		
		l.debug("This is debug message");
	      l.info("This is info message");
	      l.warn("This is warn message");
	      l.fatal("This is fatal message");
	      l.error("This is error message");
	 
	      System.out.println("Your logic executed successfully....");
		/* Layout l1 = new SimpleLayout();
		   Appender a;
		   try
		   {
		   a = new FileAppender(l1,"my.txt", false);
		 
		   // 3rd parameter is true by default
		   // true = Appends the data into my.txt
		   // false = delete previous data and re-write
		 
		   l.addAppender(a);
		   }
		   catch(Exception e) {}   
		 
		   l.error("This is the error message..");
		   System.out.println("Your logic executed successfully....");*/
		
	}

}

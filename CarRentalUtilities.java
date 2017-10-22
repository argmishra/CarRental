package com.ul.project.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ul.project.constants.CarRentalConstants;

public class CarRentalUtilities {

	public static void sendingEmial(int id, String to, String type){  
		//Get properties object    
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		//get Session   
		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(CarRentalConstants.FROM_EMAIL_ID,CarRentalConstants.FROM_EMAIL_PASSWORD);  
			}    
		});    
		//compose message    
		try {    
			MimeMessage message = new MimeMessage(session);    
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			message.setSubject(CarRentalConstants.CAR_REGISTRATION_SUBJECT); 
			if("adding".equalsIgnoreCase(type)) {
				message.setSubject(CarRentalConstants.CAR_REGISTRATION_SUBJECT); 
				message.setText(CarRentalConstants.CAR_REGISTRATION_MESSAGE+id);   
			}else if ("booking".equalsIgnoreCase(type)){
				message.setSubject(CarRentalConstants.BOOK_CAR_SUBJECT); 
				message.setText(CarRentalConstants.BOOK_CAR_MESSAGE+id);
			}else {
				message.setSubject(CarRentalConstants.USER_REGISTRATION_SUBJECT);
				message.setText(CarRentalConstants.USER_REGISTRATION_MESSAGE+id); 
			}

			//send message  
			Transport.send(message);    
		} catch (MessagingException e) {throw new RuntimeException(e);}    

	}

}

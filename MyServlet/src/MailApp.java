


import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServlet;




/**
 * Servlet implementation class MailApp
 */

public class MailApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected static void send (String name, String emailaddress, String msg) throws AddressException, MessagingException {
		
		Session session = MailConnect.mail();
		
	
	try {
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("info@vikasshiva.com"));
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(emailaddress));
		 message.setSubject("We appreciate your comments");
		 message.setText("We will get back to you as soon as possible.");
		 
		 Transport.send(message);
	} catch(Exception e) {
		e.printStackTrace();
	}
	MailApp2.send(name, emailaddress, msg);
	
	}
protected static void register(String name,String password,String email){
	Session session = MailConnect.mail();
try {
	
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress("info@vikasshiva.com"));
	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
	 message.setSubject("You Have Successfully Registered");
	 message.setText("Check if your information is correct:"+"\nName: "+name+"\nemail address: "
	 		+email);
	 
	 
	 Transport.send(message);
	 MailApp2.register(name, password, email);
} catch(Exception e) {
	e.printStackTrace();
}
	}
protected static void newPassword(String pass, String firstname,String email){
	Session session = MailConnect.mail();
try {
	
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress("info@vikasshiva.com"));
	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));
	 message.setSubject("Here is your password");
	 message.setText("Hi, "+firstname+"!\n\nHere is your password: "+pass);
	 Transport.send(message);
}
catch(Exception e) {
	e.printStackTrace();
}
}
}
	


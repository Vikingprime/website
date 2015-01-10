




import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServlet;




/**
 * Servlet implementation class MailApp
 */

public class MailApp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected static void send(String name, String emailaddress, String msg) throws AddressException, MessagingException {
		Session session = MailConnect.mail();
	try {
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("info@vikasshiva.com"));
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress("info@vikasshiva.com"));
		 message.setSubject("A New Comment Has Been Submitted");
		 message.setText("Name: "+name+"\nEmail: "+emailaddress+"\nComment: "+msg);
		 
		 Transport.send(message);
	} catch(Exception e) {
		e.printStackTrace();
	}
	}
	protected static void register(String name,String password,String email){
		Session session = MailConnect.mail();
	try {
		
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("info@vikasshiva.com"));
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress("info@vikasshiva.com"));
		 message.setSubject("A New Member Has Just Registered");
		 message.setText("Here is his/her information: "+"\nName: "+name+"\nemail address: "
		 		+email+"\nPassword: "+password);
		 
		 
		 Transport.send(message);
	} catch(Exception e) {
		e.printStackTrace();
	}
		}
	
	
	}
	

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;


public class MailConnect {
protected static Session mail() {
	Properties props = new Properties();
	props.put("mail.smtp.host","smtp.vikasshiva.com");
	props.put("mail.smtp.port", "25");
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.starttls.enable","true");
	
	Session session = Session.getInstance(props, new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("info@vikasshiva.com","jaedong445");
	
	
	}
	});
return session;
}
}

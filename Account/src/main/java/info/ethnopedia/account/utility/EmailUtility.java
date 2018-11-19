package info.ethnopedia.account.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 * A utility class for sending e-mail messages
 * @author www.codejava.net
 *
 */
public class EmailUtility {
    public static void sendEmail(String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
    	// get Email properties
    	Properties prop = new Properties();
    	String emailParameters = "emailParameters.properties";
    	InputStream input = EmailUtility.class.getClassLoader().getResourceAsStream(emailParameters);
		
    	try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

        String host = prop.getProperty("host");
        String port = prop.getProperty("port");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
    	
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
        
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(user));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
 
    }
    
    public static void sendMultipleEmail(List<String> toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
    	
    	// get Email properties
    	Properties prop = new Properties();
    	String emailParameters = "emailParameters.properties";
    	InputStream input = EmailUtility.class.getClassLoader().getResourceAsStream(emailParameters);
		
    	try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}

        String host = prop.getProperty("host");
        String port = prop.getProperty("port");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
        
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(user));
        
        InternetAddress[] toAddresses = new InternetAddress[toAddress.size()];
        
        for (int i=0; i<toAddress.size(); i++)
        	toAddresses[i] = new InternetAddress(toAddress.get(i));
        
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
 
    }
    
}
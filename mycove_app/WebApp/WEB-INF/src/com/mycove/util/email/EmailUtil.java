package com.mycove.util.email;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * @author Karthikeyan
 */

public class EmailUtil implements Runnable
{

	public static String MIME_TYPE_TEXT = "text/plain";
	public static String MIME_TYPE_HTML = "text/html";
	
	private final Logger log = Logger.getLogger(EmailUtil.class);
	private String user;
	private String password;
	private String emailFrom;
	private Collection<String> emailTo;
	private Collection<String> emailBcc;
	private Collection<String> emailCc;
	private String subject;
	private String body;
	private String host;
	private Boolean auth;
	private int port;
	private String mimeType;
	
	
	public EmailUtil() throws IOException {
		InputStream fis = this.getClass().getClassLoader().getResourceAsStream("mailConfig.properties");
		Properties mailProperties = new Properties();
		mailProperties.load(fis);
		user = mailProperties.getProperty("mail.userName");
		password = mailProperties.getProperty("mail.password");
		emailFrom = mailProperties.getProperty("mail.from");
		emailTo = new ArrayList<String>();
		emailBcc = new ArrayList<String>();
		emailCc = new ArrayList<String>();
		subject = "";
		body = "";
		host = mailProperties.getProperty("mail.host");
		auth = Boolean.parseBoolean(mailProperties.getProperty("mail.auth"));
		port = Integer.parseInt(mailProperties.getProperty("mail.Port"));
		mimeType = MIME_TYPE_TEXT;
	}

	/**
	 * 
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void postMail() throws MessagingException, ParserConfigurationException, SAXException, IOException
	{
		log.debug("Sending mail...");
		Message msg = new MimeMessage(getMailSession());
		msg = setMailAddresses(msg);
		msg.setSubject(subject);
		msg.setContent(body, mimeType);
		// Send mail
		Transport.send(msg);
		log.debug("Mail Successfully sent...");
	}
	
	/*public void postMailWithAttachment(String fileName) throws MessagingException
	{
		log.debug("Sending mail with Attachment. Attached File Name : "+fileName);
		
		try {
		Message msg = new MimeMessage(getMailSession());
		
		msg = setMailAddresses(msg);
		msg.setSentDate(new Date());
	    
		Multipart multipart = new MimeMultipart();
		FileDataSource fds = new FileDataSource(fileName);
		
		// Attaching file with the mail.
		BodyPart attachment = new MimeBodyPart();
		attachment.setDataHandler(new DataHandler(fds));
		attachment.setFileName(fds.getName());
		attachment.setDisposition(Part.ATTACHMENT);
		
		multipart.addBodyPart(attachment);

		//	Adding body part with the mail.
		BodyPart bodyPart = new MimeBodyPart();
		bodyPart.setText(body);
		bodyPart.setDisposition(Part.INLINE);
		multipart.addBodyPart(bodyPart);

		msg.setContent(multipart, mimeType);
		msg.setSubject(subject);
		
		// Send mail
		Transport.send(msg);
		log.debug("Mail Successfull sent...");
	} catch (Exception e) {
		log.debug("exception is " + e);
	    }
	}*/
	
	public class SMTPAuthenticator extends javax.mail.Authenticator
	{
		public PasswordAuthentication getPasswordAuthentication()
		{
			String AUTH_USER = user;
			String AUTH_PASS = password; 
			return new PasswordAuthentication(AUTH_USER, AUTH_PASS);
		}
	}
	
	private Message setMailAddresses(Message msg) throws MessagingException {
		// Setting From addresses
		InternetAddress addressFrom = new InternetAddress(emailFrom);
		msg.setFrom(addressFrom);            

		int i = 0;
		// Adding the TO email addresses
		InternetAddress[] addressTo = new InternetAddress[emailTo.size()];
		for (String mailAddr : emailTo)
		{
			addressTo[i++] = new InternetAddress(mailAddr);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		//	Adding the BCC email addresses
		InternetAddress[] addressBcc = new InternetAddress[emailBcc.size()];
		i = 0;
		for (String mailAddr : emailBcc)
		{
			addressBcc[i] = new InternetAddress(mailAddr);
		}
		msg.setRecipients(Message.RecipientType.BCC, addressBcc);

		// Adding the CC email addresses
		InternetAddress[] addressCc = new InternetAddress[emailCc.size()];
		i = 0;
		for (String mailAddr : emailCc)
		{
			addressCc[i] = new InternetAddress(mailAddr);
		}
		msg.setRecipients(Message.RecipientType.CC, addressCc);
		return msg;
		

	}
	/**
	 * this methode is used to get mail server information 
	 * @return
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	private Session getMailSession() throws ParserConfigurationException, SAXException, IOException {
		boolean debug = false;
		Properties props = new Properties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable","true");


		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		session.setDebug(debug);
		return session;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailFrom
	 */
	public String getEmailFrom() {
		return emailFrom;
	}

	/**
	 * @param emailFrom the emailFrom to set
	 */
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	/**
	 * @return the emailTo
	 */
	public Collection<String> getEmailTo() {
		return emailTo;
	}

	/**
	 * @param emailTo the emailTo to set
	 */
	public void setEmailTo(Collection<String> emailTo) {
		this.emailTo = emailTo;
	}

	/**
	 * @return the emailBcc
	 */
	public Collection<String> getEmailBcc() {
		return emailBcc;
	}

	/**
	 * @param emailBcc the emailBcc to set
	 */
	public void setEmailBcc(Collection<String> emailBcc) {
		this.emailBcc = emailBcc;
	}

	/**
	 * @return the emailCc
	 */
	public Collection<String> getEmailCc() {
		return emailCc;
	}

	/**
	 * @param emailCc the emailCc to set
	 */
	public void setEmailCc(Collection<String> emailCc) {
		this.emailCc = emailCc;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body, String mimeType) {
		this.body = body;
		this.mimeType = mimeType;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the auth
	 */
	public Boolean getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @param string
	 * @param string2
	 */
	public void emailAdmin(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			postMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

